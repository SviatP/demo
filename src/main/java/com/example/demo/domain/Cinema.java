package com.example.demo.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.ToString;

@Entity
@Data
public class Cinema {

	@Id
	@JsonIgnore
	Integer id;
	String name;
	String address;

	@ToString.Exclude
	@ManyToMany(mappedBy = "cinemas")
	@JsonIgnore
	List<Movie> movies;

	@ToString.Exclude
	@JsonIgnore
	@OneToMany(mappedBy = "cinema")
	List<MovieSession> sessions;
}
