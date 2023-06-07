package com.example.BackTecVagas.controllers.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration {

    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    private final AuthenticationProvider authenticationProvider;

    public SecurityConfiguration(AuthenticationProvider authenticationProvider) {
        this.authenticationProvider = authenticationProvider;
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

            http.csrf()
                .disable()
                .authorizeHttpRequests()
                .requestMatchers("/api/v1/auth/**")
                .permitAll()
                    .and().authorizeHttpRequests().requestMatchers("/candidato/**").permitAll()
                    .and().authorizeHttpRequests().requestMatchers("/empresa/**").permitAll()
                    .and().authorizeHttpRequests().requestMatchers("/curriculo/**").permitAll()
                    .and().authorizeHttpRequests().requestMatchers("/cursos/**").permitAll()
                    .and().authorizeHttpRequests().requestMatchers("/formacao-acad/**").permitAll()
                    .and().authorizeHttpRequests().requestMatchers("/inf-adicional/**").permitAll()
                    .and().authorizeHttpRequests().requestMatchers("/vagas/**").permitAll()
                    .and().authorizeHttpRequests().requestMatchers("/exp-profissional/**").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(this.authenticationProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);




        return http.build();

    }

}
