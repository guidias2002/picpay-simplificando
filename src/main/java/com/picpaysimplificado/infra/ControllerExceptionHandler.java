package com.picpaysimplificado.infra;

import com.picpaysimplificado.dtos.ExceptionDto;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity threatDuplicationEntry(DataIntegrityViolationException ex) {
        ExceptionDto exceptionDto = new ExceptionDto("Usuário já cadastrado", HttpStatus.BAD_REQUEST);

        return ResponseEntity.badRequest().body(exceptionDto);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity threat404(EntityNotFoundException ex) {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity threatGeneralException(Exception ex) {
        ExceptionDto exceptionDto = new ExceptionDto(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

        return ResponseEntity.internalServerError().body(exceptionDto);
    }

}
