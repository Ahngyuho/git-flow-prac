package dev.agh.board;

import dev.agh.board.config.SecurityConfig;
import dev.agh.board.domain.UserAccount;
import dev.agh.board.repository.UserAccountRepository;
import org.mockito.BDDMockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import java.util.Optional;

import static org.mockito.BDDMockito.*;

@Import(SecurityConfig.class)
public class SpringSecurityConfigTest {
    @MockBean private UserAccountRepository userAccountRepository;

    @BeforeTestMethod
    public void securitySetup() {
        given(userAccountRepository.findByEmail(anyString())).willReturn(
                Optional.of(UserAccount.of(
                        "gyuho@gmail.com",
                        "agh",
                        "pw1234"
                ))
        );
    }
}
