package com.ticket.system.ticketsystembackend.service;

import com.ticket.system.ticketsystembackend.entity.TicketPool;
import org.springframework.stereotype.Service;

@Service
public class VendorService {
    private final TicketPool ticketPool;

    public VendorService(TicketPool ticketPool) {
        this.ticketPool = ticketPool;
    }

    public void addTickets(int vendorId, int ticketsPerRelease) {
        ticketPool.addTickets(vendorId, ticketsPerRelease);
    }

    public int getTicketCountByVendorId(int vendorId) {
        return ticketPool.getTicketCountByVendorId(vendorId);
    }
}

