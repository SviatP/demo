package com.example.demo.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Predicate;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Movie;
import com.example.demo.domain.Ticket;
import com.example.demo.repository.MovieRepository;
import com.example.demo.repository.TicketRepository;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository movieRepository;
	@Autowired
	private TicketRepository ticketRepository;

	@Override
	public List<Movie> findAll() {
		return movieRepository.findAll();
	}

	@Override
	public List<Movie> findByNameContains(String word) {
		return movieRepository.findByNameContaining(word);
	}

	@Override
	public BigDecimal getIncome(String name, String period) {

		SessionPeriod sessionPeriod = SessionPeriod.valueOf(period.toUpperCase());

		Predicate<Ticket> match = ticket -> ticket.getSession().getMovie().getName().equals(name)
				&& ticket.getSession().getStart().getHour() >= sessionPeriod.getStart()
				&& ticket.getSession().getEnd().getHour() < sessionPeriod.getEnd();

		return ticketRepository.findAll().stream().filter(match).map(Ticket::getPrice).reduce(BigDecimal::add)
				.orElseThrow(() -> new WebApplicationException("cant find requested data", Response.Status.BAD_REQUEST));
	}

	public enum SessionPeriod {
		MORNING(9, 12),
		DAY(12, 18),
		EVENING(18, 24),
		NIGHT(0, 9),;

		SessionPeriod(int start, int end) {
			this.start = start;
			this.end = end;

		}
		private int start;
		private int end;

		public int getEnd() {
			return end;
		}

		public void setEnd(int end) {
			this.end = end;
		}

		public int getStart() {
			return start;
		}

		public void setStart(int start) {
			this.start = start;
		}
	}
}
