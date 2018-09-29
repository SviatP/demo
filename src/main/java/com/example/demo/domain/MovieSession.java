package com.example.demo.domain;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class MovieSession {
	@Id
	Integer id;
	@ManyToOne
	Movie movie;
	LocalDateTime start;
	LocalDateTime end;

	@OneToMany
	List<Ticket> tickets;
}
