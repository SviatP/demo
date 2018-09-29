package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.domain.Cinema;

public interface CinemaRepository extends CrudRepository<Cinema, Long> {

	List<Cinema> findAll();
}
