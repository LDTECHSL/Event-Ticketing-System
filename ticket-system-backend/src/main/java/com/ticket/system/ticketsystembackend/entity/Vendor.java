package com.ticket.system.ticketsystembackend.entity;

public class Vendor implements Runnable {
    private int vendorId;
    private int ticketsPerRelease;
    private int releaseInterval;
    private TicketPool ticketPool;

    public Vendor(int vendorId, int ticketsPerRelease, int releaseInterval, TicketPool ticketPool) {
        this.vendorId = vendorId;
        this.ticketsPerRelease = ticketsPerRelease;
        this.releaseInterval = releaseInterval;
        this.ticketPool = ticketPool;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(releaseInterval);
                ticketPool.addTickets(vendorId, ticketsPerRelease);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

