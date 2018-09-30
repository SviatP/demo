package com.sviat.demo.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.sviat.demo.domain.Movie;
import com.sviat.demo.domain.MovieSession;
import com.sviat.demo.domain.Ticket;
import com.sviat.demo.repository.MovieRepository;
import com.sviat.demo.repository.TicketRepository;
import com.google.common.collect.ImmutableList;

@RunWith(MockitoJUnitRunner.class)
public class MovieServiceImplTest {

	@Mock
	private MovieRepository movieRepository;
	@Mock
	private TicketRepository ticketRepository;
	@InjectMocks
	private MovieServiceImpl movieService;

	@Test
	public void findByNameContains() throws Exception {
		movieService.findByNameContains("testStr");
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(movieRepository).findByNameContaining(captor.capture());
		assertThat(captor.getValue(), is("testStr"));
	}

	@Test
	public void getIncome() throws Exception {
		when(ticketRepository.findAll()).thenReturn(getTickets());
		BigDecimal result = movieService.getIncome("Astral", "morning");
		Assert.assertThat(result, is(BigDecimal.valueOf(30)));
	}


	@Test
	public void getIncome_invalidPeriod() throws Exception {
		try {
			movieService.getIncome("Astral", "moarning");
			fail();
		} catch (IllegalStateException e) {
			Assert.assertThat(e.getMessage(), is("bad requested period"));
		}

	}

	@Test
	public void getIncome_invalidMovie() throws Exception {
		when(ticketRepository.findAll()).thenReturn(getTickets());
		try {
			movieService.getIncome("asd", "morning");
			fail();
		} catch (IllegalStateException e) {
			Assert.assertThat(e.getMessage(), is("cant find requested data"));
		}

	}

	private List<Ticket> getTickets() {
		return ImmutableList.of(
				Ticket.builder().session(
						MovieSession.builder()
								.movie(Movie.builder().name("Astral").build())
								.start(LocalDateTime.of(2012, 10, 10, 9, 0, 0))
								.end(LocalDateTime.of(2012, 10, 10, 10, 30, 0))
								.build())
						.price(BigDecimal.TEN)
						.build(),
				Ticket.builder().session(
						MovieSession.builder()
								.movie(Movie.builder().name("Astral").build())
								.start(LocalDateTime.of(2012, 10, 10, 9, 0, 0))
								.end(LocalDateTime.of(2012, 10, 10, 10, 30, 0))
								.build())
						.price(BigDecimal.TEN)
						.build(),
				Ticket.builder().session(
						MovieSession.builder()
								.movie(Movie.builder().name("Astral").build())
								.start(LocalDateTime.of(2012, 10, 10, 9, 0, 0))
								.end(LocalDateTime.of(2012, 10, 10, 10, 30, 0))
								.build())
						.price(BigDecimal.TEN)
						.build(),
				Ticket.builder().session(
						MovieSession.builder()
								.movie(Movie.builder().name("Astral").build())
								.start(LocalDateTime.of(2012, 10, 10, 12, 0, 0))
								.end(LocalDateTime.of(2012, 10, 10, 14, 30, 0))
								.build())
						.price(BigDecimal.TEN)
						.build(),
				Ticket.builder().session(
						MovieSession.builder()
								.movie(Movie.builder().name("Astral").build())
								.start(LocalDateTime.of(2012, 10, 10, 13, 0, 0))
								.end(LocalDateTime.of(2012, 10, 10, 15, 30, 0))
								.build())
						.price(BigDecimal.TEN)
						.build()

		);
	}

}