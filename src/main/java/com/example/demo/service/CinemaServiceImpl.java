package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Cinema;
import com.example.demo.repository.CinemaRepository;

@Service
public class CinemaServiceImpl implements CinemaService {

	@Autowired
	private CinemaRepository cinemaRepository;

	@Override
	public List<Cinema> findAll() {
		return cinemaRepository.findAll();
	}

	@Override
	public List<Cinema> findBySessionCount(int count) {
		return cinemaRepository.findBySessionsCount(count);
	}
}
