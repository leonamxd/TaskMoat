package com.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .baseUrl("https://europe-west1-madesimplegroup-151616.cloudfunctions.net")
                .defaultHeader("Authorization", "Basic ZGV2ZWxvcGVyOlpHVjJaV3h2Y0dWeQ==")
                .build();
    }
}