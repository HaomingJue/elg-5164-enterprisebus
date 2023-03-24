package com.cloudtech.enterprisebus.controller;

import com.cloudtech.enterprisebus.service.CpuUsageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MonitorController {

    @Autowired
    private CpuUsageService cpuUsageService;

    @GetMapping("/cpu-usage")
    public double getCpuUsage() {
        return cpuUsageService.getCpuUsage().get();
    }
}

