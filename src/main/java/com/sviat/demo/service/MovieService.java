package com.sviat.demo.service;

import java.math.BigDecimal;
import java.util.List;

import com.sviat.demo.domain.Movie;

public interface MovieService {
	List<Movie> findByNameContains(String word);
	BigDecimal getIncome(String name, String period);
}
