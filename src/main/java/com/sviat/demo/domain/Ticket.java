package com.sviat.demo.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class Ticket {
	@Id
	@JsonIgnore
	Integer id;
	String client;
	@ManyToOne
	@JoinColumn(name = "session")
	MovieSession session;
	@Column(name = "cost")
	BigDecimal price;
}
