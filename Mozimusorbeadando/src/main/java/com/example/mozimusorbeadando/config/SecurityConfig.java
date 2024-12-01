package com.example.mozimusorbeadando.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class SecurityConfig {

    /**
     * SecurityFilterChain beállítása a hitelesítéshez és engedélyezéshez.
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/", "/login", "/register", "/css/**", "/js/**").permitAll() // Nyilvános oldalak
                        .requestMatchers("/admin").hasAuthority("ADMIN") // Csak az admin szerepűek érhetik el
                        .requestMatchers("/data").hasAuthority("USER")
                        .anyRequest().authenticated() // Minden más oldal eléréséhez hitelesítés szükséges
                )
                .formLogin(form -> form
                        .loginPage("/login") // Egyedi login oldal
                        .defaultSuccessUrl("/", true) // Sikeres belépés után az induló oldal
                        .failureUrl("/login?error=true") // Sikertelen belépés után az oldal
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout") // Kijelentkezési URL
                        .logoutSuccessUrl("/") // Sikeres kijelentkezés utáni URL
                        .permitAll()
                )
                .csrf(csrf -> csrf.disable()) // Fejlesztési fázisban letiltható a CSRF védelem
                .cors(cors -> cors.configurationSource(corsConfigurationSource())); // CORS engedélyezése

        return http.build();
    }

    /**
     * AuthenticationManager szükséges a hitelesítési folyamathoz.
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    /**
     * CORS beállítások, ha a frontend másik domainről fut (pl. localhost:3000).
     */
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOrigin("http://localhost:3000"); // Engedélyezett origin (pl. frontend URL)
        configuration.addAllowedMethod("*"); // Minden HTTP metódus engedélyezése
        configuration.addAllowedHeader("*"); // Minden HTTP fejléc engedélyezése
        configuration.setAllowCredentials(true); // Hitelesített kérések engedélyezése
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
