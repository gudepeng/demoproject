package com.sc.gateway.filter;

import com.sc.gateway.config.JwtConfig;
import com.sc.gateway.util.JwtUtil;
import com.sc.gateway.util.UrlUtil;
import io.jsonwebtoken.Claims;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class AuthFilter implements GlobalFilter, Ordered {

    @Autowired
    private JwtConfig jwtConfig;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String url = exchange.getRequest().getURI().getPath();
        if(UrlUtil.checkUrl(jwtConfig.getSkipUrl(),url)){
            return chain.filter(exchange);
        }
        String athorilzed = exchange.getRequest().getHeaders().getFirst("ATHORILZED");
        if(StringUtils.isBlank(athorilzed)){
            return retrnUnAuthoriized(exchange,chain);
        }
        Claims claims = JwtUtil.verifyJwt(athorilzed,jwtConfig.getSecretKey());
        if(claims==null){
            return retrnUnAuthoriized(exchange,chain);
        }
        String userIId = claims.get("userId").toString();
        if(StringUtils.isBlank(userIId)){
            return retrnUnAuthoriized(exchange,chain);
        }

        exchange.getRequest().getHeaders();


        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 1;
    }

    public Mono<Void> retrnUnAuthoriized(ServerWebExchange exchange, GatewayFilterChain chain){
        ServerHttpResponse response = exchange.getResponse();
        response.setStatusCode(HttpStatus.UNAUTHORIZED);
        exchange.mutate().response(response);
        return chain.filter(exchange);
    }
}