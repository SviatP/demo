package com.sviat.demo.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sviat.demo.domain.Movie;
import com.sviat.demo.domain.Ticket;
import com.sviat.demo.repository.MovieRepository;
import com.sviat.demo.repository.TicketRepository;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository movieRepository;
	@Autowired
	private TicketRepository ticketRepository;

	@Override
	public List<Movie> findByNameContains(String word) {
		return movieRepository.findByNameContaining(word);
	}

	@Override
	public BigDecimal getIncome(String name, String period) {
		try {
			SessionPeriod sessionPeriod = SessionPeriod.valueOf(period.toUpperCase());
			Predicate<Ticket> match = ticket -> ticket.getSession().getMovie().getName().equals(name)
					&& ticket.getSession().getStart().getHour() >= sessionPeriod.getStart()
					&& ticket.getSession().getEnd().getHour() < sessionPeriod.getEnd();

			return ticketRepository.findAll().stream().filter(match).map(Ticket::getPrice).reduce(BigDecimal::add)
					.orElseThrow(() -> new IllegalStateException("cant find requested data"));
		} catch (IllegalArgumentException e) {
			//logging and catch logic (generating WebApplicationException or above)
			throw new IllegalStateException("bad requested period");
		}
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
