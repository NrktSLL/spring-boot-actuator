package com.nrktsll.springbootactuator.ActuatorConfig;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class Indicator implements HealthIndicator {

    @Override
    public Health health() {

        if (!check("Nrkt")) {

            Map<String, String> errorDetails = new HashMap<>();
            errorDetails.put("Error Code", "409");
            errorDetails.put("Error", "This field already exist");

            return Health.down().withDetails(errorDetails).build();
        }
        return Health.up().withDetail("Service:", "ok").build();
    }

    private Boolean check(String value) {
        return !value.equals("Nrkt");
    }
}
