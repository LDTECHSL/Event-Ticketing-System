package com.ticket.system.ticketsystembackend.controller;

import com.ticket.system.ticketsystembackend.entity.Vendor;
import com.ticket.system.ticketsystembackend.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vendor")
public class VendorController {

    @Autowired
    private VendorService vendorService;

    @PostMapping("/add-vendor")
    public Vendor addVendor(@RequestBody Vendor vendor) {
        return vendorService.addVendor(vendor);
    }

    @GetMapping("/get-vendors")
    public List<Vendor> getAllVendors() {
        return vendorService.getAllVendors();
    }

    @GetMapping("/get-vendor-by-id/{id}")
    public Vendor findVendorById(@PathVariable int id) {
        return vendorService.findVendorById(id);
    }

    @DeleteMapping("/delete-vendor/{id}")
    public String deleteVendorById(@PathVariable int id) {
        return vendorService.deleteVendorById(id);
    }
}
