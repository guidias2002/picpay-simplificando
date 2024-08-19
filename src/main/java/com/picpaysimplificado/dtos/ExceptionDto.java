package com.picpaysimplificado.dtos;

import org.springframework.http.HttpStatus;

public record ExceptionDto (String message, HttpStatus statusCode) {
}
