package com.snackshelf.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code =HttpStatus.BAD_REQUEST, reason = "not allowed")
public class UserBadRequestException extends RuntimeException{
	

}
