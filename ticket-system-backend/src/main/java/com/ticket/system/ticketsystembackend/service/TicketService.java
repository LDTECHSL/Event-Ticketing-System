package com.ticket.system.ticketsystembackend.service;

import com.ticket.system.ticketsystembackend.entity.Ticket;
import com.ticket.system.ticketsystembackend.entity.User;
import com.ticket.system.ticketsystembackend.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public Ticket addTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public Ticket getTicketById(int id) {
        Optional<Ticket> ticket = ticketRepository.findById(id);
        if (ticket.isPresent()) {
            return ticket.get();
        } else {
            throw new RuntimeException("Ticket not found for id: " + id);
        }
    }

    public Ticket updateTicket(Ticket ticket) {
        Ticket existingTicket = ticketRepository.findById(ticket.getTicketId()).get();
        existingTicket.setPrice(ticket.getPrice());
        existingTicket.setDate(ticket.getDate());
        existingTicket.setTime(ticket.getTime());
        existingTicket.setVenue(ticket.getVenue());
        existingTicket.setEventName(ticket.getEventName());
        existingTicket.setTicketsPerRelease(ticket.getTicketsPerRelease());
        return ticketRepository.save(existingTicket);
    }

    public String deleteTicketById(int id) {
        if (ticketRepository.existsById(id)) {
            ticketRepository.deleteById(id);
            return "Ticket deleted: " + id;
        } else {
            return "Ticket not found for id: " + id;
        }
    }
}
