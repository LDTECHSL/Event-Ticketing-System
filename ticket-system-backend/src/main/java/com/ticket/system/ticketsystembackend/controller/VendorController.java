package com.ticket.system.ticketsystembackend.controller;

import com.ticket.system.ticketsystembackend.entity.TicketPool;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vendor")
public class VendorController {

    private final TicketPool ticketPool;

    public VendorController(TicketPool ticketPool) {
        this.ticketPool = ticketPool;
    }

    // POST endpoint to add tickets
    @PostMapping("/add-tickets")
    public String addTickets(@RequestBody List<String> newTickets) {
        ticketPool.addTickets(newTickets);
        return newTickets.size() + " tickets added successfully!";
    }
}
