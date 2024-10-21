package com.ticket.system.ticketsystembackend.entity;

import java.util.ArrayList;
import java.util.List;

public class Customer implements Runnable {
    private final TicketPool ticketPool;
    private final int vendorId;
    private final int customerId;
    private final long retrievalInterval;
    private final int ticketsToPurchase;

    public Customer(TicketPool ticketPool, int vendorId, int customerId, long retrievalInterval, int ticketsToPurchase) {
        this.ticketPool = ticketPool;
        this.vendorId = vendorId;
        this.customerId = customerId;
        this.retrievalInterval = retrievalInterval;
        this.ticketsToPurchase = ticketsToPurchase;
    }

    @Override
    public void run() {
        int purchaseCount = 0; // Track the number of successful purchases

            List<String> purchasedTickets = new ArrayList<>();
                String purchasedTicket = ticketPool.removeTicket(vendorId,ticketsToPurchase);
                    purchasedTickets.add(purchasedTicket);
                    purchaseCount++; // Increment the successful purchase count


            if (!purchasedTickets.isEmpty()) {
                System.out.println("Customer " + customerId + " purchased tickets: " + purchasedTickets);
            } else {
                System.out.println("Customer " + customerId + " could not purchase any tickets.");
            }

            try {
                // Simulate the interval between ticket retrieval attempts
                Thread.sleep(retrievalInterval);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Customer " + customerId + " was interrupted.");
            }
    }
}
