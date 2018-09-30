package com.example.demo.controller;

import static com.example.demo.DateUtils.fromStingWithoutTime;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

	@GetMapping("/session")
	public List<Cinema> findBySessionCount(@RequestParam(value = "start") String start, @RequestParam(value = "end") String end,
			@RequestParam(value = "count") Integer count) {
		LocalDateTime startDate = fromStingWithoutTime(start);
		LocalDateTime endDate = fromStingWithoutTime(end);
		return cinemaService.findBySessionCount(startDate, endDate, count);
	}

	@GetMapping("/{cinema}/brakes")
	public List<String> findBreaks(@RequestParam(value = "start") String start, @RequestParam(value = "end") String end,
			@PathVariable(value = "cinema") String cinema) {
		LocalDateTime startDate = fromStingWithoutTime(start);
		LocalDateTime endDate = fromStingWithoutTime(end);
		return cinemaService.findBrakes(startDate, endDate, cinema);
	}
}
