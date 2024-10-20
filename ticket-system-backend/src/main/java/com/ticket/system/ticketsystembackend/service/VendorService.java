package com.ticket.system.ticketsystembackend.service;

import com.ticket.system.ticketsystembackend.entity.Vendor;
import com.ticket.system.ticketsystembackend.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendorService {

    private final VendorRepository vendorRepository;

    @Autowired
    public VendorService(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }

    public Vendor addVendor(Vendor vendor) {
        return vendorRepository.save(vendor);
    }

    public List<Vendor> getAllVendors() {
        return vendorRepository.findAll();
    }

    public Vendor findVendorById(int id) {
        Optional<Vendor> vendor = vendorRepository.findById(id);
        if (vendor.isPresent()) {
            return vendor.get();
        } else {
            throw new RuntimeException("Vendor not found for id: " + id);
        }
    }

    public String deleteVendorById(int id) {
        if (vendorRepository.existsById(id)) {
            vendorRepository.deleteById(id);
            return "Vendor deleted: " + id;
        } else {
            throw new RuntimeException("Vendor not found for id: " + id);
        }
    }
}
