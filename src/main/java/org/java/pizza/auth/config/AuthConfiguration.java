package org.java.pizza.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class AuthConfiguration {

	@Bean
	PasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder();
	}

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return 
        		http.authorizeHttpRequests(a -> a
        				.requestMatchers("/pizza/**").hasAnyAuthority("USER", "ADMIN")
                        .requestMatchers("/pizza/new", "/pizza/edit/**", "/pizza/update/**", "/pizza/delete/**").hasAuthority("ADMIN")
                        .requestMatchers("/offerta/**").hasAuthority("ADMIN")
                        .requestMatchers("/ingrediente/**").hasAuthority("ADMIN")
                        .requestMatchers("/**").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(f -> f.permitAll())
                .logout(l -> l.logoutSuccessUrl("/"))
                .build();
    }
}
