package com.greencity.mono.infrastructure.common.security;

import javax.naming.SizeLimitExceededException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  private final KeycloakJwtTokenConverter keycloakJwtTokenConverter;

  public SecurityConfig(TokenConverterProperties properties) {
    JwtGrantedAuthoritiesConverter jwtGrantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();
    this.keycloakJwtTokenConverter = new KeycloakJwtTokenConverter(jwtGrantedAuthoritiesConverter, properties);
  }

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .authorizeHttpRequests()
        .anyRequest()
        .authenticated();
    http
        .oauth2ResourceServer()
        .jwt()
        .jwtAuthenticationConverter(keycloakJwtTokenConverter);
    http
        .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    return http.build();
  }
}
