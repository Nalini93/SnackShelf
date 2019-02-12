package com.snackshelf;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code =HttpStatus.BAD_REQUEST, reason = "Login not allowed")
public class LoginBadRequestException extends RuntimeException{

}


