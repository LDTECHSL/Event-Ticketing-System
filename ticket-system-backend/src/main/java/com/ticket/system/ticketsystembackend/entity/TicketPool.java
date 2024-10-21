package com.ticket.system.ticketsystembackend.entity;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TicketPool {
    private final Map<String, Integer> tickets;

    public TicketPool() {
        // Using a synchronized map to ensure thread-safe access
        tickets = Collections.synchronizedMap(new HashMap<>());
    }

    // Add tickets by the vendor (synchronized for thread safety)
    public synchronized void addTickets(String vendorId, int ticketsToAdd) {
        tickets.put(vendorId, tickets.getOrDefault(vendorId, 0) + ticketsToAdd);
        System.out.println(ticketsToAdd + " tickets added for vendor " + vendorId + ". Total tickets: " + tickets.get(vendorId));
        notifyAll(); // Notify waiting customers that tickets are available
    }

    // Remove a ticket by the customer (synchronized for thread safety)
    public synchronized String removeTicket(int vendorId,int ticketsToRemove) {
        tickets.put(String.valueOf(vendorId), tickets.getOrDefault(vendorId, 0) + ticketsToRemove);
        System.out.println("Ticket purchased from vendor " + vendorId + ". Tickets left: " + ticketsToRemove);

        // Notify that a ticket has been removed
        return String.valueOf(vendorId); // Return the vendorId or any other identifier
    }

    // Optional: To check the number of tickets available for a specific vendor
    public synchronized int getTicketCount(String vendorId) {
        return tickets.getOrDefault(vendorId, 0);
    }
}
