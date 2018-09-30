package com.sviat.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sviat.demo.domain.MovieSession;

public interface MovieSessionRepository extends CrudRepository<MovieSession, Integer> {

	List<MovieSession> findAll();
	List<MovieSession> findByCinemaName(String cinemaName);
}
