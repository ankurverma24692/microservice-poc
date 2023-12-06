package com.demo.gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

import com.demo.gateway.config.JwtAuthenticationConfig;
import com.demo.gateway.config.JwtAuthenticationFilter;

@SpringBootApplication
public class GatewayApplication {

	@Value("${jwt.secret:helloasdasdasdasdadfdfsdfsdfasdasdawdawdasdasdwdasdaw}")
    private String secret;

    @Value("${jwt.expiration:120000}")
    private Long expiration;
	
	
	@Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;
	
	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}
	
	@Bean
    public RouteLocator routerBuilder(RouteLocatorBuilder routeLocatorBuilder){ 
        return routeLocatorBuilder.routes() 
                        .route("BANK",r->r.path("/bank/**")
                        		.filters(f -> f.filter(jwtAuthenticationFilter
                        				.apply(new JwtAuthenticationConfig(secret, expiration))))
                                .uri("http://localhost:9806"))
                        .build(); 
    } 
	

}
