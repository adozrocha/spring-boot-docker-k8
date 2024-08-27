package br.com.java.back.end.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.core.dto.UserDTO;
import br.com.core.exception.UserNotFoundException;
import br.com.java.back.end.converter.UserDTOConverter;
import br.com.java.back.end.model.User;
import br.com.java.back.end.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public List<UserDTO> getAll(){
		List<User> users = userRepository.findAll();
		
		return users
				.stream()
				.map(UserDTOConverter::convert)
				.collect(Collectors.toList());
	}

	public Page<UserDTO> getAllPage(Pageable page) {
		Page<User> users = userRepository.findAll(page);
		return users
				.map(UserDTOConverter::convert);
	}
	
	public UserDTO findById(long userId) {
		User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException());
		return UserDTOConverter.convert(user);
	}
	
	public UserDTO save(UserDTO userDTO) {
		User user = User.convert(userDTO);
		user.setKey(UUID.randomUUID().toString());
		user.setDataCadastro(LocalDateTime.now());
		userRepository.save(user);
		return UserDTOConverter.convert(user);
	}

	public UserDTO findByCpf(String cpf) {
		User user = userRepository.findByCpf(cpf);
		if (user != null) {
			return UserDTOConverter.convert(user);
		}
		throw new UserNotFoundException();
	}

	public List<UserDTO> queryByName(String name) {
		List<User> usuarios = userRepository.queryByNomeLike(name);
		return usuarios.stream().map(UserDTOConverter::convert).collect(Collectors.toList());		
	}

	public void delete(long userId) throws UserNotFoundException {
		User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException());
		userRepository.delete(user);
	}
	
	public UserDTO editUser(Long userId, UserDTO userDTO) {
		User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException());
		if (userDTO.getEmail() != null && !user.getEmail().equals(userDTO.getEmail())) {
			user.setEmail(userDTO.getEmail());
		}
		if (userDTO.getTelefone() != null && !user.getTelefone().equals(userDTO.getTelefone())) {
			user.setTelefone(userDTO.getTelefone());
		}
		if (userDTO.getEndereco() != null && !user.getEndereco().equals(userDTO.getEndereco())) {
			user.setEndereco(userDTO.getEndereco());
		}

		user = userRepository.save(user);
		return UserDTOConverter.convert(user);
	}
	
}
