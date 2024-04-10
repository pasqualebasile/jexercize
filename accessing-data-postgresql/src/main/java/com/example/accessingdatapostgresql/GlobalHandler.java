package com.example.accessingdatapostgresql;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalHandler {

    @ResponseBody
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> handleData(DataIntegrityViolationException e)
    {
        return ResponseEntity
                .status(HttpStatus.CONFLICT) // You can choose an appropriate status like CONFLICT for PK violation
                .body(e.getRootCause().getMessage());
    }
}
