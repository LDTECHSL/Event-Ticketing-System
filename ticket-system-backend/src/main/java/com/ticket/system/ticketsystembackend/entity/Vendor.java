package com.ticket.system.ticketsystembackend.entity;

import com.ticket.system.ticketsystembackend.service.TicketService;

public class Vendor implements Runnable {
    private int vendorId;
    private int ticketsPerRelease;
    private int releaseInterval;
    private TicketPool ticketPool;
    private TicketService ticketService;
    private Ticket ticket;

    public Vendor(int vendorId, int ticketsPerRelease, int releaseInterval, TicketPool ticketPool) {
        this.vendorId = vendorId;
        this.ticketsPerRelease = ticketsPerRelease;
        this.releaseInterval = releaseInterval;
        this.ticketPool = ticketPool;
    }

    public Vendor(TicketService ticketService, Ticket ticket) {
        this.ticketService = ticketService;
        this.ticket = ticket;
    }

    public Vendor(Ticket ticket, int releaseInterval, TicketPool ticketPool) {
        this.ticket = ticket;
        this.releaseInterval = releaseInterval;
        this.ticketPool = ticketPool;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(releaseInterval);
                ticketPool.addTickets(ticket);
                break;  // Break the loop after releasing the tickets
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}

