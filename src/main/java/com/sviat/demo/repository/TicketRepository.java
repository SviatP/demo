package com.sviat.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sviat.demo.domain.Ticket;

public interface TicketRepository extends CrudRepository<Ticket, String> {

	List<Ticket> findAll();

}
