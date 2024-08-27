package br.com.java.back.end.model;

import java.util.Date;

import br.com.java.back.end.dto.UserDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;
	private String cpf;
	private String endereco;
	private String key;
    private String email;
    private String telefone;
    private Date dataCadastro;

	public static User convert(UserDTO userDTO) {
		User user = new User();
		user.setNome(userDTO.nome());
		user.setEndereco(userDTO.endereco());
		user.setCpf(userDTO.cpf());
		user.setKey(userDTO.key());
		user.setEmail(userDTO.email());
		user.setTelefone(userDTO.telefone());
		user.setDataCadastro(userDTO.dataCadastro());
		return user;
	}
	
}
