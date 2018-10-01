package com.sviat.demo.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;

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

}
