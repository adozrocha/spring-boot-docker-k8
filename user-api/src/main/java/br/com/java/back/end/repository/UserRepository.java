package br.com.java.back.end.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.java.back.end.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByCpf(String cpf);
	
	User findByCpfAndKey(String cpf, String key);

	List<User> queryByNomeLike(String name);

}
