package com.ticket.system.ticketsystembackend.repository;

import com.ticket.system.ticketsystembackend.entity.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorRepository extends JpaRepository<Vendor, Integer> {
}
