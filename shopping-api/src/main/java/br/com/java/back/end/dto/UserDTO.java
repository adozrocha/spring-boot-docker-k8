package br.com.java.back.end.dto;

import java.time.LocalDateTime;

public record UserDTO(String nome, String cpf, String endereco, String key, String email, String telefone, LocalDateTime dataCadastro) {

}


