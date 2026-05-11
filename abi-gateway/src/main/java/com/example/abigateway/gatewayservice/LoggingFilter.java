package com.example.abigateway.gatewayservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class LoggingFilter implements GlobalFilter, Ordered {

    private static final Logger logger = LoggerFactory.getLogger(LoggingFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String method = exchange.getRequest().getMethod().toString();
        String path = exchange.getRequest().getPath().toString();
        String headers = exchange.getRequest().getHeaders().toString();

        logger.info("================ GATEWAY REQUEST ================");
        logger.info("Method: {}", method);
        logger.info("Path:   {}", path);
        logger.info("Headers: {}", headers);
        logger.info("=================================================");

        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return -1;
    }
}