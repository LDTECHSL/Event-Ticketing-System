package com.ticket.system.ticketsystembackend.repository;

import com.ticket.system.ticketsystembackend.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
}
