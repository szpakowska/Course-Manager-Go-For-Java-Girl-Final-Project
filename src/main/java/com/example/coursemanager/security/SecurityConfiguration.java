package com.example.coursemanager.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.thymeleaf.extras.springsecurity6.dialect.SpringSecurityDialect;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authz) -> authz
                        .requestMatchers("/").permitAll()
                        .requestMatchers("/home").permitAll()
                        .requestMatchers("/h2-console/**").permitAll()
                        .requestMatchers("/registration").hasAuthority("Admin")
                        .requestMatchers("/courses**").permitAll()//.hasAuthority("Admin")
                        .requestMatchers("/courses/**").permitAll()
                        .requestMatchers("/user/**").permitAll()
                        .requestMatchers("/blocks/**").permitAll()
                        .requestMatchers("/lessons/**").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(formLogin -> formLogin
                        .defaultSuccessUrl("/home",true)
                        .permitAll()
                )
                .formLogin(formLogin -> formLogin
                        .loginPage("/login") // Ustaw stronę logowania
                        .defaultSuccessUrl("/home", true)
                        .permitAll()
                )
//                .csrf(AbstractHttpConfigurer::csrfTokenRepository) // Dodaj obsługę CSRF

                .httpBasic(withDefaults())
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/")
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID")
                );


        http.csrf(AbstractHttpConfigurer::disable);
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SpringSecurityDialect springSecurityDialect(){
        return new SpringSecurityDialect();
    }
    @Controller
    public class LoginController {

        @GetMapping("/login")
        public String login() {
            return "LogonPage"; // Zwróć nazwę pliku HTML
        }
    }

}
