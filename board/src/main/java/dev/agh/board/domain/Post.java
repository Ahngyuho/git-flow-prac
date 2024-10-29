package dev.agh.board.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Setter;
import lombok.ToString;

@Entity
public class Post {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter private String title;
    @Setter private String content;
    @Setter @ManyToOne private UserAccount userAccount;
    private Long viewCount;

    protected Post() {

    }

    @Builder
    private Post(String title, String content, UserAccount userAccount) {
        this.title = title;
        this.content = content;
        this.userAccount = userAccount;
    }

    public static Post of(String title, String content, UserAccount userAccount) {
        return new Post(title, content, userAccount);
    }
}
