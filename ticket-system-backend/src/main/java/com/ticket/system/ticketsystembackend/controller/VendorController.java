package com.ticket.system.ticketsystembackend.controller;
import com.ticket.system.ticketsystembackend.service.VendorService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vendor")
public class VendorController {
    private final VendorService vendorService;

    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @PostMapping("/addTickets")
    public void addTickets(@RequestParam int vendorId, @RequestParam int ticketsPerRelease) {
        vendorService.addTickets(vendorId, ticketsPerRelease);
    }

    @GetMapping("/getTicketCount/{vendorId}")
    public int getTicketCount(@PathVariable int vendorId) {
        return vendorService.getTicketCountByVendorId(vendorId);
    }
}
