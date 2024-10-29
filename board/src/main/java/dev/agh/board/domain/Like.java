package dev.agh.board.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Setter;
import lombok.ToString;

@ToString
@Entity
public class Like {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false) private Long relatedId;
    @Column(nullable = false) @Enumerated(EnumType.STRING) private LikeType likeType;
    @ToString.Exclude @Setter @ManyToOne private UserAccount userAccount;

    protected Like() {}

    @Builder
    private Like(Long relatedId, LikeType likeType, UserAccount userAccount) {
        this.relatedId = relatedId;
        this.likeType = likeType;
        this.userAccount = userAccount;
    }

    public static Like of(Long relatedId, LikeType likeType, UserAccount userAccount) {
        return new Like(relatedId, likeType, userAccount);
    }
}
