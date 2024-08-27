package br.com.java.back.end.exception.advice;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.core.dto.ErrorDTO;
import br.com.core.exception.ProductNotFoundException;
import br.com.core.exception.UserNotFoundException;


@ControllerAdvice(basePackages = "br.com.java.back.end.controller")
public class ShoppingControllerAdvice {
 
	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ProductNotFoundException.class)
    public ErrorDTO handleUserNotFound(ProductNotFoundException userNotFoundException) {    	
    	ErrorDTO errorDTO = new ErrorDTO();
    	errorDTO.setStatus(HttpStatus.NOT_FOUND.value());
    	errorDTO.setMessage("Produto não encontrado.");
    	errorDTO.setTimestamp(LocalDateTime.now());
        return errorDTO;
    }
	
	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFoundException.class)
    public ErrorDTO handleUserNotFound(UserNotFoundException userNotFoundException) {    	
    	ErrorDTO errorDTO = new ErrorDTO();
    	errorDTO.setStatus(HttpStatus.NOT_FOUND.value());
    	errorDTO.setMessage("Usuário não encontrado.");
    	errorDTO.setTimestamp(LocalDateTime.now());
        return errorDTO;
    }
}
