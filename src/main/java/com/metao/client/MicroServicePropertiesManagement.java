package com.metao.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MicroServicePropertiesManagement {

    @Bean
    public MicroMonitorProperties getMicroMonitorProperties() {
        return new MicroMonitorProperties();
    }
}
