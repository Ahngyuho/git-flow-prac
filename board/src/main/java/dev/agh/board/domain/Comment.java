package dev.agh.board.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Setter;
import lombok.ToString;

@ToString
@Entity
public class Comment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter private String content;
    @Setter @ManyToOne private Post post;
    @Setter @ManyToOne private UserAccount userAccount;

    protected Comment() {

    }

    @Builder
    public Comment(String content, Post post, UserAccount userAccount) {
        this.content = content;
        this.post = post;
        this.userAccount = userAccount;
    }

    public static Comment of(String content, Post post, UserAccount userAccount) {
        return new Comment(content,post, userAccount);
    }
}
