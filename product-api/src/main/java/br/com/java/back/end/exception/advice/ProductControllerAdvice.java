package br.com.java.back.end.exception.advice;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.core.dto.ErrorDTO;
import br.com.core.exception.CategoryNotFoundException;
import br.com.core.exception.ProductNotFoundException;


@ControllerAdvice(basePackages = "br.com.java.back.end.controller")
public class ProductControllerAdvice {
 
	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ProductNotFoundException.class)
    public ErrorDTO handleUserNotFound(ProductNotFoundException userNotFoundException) {    	
		return new ErrorDTO(HttpStatus.NOT_FOUND.value(), "Product not found.", LocalDateTime.now());
    }
	
	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(CategoryNotFoundException.class)
    public ErrorDTO handleCategoryNotFound(CategoryNotFoundException categoryNotFoundException) {    	
    	return new ErrorDTO(HttpStatus.NOT_FOUND.value(), "Category not found.", LocalDateTime.now());
    }

	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ErrorDTO processValidationError(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
        StringBuilder sb = new StringBuilder("Invalid value for field(s):");        
        for (FieldError fieldError : fieldErrors) {
        	sb.append(" ");
        	sb.append(fieldError.getField());
        }        
        return new ErrorDTO(HttpStatus.BAD_REQUEST.value(), sb.toString(), LocalDateTime.now());
	}
}