package com.nrktsll.springbootactuator.Enpoints;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.actuate.endpoint.annotation.*;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Endpoint(id = "features", enableByDefault = true)
@Getter
@Setter
public class TestEndpoints {

    private Map<String, String> features = new HashMap<>();

    @ReadOperation
    public Map<String, String> features() {
        features.put("Test", "test");
        features.put("Nrkt", "Sll");
        return features;
    }

    @ReadOperation
    public String feature(@Selector String name) {
        return features.get(name);
    }

    @WriteOperation
    public void configureFeature(@Selector String name, String feature) {
        features.put(name, feature);
    }

    @DeleteOperation
    public void deleteFeature(@Selector String name) {
        features.remove(name);
    }
}