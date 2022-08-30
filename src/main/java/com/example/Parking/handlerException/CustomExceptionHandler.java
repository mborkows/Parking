package com.example.Parking.handlerException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.*;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
    private String ENTITY_ALREADY_EXISTS = "ENTITY ALREADY EXISTS";

    @ResponseBody
    @ExceptionHandler(EntityAlreadyExistsException.class)
    public final ResponseEntity<ErrorResponse> entityAlreadyExistsHandle(EntityAlreadyExistsException ex, WebRequest request){
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ErrorResponse error = new ErrorResponse(ENTITY_ALREADY_EXISTS, details);
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

}
