package br.com.java.back.end.dto;

import java.util.Date;

public record UserDTO(long id, String nome, String cpf, String endereco, String key, String email, String telefone,
		Date dataCadastro) {

}
