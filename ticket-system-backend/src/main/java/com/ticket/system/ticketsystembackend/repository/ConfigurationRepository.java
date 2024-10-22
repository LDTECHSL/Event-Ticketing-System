package com.ticket.system.ticketsystembackend.repository;

import com.ticket.system.ticketsystembackend.entity.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfigurationRepository extends JpaRepository<Configuration, Integer> {
}
