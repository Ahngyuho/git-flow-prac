package dev.agh.board.controller;

import dev.agh.board.exception.GlobalException;
import dev.agh.board.response.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionController {

    @ResponseBody
    @ExceptionHandler(GlobalException.class)
    public ResponseEntity<ErrorResponse> globalException(GlobalException exception) {
        int statusCode = exception.getStatusCode();
        ErrorResponse response = ErrorResponse.builder().message(exception.getMessage()).build();
        return ResponseEntity.status(statusCode).body(response);
    }
}
