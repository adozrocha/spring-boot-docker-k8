package br.com.java.back.end.converter;

import br.com.core.dto.UserDTO;
import br.com.java.back.end.model.User;

public class UserDTOConverter {
	
	public static UserDTO convert(User user) {
		UserDTO userDTO = new UserDTO(user.getNome(), user.getCpf(), user.getEndereco(), user.getKey(), user.getEmail(), user.getTelefone(), user.getDataCadastro());
		return userDTO;
	}
	
	
		
}
