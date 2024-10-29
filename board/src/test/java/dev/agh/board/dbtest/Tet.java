package dev.agh.board.dbtest;

import dev.agh.board.domain.UserAccount;
import dev.agh.board.repository.UserAccountRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Tet {
    @Autowired
    private UserAccountRepository userAccountRepository;

    @Test
    public void test() {
        UserAccount user = UserAccount.of("gyuho0897@gmail.com","agh","1234");
        System.out.println(user);
        userAccountRepository.save(user);
        System.out.println(user.getCreatedBy());
    }
}
