package dev.agh.board.dbtest;

import dev.agh.board.config.JpaConfig;
import dev.agh.board.domain.Comment;
import dev.agh.board.domain.Post;
import dev.agh.board.domain.UserAccount;
import dev.agh.board.repository.CommentRepository;
import dev.agh.board.repository.PostRepository;
import dev.agh.board.repository.UserAccountRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

@Import(JpaConfig.class)
@DataJpaTest
public class JpaSliceTest {
    private final UserAccountRepository userAccountRepository;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;


    public JpaSliceTest(@Autowired UserAccountRepository userAccountRepository,
                        @Autowired PostRepository postRepository,
                        @Autowired CommentRepository commentRepository) {
        this.userAccountRepository = userAccountRepository;
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }

    @Test
    public void givenNothing_whenSelectTestingData_then() {
        //when
        UserAccount user = UserAccount.of("gyuho@gmail.com","agh","1234");
        System.out.println(user);
        UserAccount anotherUser = UserAccount.of("test@gmail.com","another","5678");
        Post post = Post.of("test","tset",user);
        Comment comment = Comment.of("good!",post,anotherUser);
        userAccountRepository.saveAll(List.of(user, anotherUser));
        postRepository.save(post);
        commentRepository.save(comment);

        //then
        UserAccount userFromDb = userAccountRepository.findAll().get(0);
        System.out.println(userFromDb);
        System.out.println(user);
        Assertions.assertThat(userFromDb).isEqualTo(user);
    }

}
