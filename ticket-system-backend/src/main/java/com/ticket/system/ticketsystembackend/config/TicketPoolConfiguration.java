package com.ticket.system.ticketsystembackend.config;

import com.ticket.system.ticketsystembackend.entity.TicketPool;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TicketPoolConfiguration {

    @Bean
    public TicketPool ticketPool() {
        return new TicketPool();
    }
}

