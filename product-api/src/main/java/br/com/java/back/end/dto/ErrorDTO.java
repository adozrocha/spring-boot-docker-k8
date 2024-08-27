package br.com.java.back.end.dto;

import java.time.LocalDateTime;

public record ErrorDTO(int status, String message, LocalDateTime timestamp) {

}
