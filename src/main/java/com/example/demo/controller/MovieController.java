package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Cinema;
import com.example.demo.domain.Movie;
import com.example.demo.repository.CinemaRepository;
import com.example.demo.repository.MovieRepository;

@RestController
@RequestMapping("/api/movie")
public class MovieController {

	@Autowired
	private MovieRepository movieRepository;


	@GetMapping("/all")
	public List<Movie> findAll() {
		return movieRepository.findAll();
	}
}
