package dev.agh.board.annotation;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.test.context.support.WithSecurityContextFactory;


public class MockUserAccountFactory implements WithSecurityContextFactory<MockUserAccount> {
    @Override
    public SecurityContext createSecurityContext(MockUserAccount annotation) {
        return null;
    }
}
