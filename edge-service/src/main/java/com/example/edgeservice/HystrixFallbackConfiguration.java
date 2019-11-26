package com.example.edgeservice;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@Configuration
public class HystrixFallbackConfiguration {

    @Bean
    public FallbackProvider zuulFallbackProvider() {
        return new FallbackProvider() {

            @Override
            public String getRoute() {
                return "ITEM-SERVICE";
            }

            @Override
            public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
                return new ClientHttpResponse() {
                    @Override
                    public HttpStatus getStatusCode() throws IOException {
                        return HttpStatus.GATEWAY_TIMEOUT;
                    }

                    @Override
                    public int getRawStatusCode() throws IOException {
                        return HttpStatus.GATEWAY_TIMEOUT.value();
                    }

                    @Override
                    public String getStatusText() throws IOException {
                        return "GATEWAY_TIMEOUT";
                    }

                    @Override
                    public void close() {

                    }

                    @Override
                    public InputStream getBody() throws IOException {
                        return new ByteArrayInputStream("ITEM-SERVICE is not available. Please try after some time.".getBytes());
                    }

                    @Override
                    public HttpHeaders getHeaders() {
                        return new HttpHeaders();
                    }
                };
            }
        };
    }

}
