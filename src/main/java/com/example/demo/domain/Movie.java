package com.example.demo.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.ToString;

@Entity
@Data
public class Movie {

	@Id
	Integer id;
	String name;
	Long duration;

	@OneToMany(fetch = FetchType.EAGER)
	List<MovieSession> sessions;

	@ManyToMany(fetch = FetchType.LAZY)
	@ToString.Exclude
	@JoinTable(name = "cinema_movie",
			joinColumns = { @JoinColumn(name = "cinema_id") },
			inverseJoinColumns = { @JoinColumn(name = "movie_id") })
	List<Cinema> cinemas;
}
