package com.example.tienda_emazon.infrastructure.security;


import com.example.tienda_emazon.infrastructure.security.jwt.JwtAuthorizationFilter;
import com.example.tienda_emazon.infrastructure.security.jwt.JwtEntryPoint;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.CrossOrigin;

@Configuration
@EnableMethodSecurity(securedEnabled = true)
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class SecurityConfig {

   private final JwtEntryPoint jwtEntryPoint;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(request -> {
                    request.requestMatchers("/auth/login", "/auth/register", "/swagger-ui.html",
                            "/swagger-ui/**", "/v3/api-docs/**", "/actuator/health").permitAll();
                    request.anyRequest().authenticated();
                })
                .exceptionHandling(handling -> handling.authenticationEntryPoint(jwtEntryPoint))
                .addFilterBefore(jwtTokenFilter(), UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public JwtAuthorizationFilter jwtTokenFilter() {
        return new JwtAuthorizationFilter();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}
