package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.domain.Cinema;

public interface CinemaRepository extends CrudRepository<Cinema, Integer> {

	List<Cinema> findAll();
	@Query(
			value = "SELECT * FROM USERS u WHERE u.status = 1",
			nativeQuery = true)
	List<Cinema> findBySessionsCount(int count);
}
