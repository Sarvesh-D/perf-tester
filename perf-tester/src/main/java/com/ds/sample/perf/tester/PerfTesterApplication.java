package com.ds.sample.perf.tester;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.micrometer.core.instrument.MeterRegistry;

@SpringBootApplication
public class PerfTesterApplication {

    public static void main(String[] args) {
        SpringApplication.run(PerfTesterApplication.class, args);
    }

    @Bean
    public MeterRegistryCustomizer<MeterRegistry> metricsCustomizer(@Value("${spring.application.name}") String name) {
        return registry -> registry.config()
                                   .commonTags("application", name);
    }
}
