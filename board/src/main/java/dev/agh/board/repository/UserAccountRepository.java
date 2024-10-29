package dev.agh.board.repository;

import dev.agh.board.domain.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {
//    Optional<UserAccount> findByEmail(String email);
    Optional<UserAccount> findByEmail(String email);
}
