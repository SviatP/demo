package com.example.demo.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Movie;
import com.example.demo.service.MovieService;

@RestController
@RequestMapping("/api/movie")
public class MovieController {

	@Autowired
	private MovieService movieService;


	@GetMapping("/all")
	public List<Movie> findAll() {
		return movieService.findAll();
	}


	@GetMapping("/search")
	public List<Movie> findByName(@RequestParam(value = "name") String name) {
		return movieService.findByNameContains(name);
	}

	@GetMapping("/{name}/calculate")
	public BigDecimal calculate(@PathVariable(value = "name") String name, @RequestParam(value = "period") String period) {
		return movieService.getIncome(name, period);
	}

}
