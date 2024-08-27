package br.com.java.back.end.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import br.com.java.back.end.dto.CategoryDTO;

@Entity(name="category")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;
	
	public Category() {	}

	public Category(long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public static Category convert(CategoryDTO categoryDTO) {
		Category category = new Category(categoryDTO.id(), categoryDTO.nome());
		return category;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
