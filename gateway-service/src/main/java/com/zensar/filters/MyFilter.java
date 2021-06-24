package com.zensar.filters;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class MyFilter implements GlobalFilter {

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		System.out.println("Pre processing logic will go here "+exchange.getRequest().getURI().toString());
		return chain.filter(exchange).then(Mono.fromRunnable(()->{
			System.out.println("Post processing logic will go here ");
		}));
	}

}
