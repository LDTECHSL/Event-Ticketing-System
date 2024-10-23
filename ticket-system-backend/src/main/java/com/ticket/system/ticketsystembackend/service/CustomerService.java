package com.ticket.system.ticketsystembackend.service;

import com.ticket.system.ticketsystembackend.entity.Customer;
import com.ticket.system.ticketsystembackend.entity.TicketPool;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final TicketPool ticketPool;


    public CustomerService(TicketPool ticketPool) {
        this.ticketPool = ticketPool;
    }

    public void removeTickets(int vendorId, int ticketsToPurchase, int retrievalInterval) {
        Customer customer = new Customer(vendorId,ticketsToPurchase,retrievalInterval,ticketPool);
        Thread thread = new Thread(customer);
        thread.start();
    }
}

