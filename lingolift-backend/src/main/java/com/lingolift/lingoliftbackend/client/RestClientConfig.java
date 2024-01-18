package com.lingolift.lingoliftbackend.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestClientConfig {

    @Value("${openai.key}")
    private String openApiKey;

    @Bean
    public RestTemplate template() {

        RestTemplate restTemplate = new RestTemplate();

        restTemplate.getInterceptors().add( (request, body, execution) -> {
            request.getHeaders().add("Authorization", "Bearer " + this.openApiKey);
            return execution.execute(request, body);
        });

        return restTemplate;

    }
}