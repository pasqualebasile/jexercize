package com.example.accessingdatapostgresql;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

// @ControllerAdvice
public class GlobalHandler extends ResponseEntityExceptionHandler {

    @ResponseBody
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<?> handleData(DataIntegrityViolationException e, WebRequest request)
    {
        // Choose an appropriate Message

        String bodyOfResponse = e.getRootCause().getMessage();
        return ResponseEntity
                .status(HttpStatus.CONFLICT) // You can choose an appropriate status like CONFLICT for PK violation
                .body(bodyOfResponse);

/*
        return handleExceptionInternal(e, bodyOfResponse,
                                       new HttpHeaders(), HttpStatus.CONFLICT, request

        );
*/

/*
        return ResponseEntity
                .status(HttpStatus.CONFLICT) // You can choose an appropriate status like CONFLICT for PK violation
                .body(e.getRootCause().getMessage());
*/
    }
}
