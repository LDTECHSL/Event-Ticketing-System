package com.ticket.system.ticketsystembackend.controller;
import com.ticket.system.ticketsystembackend.service.CustomerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/removeTickets")
    public void removeTickets(@RequestParam int vendorId, @RequestParam int ticketsToPurchase, @RequestParam int retrievalInterval) {
        customerService.removeTickets(vendorId, ticketsToPurchase, retrievalInterval);
    }
}
