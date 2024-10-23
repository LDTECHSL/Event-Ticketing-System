package com.ticket.system.ticketsystembackend.controller;
import com.ticket.system.ticketsystembackend.entity.Ticket;
import com.ticket.system.ticketsystembackend.service.VendorService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vendor")
public class VendorController {
    private final VendorService vendorService;

    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @PostMapping("/add-tickets")
    public void addTickets(@RequestBody Ticket ticket,@RequestParam int releaseInterval) {
        vendorService.addTickets(ticket,releaseInterval);
    }

    @GetMapping("/getTicketCount/{vendorId}")
    public Ticket getTicketCount(@PathVariable int vendorId) {
        return vendorService.getTicketCountByVendorId(vendorId);
    }
}
