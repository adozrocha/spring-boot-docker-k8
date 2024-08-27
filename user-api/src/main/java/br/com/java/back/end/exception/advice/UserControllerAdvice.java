package br.com.java.back.end.exception.advice;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.java.back.end.dto.ErrorDTO;
import br.com.java.back.end.exception.UserNotFoundException;

@ControllerAdvice(basePackages = "br.com.java.back.end.controller")
public class UserControllerAdvice {
 
	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFoundException.class)
    public ErrorDTO handleUserNotFound(UserNotFoundException userNotFoundException) {    	
    	ErrorDTO errorDTO = new ErrorDTO(HttpStatus.NOT_FOUND.value(), "User not found.", LocalDateTime.now());
        return errorDTO;
    }
}