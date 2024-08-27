package br.com.java.back.end.dto;


public record ProductDTO(long id, String nome, Float preco, String descricao, String productIdentifier, CategoryDTO category) {

}
