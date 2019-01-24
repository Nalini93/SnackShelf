package com.snackshelf;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code =HttpStatus.NOT_FOUND)
public class UserNotFoundRequestException extends RuntimeException{
	

}
