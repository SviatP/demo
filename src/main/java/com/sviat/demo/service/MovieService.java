package com.sviat.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import com.sviat.demo.dto.IncomeDto;
import com.sviat.demo.domain.Movie;

public interface MovieService {

	/**
	 * Provides list of movies by name or by part of name
	 * @param word is search key
	 * @return list of {@link Movie}
	 */
	List<Movie> findByNameContains(String word);

	/**
	 * Provide information about sales and income over all cinemas for specified movie and period
	 * @param name is movie name
	 * @param start specified period of session
	 * @param end specified period of session
	 * @return calculated income {@link IncomeDto}
	 */
	IncomeDto getIncome(String name, LocalDateTime start, LocalDateTime end);
}
