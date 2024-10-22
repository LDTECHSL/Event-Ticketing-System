package com.ticket.system.ticketsystembackend.service;

import com.ticket.system.ticketsystembackend.entity.Configuration;
import com.ticket.system.ticketsystembackend.entity.Ticket;
import com.ticket.system.ticketsystembackend.repository.ConfigurationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConfigurationService {

    private final ConfigurationRepository configurationRepository;

    public ConfigurationService(ConfigurationRepository configurationRepository) {
        this.configurationRepository = configurationRepository;
    }

    public Configuration addConfiguration(Configuration configuration) {
        return configurationRepository.save(configuration);
    }

    public List<Configuration> getAllConfigurations() {
        return configurationRepository.findAll();
    }

    public Configuration getConfigurationById(int id) {
        Optional<Configuration> configuration = configurationRepository.findById(id);
        if (configuration.isPresent()) {
            return configuration.get();
        } else {
            throw new RuntimeException("Configuration Settings not found for id: " + id);
        }
    }
}
