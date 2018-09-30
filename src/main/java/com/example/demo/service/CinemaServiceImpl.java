package com.example.demo.service;

import static java.util.stream.Collectors.toList;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Cinema;
import com.example.demo.domain.MovieSession;
import com.example.demo.repository.CinemaRepository;
import com.example.demo.repository.MovieSessionRepository;

@Service
public class CinemaServiceImpl implements CinemaService {

	@Autowired
	private CinemaRepository cinemaRepository;
	@Autowired
	private MovieSessionRepository sessionRepository;


	@Override
	public List<Cinema> findAll() {
		return cinemaRepository.findAll();
	}

	@Override
	public List<Cinema> findBySessionCount(LocalDateTime start, LocalDateTime end, int count) {
		final Predicate<MovieSession> movieSessionPredicate = movieSession -> movieSession.getStart().isAfter(start)
				&& movieSession.getEnd().isBefore(end);
		return cinemaRepository.findAll().stream().filter(cinema -> cinema.getSessions().stream()
				.filter(movieSessionPredicate).count() > count).collect(
				toList());
	}

	@Override
	public List<String> findBrakes(LocalDateTime start, LocalDateTime end, String cinemaName) {
		final Predicate<MovieSession> movieSessionPredicate = movieSession -> movieSession.getStart().isAfter(start)
				&& movieSession.getEnd().isBefore(end);

		List<String> ads = new ArrayList<>();
		sessionRepository.findByCinemaName(cinemaName).stream().filter(movieSessionPredicate)
				.reduce((movieSession, movieSession2) -> {
						if (ChronoUnit.MINUTES.between(movieSession.getEnd(), movieSession2.getStart()) >= 15) {
							ads.add(movieSession.getEnd().toLocalTime().toString().concat(" - ").concat(movieSession2.getStart().toLocalTime().toString()));
						}
					return movieSession;
				});
		return ads;
	}

//	private List<String> filtered(List<MovieSession> list) {
//		List<String> ads = new ArrayList<>();
//		list.stream().reduce()
//
//
//	}

	public static void main(String[] args) {
		System.out.println(ChronoUnit.MINUTES.between(LocalDateTime.of(2018, 10, 1, 0,0,0),
				LocalDateTime.of(2018, 10, 1, 0,20,0)));
	}
}
