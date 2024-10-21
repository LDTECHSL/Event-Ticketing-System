package com.ticket.system.ticketsystembackend.controller;

import com.ticket.system.ticketsystembackend.entity.Customer;
import com.ticket.system.ticketsystembackend.entity.TicketPool;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    private final TicketPool ticketPool;
    private final ExecutorService executorService;

    public CustomerController() {
        this.ticketPool = new TicketPool(); // Initialize the ticket pool
        this.executorService = Executors.newCachedThreadPool(); // Create a thread pool for customers
    }

    // Endpoint to add a customer
    @PostMapping("/remove-ticket")
    public String removeTicket(
            @RequestParam int vendorId,
            @RequestParam int customerId,
            @RequestParam long retrievalInterval,
            @RequestParam int ticketsToPurchase
    ) {
        // Create and start a new customer thread
        Customer customer = new Customer(ticketPool, vendorId, customerId, retrievalInterval, ticketsToPurchase);
        executorService.submit(customer);

        return "Customer " + customerId + " started purchasing tickets from vendor " + vendorId + ".";
    }
}
