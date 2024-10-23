package com.ticket.system.ticketsystembackend.entity;

import java.util.Vector;

public class TicketPool {
    private final Vector<Ticket> tickets = new Vector<>();

    public synchronized void addTickets(Ticket t) {
        boolean found = false;
        for (Ticket ticket : tickets) {
            if (ticket.getVendorId() == t.getVendorId()) {
                found = true;
                break;
            }
        }
        if (!found) {
            tickets.add(new Ticket(t.getVendorId(), t.getTicketsPerRelease(), t.getEventName(), t.getVenue(), t.getDate(), t.getTime(), t.getPrice()));
        }
    }

    public synchronized void removeTickets(int vendorId, int ticketsToPurchase, int retrievalInterval) {
        for (Ticket ticket : tickets) {
            if (ticket.getVendorId() == vendorId) {
                int currentCount = ticket.getTicketsPerRelease();
                if (currentCount >= ticketsToPurchase) {
                    ticket.setTicketsPerRelease(currentCount - ticketsToPurchase);
                }
            }
        }
    }

    public synchronized Ticket getTicketCountByVendorId(int vendorId) {
        for (Ticket ticket : tickets) {
            if (ticket.getVendorId() == vendorId) {
                return ticket;
            }
        }
        return null;
    }
}
