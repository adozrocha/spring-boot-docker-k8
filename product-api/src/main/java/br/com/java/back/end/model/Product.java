package br.com.java.back.end.model;

import br.com.core.dto.ProductDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	private String name;
	private Float price;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	public static Product convert(ProductDTO productDTO) {
		Product product = new Product(productDTO.getName(), productDTO.getPrice(), productDTO.getId());
		if (productDTO.getCategory() != null) {
			product.setCategory(Category.convert(productDTO.getCategory()));
		}
		return product;
	}

	public Product(String name2, Float price2, String id2) {
		this.name = name2;
		this.id = id2;
		this.price = price2;
	}
	
	
	
}
