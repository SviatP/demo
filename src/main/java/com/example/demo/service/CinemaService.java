package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.Cinema;

public interface CinemaService {
	List<Cinema> findAll();
	List<Cinema> findBySessionCount(int count);
}
