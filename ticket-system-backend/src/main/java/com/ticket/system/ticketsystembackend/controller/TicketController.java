package com.ticket.system.ticketsystembackend.controller;

import com.ticket.system.ticketsystembackend.entity.Ticket;
import com.ticket.system.ticketsystembackend.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping("/add-ticket")
    public Ticket addTicket(@RequestBody Ticket ticket) {
        return ticketService.addTicket(ticket);
    }

    @GetMapping("/get-tickets")
    public List<Ticket> getAllTickets() {
        return ticketService.getAllTickets();
    }

    @GetMapping("/get-ticket/{id}")
    public Ticket getTicketById(@PathVariable int id) {
        return ticketService.getTicketById(id);
    }

    @PutMapping("/update-ticket")
    public Ticket updateTicket(@RequestBody Ticket ticket) {
        return ticketService.updateTicket(ticket);
    }

    @DeleteMapping("/delete-ticket/{id}")
    public String deleteTicketById(@PathVariable int id) {
        return ticketService.deleteTicketById(id);
    }
}
