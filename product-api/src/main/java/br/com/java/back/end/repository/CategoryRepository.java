package br.com.java.back.end.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.java.back.end.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	
	

}
