package com.sviat.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import com.sviat.demo.domain.Cinema;

public interface CinemaService {

	/**
	 * Its just for testing, shouldn't be tested and/or used for task purpose
	 * @return all {@link Cinema} stored at DB
	 */
	List<Cinema> findAll();

	/**
	 * Provide info about Cinema with specified count of movieSessions per period
	 * @param start start of period
	 * @param end end of period
	 * @param count number of session looked for
	 * @return list of {@link Cinema}
	 */
	List<Cinema> findBySessionCount(LocalDateTime start, LocalDateTime end, int count);

	/**
	 * Provide list of brakes between sessions in specified cinema which are longer than 15 minutes
	 * @param start start of search period
	 * @param end end of search period
	 * @param cinemaName used to specify cinema
	 * @return list of brakes in format hh:mm - hh:mm
	 */
	List<String> findBrakes(LocalDateTime start, LocalDateTime end, String cinemaName);
}
