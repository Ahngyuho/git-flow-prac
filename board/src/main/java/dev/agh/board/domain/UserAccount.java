package dev.agh.board.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Entity
public class UserAccount extends AuditingFields {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false) private String email;
    @Column(nullable = false) private String userName;
    @Column(nullable = false) private String password;

    protected UserAccount() {

    }

//    @Builder
    public UserAccount(String email, String userName, String password) {
        this.email = email;
        this.userName = userName;
        this.password = password;
    }

    public static UserAccount of(String email, String userName, String password) {
        return new UserAccount(email, userName, password);
    }
}
