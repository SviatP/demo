package com.example.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.domain.Cinema;

public interface CinemaRepository extends CrudRepository<Cinema, Integer>{

	List<Cinema> findAll();

	Cinema findByName(String name);

	@Query(value = "SELECT c.id, c.address, c.name FROM cinema c JOIN ( SELECT * FROM movie_session WHERE end <= :date) s ON c.id = s.cinema GROUP BY s.cinema HAVING  COUNT(s.cinema) > :count;",
	nativeQuery = true)
	List<Cinema> findCinemaBySessionCount(@Param("date") LocalDateTime date, @Param("count") Integer count);
}
