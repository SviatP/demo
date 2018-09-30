package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Movie;
import com.example.demo.domain.MovieSession;
import com.example.demo.repository.MovieSessionRepository;

@RestController
@RequestMapping("/api/session")
public class MovieSessionController {

	@Autowired
	private MovieSessionRepository sessionRepository;

	@GetMapping("/all")
	public List<MovieSession> findAll() {
		return sessionRepository.findAll();
	}
}
