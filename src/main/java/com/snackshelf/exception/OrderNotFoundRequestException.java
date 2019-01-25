package com.snackshelf.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code =HttpStatus.NOT_FOUND, reason="order not found")
public class OrderNotFoundRequestException extends RuntimeException {

}
