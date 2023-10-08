package com.project.apigateway.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.project.apigateway.util.JwtUtil;

//this is used to check token automatically when the user login

@Component
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config> {

	@Autowired
	private RouteValidator validator;
	
//	@Autowired
//	public RestTemplate template;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	public AuthenticationFilter() {
		super(Config.class);
	}
	
	
	@Override
	public GatewayFilter apply(Config config) {
		return ((exchange, chain) -> {
			
			if(validator.isSecured.test(exchange.getRequest())) {
				//header contains token or not
				if(!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
					throw new RuntimeException("missing authorization header");
				}
				
				String authHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
				if(authHeader!=null && authHeader.startsWith("Bearer ")) {
					//token contains "Bearer " in the start and to remove it
					authHeader = authHeader.substring(7);	
				}
				try {
//					//REST call to auth service
//					-----this will cause a security issue, so will not use	
//					template.getForObject("http://SECURITY-SERVICE/auth/validate?token="+authHeader, String.class);
					
					//instead use Jwt for validation instead of calling a service from the api gateway
					jwtUtil.validateToken(authHeader);
					
				}catch(Exception e) {
					throw new RuntimeException("Unauthorized access!");
				}
			}
			
			
			return chain.filter(exchange);
		});
	}
	
	public static class Config{
		
	}
	
	
}
