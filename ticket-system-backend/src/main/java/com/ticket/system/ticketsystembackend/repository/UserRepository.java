package com.ticket.system.ticketsystembackend.repository;

import com.ticket.system.ticketsystembackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
