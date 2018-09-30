package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Ticket {
	@Id
	Integer id;
	String client;
	@ManyToOne
	@JoinColumn(name = "session")
	MovieSession session;
}
