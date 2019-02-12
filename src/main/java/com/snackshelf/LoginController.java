/*package com.snackshelf;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;
import static com.snackshelf.SecurityConstants.EXPIRATION_TIME;
import static com.snackshelf.SecurityConstants.HEADER_STRING;
import static com.snackshelf.SecurityConstants.SECRET;
import static com.snackshelf.SecurityConstants.TOKEN_PREFIX;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/login")
  public class LoginController {
   @Autowired
   private LoginRepository loginRepository;
   
   @PostMapping("/register")
   public void signUp(@RequestBody LoginForm loginForm) {
       loginForm.setPassword((loginForm.getPassword()));
       loginRepository.save(loginForm);
   }
   
  
   
}*/

