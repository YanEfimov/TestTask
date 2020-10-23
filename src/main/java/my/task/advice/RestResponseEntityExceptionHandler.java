package my.task.advice;

import my.task.dto.ErrorModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

@RestControllerAdvice
public class RestResponseEntityExceptionHandler{
    @ExceptionHandler(value
            = { ConstraintViolationException.class, MethodArgumentNotValidException.class})
    public ResponseEntity<ErrorModel> handleConstraintViolationException(Throwable ex) {
        return ResponseEntity.status(400).body(new ErrorModel(ex.getMessage()));
    }
}
