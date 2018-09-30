package com.sviat.demo.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@Builder
public class Movie {

	@Id
	@JsonIgnore
	Integer id;
	String name;
	Long duration;

	@OneToMany()
	@JsonIgnore
	List<MovieSession> sessions;

	@ManyToMany()
	@JsonIgnore
	@ToString.Exclude
	@JoinTable(name = "cinema_movie",
			joinColumns = { @JoinColumn(name = "cinema_id") },
			inverseJoinColumns = { @JoinColumn(name = "movie_id") })
	List<Cinema> cinemas;
}
