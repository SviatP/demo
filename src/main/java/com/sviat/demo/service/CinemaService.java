package com.sviat.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import com.sviat.demo.domain.Cinema;

public interface CinemaService {
	List<Cinema> findAll();
	List<Cinema> findBySessionCount(LocalDateTime start, LocalDateTime end, int count);
	List<String> findBrakes(LocalDateTime start, LocalDateTime end, String cinemaName);
}
