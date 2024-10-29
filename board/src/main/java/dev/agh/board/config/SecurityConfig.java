package dev.agh.board.config;

import dev.agh.board.domain.UserAccount;
import dev.agh.board.repository.UserAccountRepository;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .build();
    }


    //파라미터로 UserAccountRepository
    @Bean
    public UserDetailsService userDetailsService(UserAccountRepository userAccountRepository) {
        return email -> {
            UserAccount user = userAccountRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(email + "을 찾을 수 없습니다."));

            return new UserPrincipal(user);
        };
    }
}
