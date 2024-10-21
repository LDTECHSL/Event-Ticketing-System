package com.ticket.system.ticketsystembackend.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TicketPool {
    private final List<String> tickets;

    public TicketPool() {
        // Using a synchronizedList to ensure thread-safe access to the list
        tickets = Collections.synchronizedList(new ArrayList<>());
    }

    // Add tickets by the vendor (synchronized for thread safety)
    public synchronized void addTickets(List<String> newTickets) {
        tickets.addAll(newTickets);
        System.out.println(newTickets.size() + " tickets added to the pool. Total tickets: " + tickets.size());
        notifyAll(); // Notify waiting customers that tickets are available
    }

    // Remove a ticket by the customer (synchronized for thread safety)
    public synchronized String removeTicket() {
        while (tickets.isEmpty()) {
            try {
                System.out.println("No tickets available. Waiting for new tickets...");
                wait(); // Wait until new tickets are added
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread interrupted while waiting for tickets.");
                return null;
            }
        }

        String ticket = tickets.remove(0);
        System.out.println("Ticket purchased: " + ticket + ". Tickets left: " + tickets.size());
        return ticket;
    }
}
