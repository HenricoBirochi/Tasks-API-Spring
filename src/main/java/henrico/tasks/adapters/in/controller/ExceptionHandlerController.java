package henrico.tasks.adapters.in.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import henrico.tasks.application.core.usecase.exceptions.ImageContentTypeNotValidException;


@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(ImageContentTypeNotValidException.class)
    public ResponseEntity<Void> contentNotValidResponse() {

        return ResponseEntity.status(403).build();
    }

}
