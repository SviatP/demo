package com.example.demo.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Movie {

	@Id
	Integer id;
	String name;
	Long duration;

	@OneToMany
	List<MovieSession> sessions;

	@ManyToMany
	@JoinTable(name = "[cinema_movie]")
	List<Cinema> cinemas;
}
