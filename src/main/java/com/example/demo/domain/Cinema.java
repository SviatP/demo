package com.example.demo.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.ToString;

@Entity
@Data
public class Cinema {

	@Id
	Integer id;
	String name;
	String address;

	@ToString.Exclude
	@ManyToMany(mappedBy = "cinemas")
	List<Movie> movies;

	@ToString.Exclude
	@OneToMany
	List<MovieSession> sessions;
}
