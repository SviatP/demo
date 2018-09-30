package com.example.demo.domain;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.ToString;

@Entity
@Data
public class MovieSession {
	@Id
	Integer id;

	@ToString.Exclude

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "movie")
	Movie movie;
	LocalDateTime start;
	LocalDateTime end;

	@OneToMany(mappedBy = "session" )
	@ToString.Exclude
	List<Ticket> tickets;
}
