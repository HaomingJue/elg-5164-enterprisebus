package com.cloudtech.enterprisebus.service;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;
import java.lang.management.ManagementFactory;
import java.util.function.Supplier;

import com.sun.management.OperatingSystemMXBean;
import org.springframework.stereotype.Service;

@Service
@Endpoint(id = "cpu-usage")
public class CpuUsageService {

    @ReadOperation
    public Supplier<Double> getCpuUsage() {
        OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);
        double cpuUsage;
        if (System.getProperty("os.name").toLowerCase().contains("windows")) {
            cpuUsage = osBean.getSystemCpuLoad() * 100;
        } else {
            cpuUsage = osBean.getProcessCpuLoad() * 100;
        }
        return () -> cpuUsage;
    }
}
