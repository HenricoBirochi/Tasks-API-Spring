package henrico.tasks.adapters.in.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import henrico.tasks.adapters.in.controller.dto.ExceptionResponseDTO;
import henrico.tasks.application.core.usecase.exceptions.DeadlineIsBeforeCurrentDateTimeException;
import henrico.tasks.application.core.usecase.exceptions.EmailAlreadyRegisteredException;
import henrico.tasks.application.core.usecase.exceptions.ImageContentTypeNotValidException;
import henrico.tasks.application.core.usecase.exceptions.PasswordNotValidException;
import henrico.tasks.application.core.usecase.exceptions.UserNameAlreadyRegisteredException;


@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(ImageContentTypeNotValidException.class)
    public ResponseEntity<ExceptionResponseDTO> contentNotValid(ImageContentTypeNotValidException exception) {
        var exceptionResponse = ExceptionResponseDTO
            .builder()
            .message(exception.getMessage())
            .possibleWrongVariable(exception.getWrongContentType())
            .build();
        return ResponseEntity.status(403).body(exceptionResponse);
    }

    @ExceptionHandler(DeadlineIsBeforeCurrentDateTimeException.class)
    public ResponseEntity<ExceptionResponseDTO> deadlineNotValid(DeadlineIsBeforeCurrentDateTimeException exception) {
        var exceptionResponse = ExceptionResponseDTO
            .builder()
            .message(exception.getMessage())
            .possibleWrongVariable(exception.getWrongDeadline().toString())
            .build();
        return ResponseEntity.status(403).body(exceptionResponse);
    }

    @ExceptionHandler(EmailAlreadyRegisteredException.class)
    public ResponseEntity<ExceptionResponseDTO> emailAlreadyRegistered(EmailAlreadyRegisteredException exception) {
        var exceptionResponse = ExceptionResponseDTO
            .builder()
            .message(exception.getMessage())
            .possibleWrongVariable(exception.getWrongEmail())
            .build();
        return ResponseEntity.status(403).body(exceptionResponse);
    }

    @ExceptionHandler(UserNameAlreadyRegisteredException.class)
    public ResponseEntity<ExceptionResponseDTO> userNameAlreadyRegistered(UserNameAlreadyRegisteredException exception) {
        var exceptionResponse = ExceptionResponseDTO
            .builder()
            .message(exception.getMessage())
            .possibleWrongVariable(exception.getWrongUserName())
            .build();
        return ResponseEntity.status(403).body(exceptionResponse);
    }

    @ExceptionHandler(PasswordNotValidException.class)
    public ResponseEntity<ExceptionResponseDTO> passwordNotValid(PasswordNotValidException exception) {
        var exceptionResponse = ExceptionResponseDTO
            .builder()
            .message(exception.getMessage())
            .possibleWrongVariable(exception.getWrongPassword())
            .build();
        return ResponseEntity.status(403).body(exceptionResponse);
    }

}
