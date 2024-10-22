package com.ticket.system.ticketsystembackend.entity;

import java.util.Vector;

public class TicketPool {
    private final Vector<Ticket> tickets = new Vector<>();

    public synchronized void addTickets(int vendorId, int ticketsPerRelease, int releaseInterval) {
        boolean found = false;
        for (Ticket ticket : tickets) {
            if (ticket.getVendorId() == vendorId) {
                ticket.setTicketsPerRelease(ticket.getTicketsPerRelease() + ticketsPerRelease);
                found = true;
                break;
            }
        }
        if (!found) {
            tickets.add(new Ticket(vendorId, ticketsPerRelease));
        }
    }

    public synchronized void removeTickets(int vendorId, int ticketsToPurchase, int retrievalInterval) {
        for (Ticket ticket : tickets) {
            if (ticket.getVendorId() == vendorId) {
                int currentCount = ticket.getTicketsPerRelease();
                if (currentCount >= ticketsToPurchase) {
                    ticket.setTicketsPerRelease(currentCount - ticketsToPurchase);
                }
                break;
            }
        }
    }

    public synchronized int getTicketCountByVendorId(int vendorId) {
        for (Ticket ticket : tickets) {
            if (ticket.getVendorId() == vendorId) {
                return ticket.getTicketsPerRelease();
            }
        }
        return 0;
    }
}
