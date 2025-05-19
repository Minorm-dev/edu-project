package com.minorm.eduproject.http.handler;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

import static java.util.stream.Collectors.toMap;

@RestControllerAdvice
public class GlobalExceptionHandler {

//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<ErrorResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
//        Map<String, String > errors = ex.getBindingResult()
//                .getFieldErrors()
//                .stream()
//                .collect(toMap(
//                        FieldError::getField,
//                        FieldError::getDefaultMessage,
//                        (existing, replacement) -> existing
//                ));
//
//        return ResponseEntity.badRequest()
//                .body(new ErrorResponse() {
//                    @Override
//                    public HttpStatusCode getStatusCode() {
//                        return null;
//                    }
//
//                    @Override
//                    public ProblemDetail getBody() {
//                        return null;
//                    }
//                });
//    }

//    @ExceptionHandler(InvalidPromo)
}
