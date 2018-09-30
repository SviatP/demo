package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.domain.Movie;

public interface MovieRepository extends CrudRepository<Movie, Integer> {

	List<Movie> findByName(String name);
	List<Movie> findAll();

}
