package com.ticket.system.ticketsystembackend.entity;

public class Customer implements Runnable {
    private int vendorId;
    private int customerId;
    private int retrievalInterval;
    private int ticketsToPurchase;
    private TicketPool ticketPool;

    public Customer(int vendorId, int customerId, int retrievalInterval, int ticketsToPurchase, TicketPool ticketPool) {
        this.vendorId = vendorId;
        this.customerId = customerId;
        this.retrievalInterval = retrievalInterval;
        this.ticketsToPurchase = ticketsToPurchase;
        this.ticketPool = ticketPool;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(retrievalInterval);
                ticketPool.removeTickets(vendorId, ticketsToPurchase, retrievalInterval);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
