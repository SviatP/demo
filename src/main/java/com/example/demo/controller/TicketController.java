package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Ticket;
import com.example.demo.repository.TicketRepository;

@RestController
@RequestMapping("/api/ticket")
public class TicketController {

	@Autowired
	private TicketRepository ticketRepository;

	@GetMapping("/all")
	public List<Ticket> findAll() {
		return ticketRepository.findAll();
	}
}
