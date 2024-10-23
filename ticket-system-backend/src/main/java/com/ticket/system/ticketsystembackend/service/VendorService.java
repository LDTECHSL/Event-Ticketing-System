package com.ticket.system.ticketsystembackend.service;

import com.ticket.system.ticketsystembackend.entity.Ticket;
import com.ticket.system.ticketsystembackend.entity.TicketPool;
import com.ticket.system.ticketsystembackend.entity.Vendor;
import org.springframework.stereotype.Service;

@Service
public class VendorService {
    private final TicketPool ticketPool;

    public VendorService(TicketPool ticketPool) {
        this.ticketPool = ticketPool;
    }

    public void addTickets(Ticket ticket,int releaseInterval) {
        Vendor vendor = new Vendor(ticket,releaseInterval);
        Thread thread = new Thread(vendor);
        thread.start();
    }

    public Ticket getTicketCountByVendorId(int vendorId) {
        return ticketPool.getTicketCountByVendorId(vendorId);
    }
}

