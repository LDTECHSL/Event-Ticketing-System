package com.ticket.system.ticketsystembackend.controller;

import com.ticket.system.ticketsystembackend.entity.Configuration;
import com.ticket.system.ticketsystembackend.service.ConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/configuration")
public class ConfigurationController {

    @Autowired
    private ConfigurationService configurationService;

    @PostMapping("/add-configuration")
    public Configuration addConfiguration(@RequestBody Configuration configuration) {
        return configurationService.addConfiguration(configuration);
    }

    @GetMapping("/get-configurations")
    public List<Configuration> getAllConfigurations() {
        return configurationService.getAllConfigurations();
    }

    @GetMapping("/get-configuration/{id}")
    public Configuration getConfigurationById(@PathVariable int id) {
        return configurationService.getConfigurationById(id);
    }
}
