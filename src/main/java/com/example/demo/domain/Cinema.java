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
public class Cinema {

	@Id
	Integer id;
	String name;
	String address;

	@ManyToMany
	@JoinTable(name = "[cinema_movie]")
	List<Movie> movies;

	@OneToMany
	List<MovieSession> sessions;
}
