package com.example.demo.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Cinema;
import com.example.demo.service.CinemaServiceImpl;

@RestController
@RequestMapping("/api/cinema")
public class CinemaController {

	@Autowired
	private CinemaServiceImpl cinemaService;


	@GetMapping("/all")
	public List<Cinema> findAll() {
		return cinemaService.findAll();
	}

	@GetMapping("/session/{count}")
	public List<Cinema> findBySessionCount(@PathVariable(value = "count") Integer count) {
		return cinemaService.findBySessionCount(count);
	}
}
