package com.ticket.system.ticketsystembackend.controller;

import com.ticket.system.ticketsystembackend.entity.TicketPool;
import com.ticket.system.ticketsystembackend.entity.Vendor;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
@RequestMapping("/api/vendor")
public class VendorController {

    private final TicketPool ticketPool;
    private final ExecutorService executorService;

    public VendorController() {
        this.ticketPool = new TicketPool(); // Initialize the ticket pool
        this.executorService = Executors.newCachedThreadPool(); // Create a thread pool for vendors
    }

    // Endpoint to add a vendor
    @PostMapping("/add-ticket")
    public String addVendor(
            @RequestParam String vendorId,
            @RequestParam int ticketsPerRelease,
            @RequestParam long releaseInterval
    ) {
        // Create and start a new vendor thread
        Vendor vendor = new Vendor(ticketPool, vendorId, ticketsPerRelease, releaseInterval);
        executorService.submit(vendor);

        return "Vendor " + vendorId + " started releasing " + ticketsPerRelease + " tickets every " + releaseInterval + " milliseconds.";
    }

    // Optional: If you want to get the current ticket count in the pool
    @GetMapping("/ticket-count")
    public int getTicketCount(@RequestParam String vendorId) {
        return ticketPool.getTicketCount(vendorId);
    }
}
