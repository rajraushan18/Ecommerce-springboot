package com.project.apigateway.filter;

import java.util.List;
import java.util.function.Predicate;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

//which end points should not be validated for token

@Component
public class RouteValidator {

	public static final List<String> openApiEndpoints = List.of(
				"/auth/register",
				"/auth/token",
				"/auth/eureka"
			);
	
	
	public Predicate<ServerHttpRequest> isSecured = 
			request -> openApiEndpoints
						.stream()
						.noneMatch(uri -> request.getURI().getPath().contains(uri));
	
	
	
}
