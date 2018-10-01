package com.sviat.demo.service;

import java.math.BigDecimal;
import java.util.List;

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
	 * @param period specified period of session (like morning, day, evening, night)
	 * @return calculated income
	 */
	BigDecimal getIncome(String name, String period);
}
