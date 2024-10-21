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
            ticketPool.addTickets(vendorId, ticketsPerRelease);
            try {
                // Simulate the release interval
                Thread.sleep(releaseInterval);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Vendor " + vendorId + " was interrupted.");
            }
    }
}
