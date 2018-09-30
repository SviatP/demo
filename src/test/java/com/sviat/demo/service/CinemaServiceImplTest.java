package com.sviat.demo.service;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.sviat.demo.domain.Cinema;
import com.sviat.demo.domain.Movie;
import com.sviat.demo.domain.MovieSession;
import com.sviat.demo.repository.CinemaRepository;
import com.sviat.demo.repository.MovieSessionRepository;
import com.google.common.collect.ImmutableList;

@RunWith(MockitoJUnitRunner.class)
public class CinemaServiceImplTest {

	@Mock
	private CinemaRepository cinemaRepository;
	@Mock
	private MovieSessionRepository sessionRepository;
	@InjectMocks
	private CinemaServiceImpl service;

	@Test
	public void findBySessionCount() throws Exception {
		when(cinemaRepository.findAll()).thenReturn(getCinemas());
		List<Cinema> result = service.findBySessionCount(
				LocalDateTime.of(2012, 10, 10, 8, 0, 0),
				LocalDateTime.of(2012, 10, 10, 11, 30, 0),
				3);
		assertThat(result.size(), is(1));
		assertThat(result.get(0).getName(), is("TestCinema"));
	}

	@Test
	public void findBrakes() throws Exception {
		when(sessionRepository.findByCinemaName(anyString())).thenReturn(getSessions());
		List<String> result = service.findBrakes(
				LocalDateTime.of(2012, 10, 10, 8, 0, 0),
				LocalDateTime.of(2013, 10, 10, 11, 30, 0),
				"TestCinema");
		assertThat(result.size(), is(1));
		assertThat(result.get(0), is("10:30 - 12:40"));
	}

	private List<Cinema> getCinemas() {
		return ImmutableList.of(Cinema.builder().name("TestCinema").sessions(getSessions()).build());
	}

	private List<MovieSession> getSessions() {
		return ImmutableList.of(
				MovieSession.builder()
						.movie(Movie.builder().name("Astral").build())
						.start(LocalDateTime.of(2012, 10, 10, 9, 0, 0))
						.end(LocalDateTime.of(2012, 10, 10, 10, 30, 0))
						.build(),
				MovieSession.builder()
						.movie(Movie.builder().name("Astral2").build())
						.start(LocalDateTime.of(2012, 10, 10, 9, 0, 0))
						.end(LocalDateTime.of(2012, 10, 10, 10, 30, 0))
						.build(),
				MovieSession.builder()
						.movie(Movie.builder().name("Watchers").build())
						.start(LocalDateTime.of(2012, 10, 10, 9, 0, 0))
						.end(LocalDateTime.of(2012, 10, 10, 10, 30, 0))
						.build(),
				MovieSession.builder()
						.movie(Movie.builder().name("Hangover").build())
						.start(LocalDateTime.of(2012, 10, 10, 9, 0, 0))
						.end(LocalDateTime.of(2012, 10, 10, 10, 30, 0))
						.build(),
				MovieSession.builder()
						.movie(Movie.builder().name("Astral").build())
						.start(LocalDateTime.of(2012, 10, 10, 10, 30, 0))
						.end(LocalDateTime.of(2012, 10, 10, 12, 0, 0))
						.build(),
				MovieSession.builder()
						.movie(Movie.builder().name("HaveBrake").build())
						.start(LocalDateTime.of(2012, 10, 10, 12, 40, 0))
						.end(LocalDateTime.of(2012, 10, 10, 14, 30, 0))
						.build());
	}

}