package dev.agh.board.exception;

import lombok.Getter;

@Getter
public abstract class GlobalException extends RuntimeException{
    public GlobalException(String message) {
        super(message);
    }

    public GlobalException(String message, Throwable cause) {
        super(message, cause);
    }

    public abstract int getStatusCode();
}
