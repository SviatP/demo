package com.sviat.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sviat.demo.domain.Movie;
import com.sviat.demo.domain.Ticket;
import com.sviat.demo.dto.IncomeDto;
import com.sviat.demo.dto.SessionPeriod;
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
	public IncomeDto getIncome(String name, LocalDateTime start, LocalDateTime end) {

		Predicate<Ticket> match = ticket -> ticket.getSession().getMovie().getName().equals(name)
				&& ticket.getSession().getStart().isAfter(start)
				&& ticket.getSession().getStart().isBefore(end);

		Map<SessionPeriod, BigDecimal> map = new HashMap<>();
		Arrays.stream(SessionPeriod.values()).forEach(period -> map.put(period, BigDecimal.ZERO));

		IncomeDto incomeDto = IncomeDto.builder()
				.start(start).end(end)
				.periodMap(map)
				.generalIncome(BigDecimal.ZERO)
				.build();

		ticketRepository.findAll().stream().filter(match).forEach(ticket -> applyTicketIncome(incomeDto, ticket));

		return incomeDto;
	}

	private void applyTicketIncome(IncomeDto incomeDto, Ticket ticket) {
		SessionPeriod period = SessionPeriod.fromHours(ticket.getSession().getStart().getHour());
		BigDecimal previous = incomeDto.getPeriodMap().get(period);
		incomeDto.getPeriodMap().put(period, previous.add(ticket.getPrice()));
		incomeDto.setGeneralIncome(incomeDto.getGeneralIncome().add(ticket.getPrice()));
	}
}
