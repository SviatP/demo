package com.example.demo.domain;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.ToString;

@Entity
@Data
public class MovieSession {
	@Id
	@JsonIgnore
	Integer id;

	@ToString.Exclude

	@ManyToOne()
	@JoinColumn(name = "movie")
	Movie movie;
	@ManyToOne()
	@JoinColumn(name = "cinema")
	Cinema cinema;
	LocalDateTime start;
	LocalDateTime end;

	@OneToMany(mappedBy = "session" )
	@ToString.Exclude
	@JsonIgnore
	List<Ticket> tickets;
}
