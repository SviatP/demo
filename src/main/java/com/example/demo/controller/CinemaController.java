package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Cinema;
import com.example.demo.repository.CinemaRepository;

@RestController
@RequestMapping("/api")
public class CinemaController {

	@Autowired
	private CinemaRepository cinemaRepository;


	@GetMapping("/all")
	public List<Cinema> findAll() {
		return cinemaRepository.findAll();
	}
}
