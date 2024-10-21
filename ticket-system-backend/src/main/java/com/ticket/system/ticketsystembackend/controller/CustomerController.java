package com.ticket.system.ticketsystembackend.controller;

import com.ticket.system.ticketsystembackend.entity.TicketPool;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    private final TicketPool ticketPool;

    public CustomerController(TicketPool ticketPool) {
        this.ticketPool = ticketPool;
    }

    // POST endpoint to remove a ticket
    @PostMapping("/purchaseTicket")
    public String purchaseTicket() {
        String purchasedTicket = ticketPool.removeTicket();
        if (purchasedTicket != null) {
            return "Ticket purchased successfully: " + purchasedTicket;
        } else {
            return "No tickets available to purchase.";
        }
    }
}
