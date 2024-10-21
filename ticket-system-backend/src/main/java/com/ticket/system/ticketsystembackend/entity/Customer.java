package com.ticket.system.ticketsystembackend.entity;
import java.util.ArrayList;
import java.util.List;

public class Customer implements Runnable {
    private final TicketPool ticketPool;
    private final String customerId;
    private final long retrievalInterval;
    private final int ticketsToPurchase;

    public Customer(TicketPool ticketPool, String customerId, long retrievalInterval, int ticketsToPurchase) {
        this.ticketPool = ticketPool;
        this.customerId = customerId;
        this.retrievalInterval = retrievalInterval;
        this.ticketsToPurchase = ticketsToPurchase;
    }

    @Override
    public void run() {
        while (true) {
            List<String> purchasedTickets = new ArrayList<>();
            for (int i = 0; i < ticketsToPurchase; i++) {
                String purchasedTicket = ticketPool.removeTicket();
                if (purchasedTicket != null) {
                    purchasedTickets.add(purchasedTicket);
                } else {
                    break; // Stop trying to purchase if a ticket is not available
                }
            }

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
                break;
            }
        }
    }
}
