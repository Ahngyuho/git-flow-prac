package dev.agh.board.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Setter;

@Entity
public class File {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter @ManyToOne Post post;
    @Setter @Column(nullable = false) private String fileName;
    @Setter @Column(nullable = false) private String filePath;

    protected File() {}

    @Builder
    private File(Post post, String fileName, String filePath) {
        this.post = post;
        this.fileName = fileName;
        this.filePath = filePath;
    }

    private static File of(Post post, String fileName, String filePath) {
        return new File(post, fileName, filePath);
    }
}
