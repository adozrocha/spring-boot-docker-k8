package br.com.java.back.end.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import br.com.java.back.end.dto.ProductDTO;

@Entity(name="product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String productIdentifier;
	private String nome;
	private String descricao;
	private Float preco;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	public static Product convert(ProductDTO productDTO) {
		Product product = new Product(productDTO.id(), productDTO.nome(), productDTO.descricao(), productDTO.preco(), productDTO.productIdentifier());
		if (productDTO.category() != null) {
			product.setCategory(Category.convert(productDTO.category()));
		}
		return product;
	}

	public Product() {	}
	
	public Product(long id, String nome, String descricao, Float preco, String productIdentifier) {
		super();
		this.id = id;
		this.productIdentifier = productIdentifier;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProductIdentifier() {
		return productIdentifier;
	}

	public void setProductIdentifier(String productIdentifier) {
		this.productIdentifier = productIdentifier;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Float getPreco() {
		return preco;
	}

	public void setPreco(Float preco) {
		this.preco = preco;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
