package com.sviat.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sviat.demo.domain.Movie;

public interface MovieRepository extends CrudRepository<Movie, Integer> {

	List<Movie> findByName(String name);
	List<Movie> findByNameContaining(String word);
	List<Movie> findAll();

}
