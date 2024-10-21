package com.ticket.system.ticketsystembackend.entity;

import java.util.List;
import java.util.ArrayList;

public class Vendor implements Runnable {
    private final TicketPool ticketPool;
    private final String vendorId;
    private final int ticketsPerRelease;
    private final long releaseInterval;

    public Vendor(TicketPool ticketPool, String vendorId, int ticketsPerRelease, long releaseInterval) {
        this.ticketPool = ticketPool;
        this.vendorId = vendorId;
        this.ticketsPerRelease = ticketsPerRelease;
        this.releaseInterval = releaseInterval;
    }


    @Override
    public void run() {
        while (true) {
            List<String> newTickets = generateTickets();
            ticketPool.addTickets(newTickets);
            try {
                // Simulate the release interval
                Thread.sleep(releaseInterval);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Vendor " + vendorId + " was interrupted.");
            }
        }
    }

    private List<String> generateTickets() {
        List<String> tickets = new ArrayList<>();
        for (int i = 1; i <= ticketsPerRelease; i++) {
            tickets.add(vendorId + "-Ticket-" + i);
        }
        System.out.println("Vendor " + vendorId + " generated " + ticketsPerRelease + " tickets.");
        return tickets;
    }
}
