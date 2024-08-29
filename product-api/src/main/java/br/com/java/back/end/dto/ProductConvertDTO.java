package br.com.java.back.end.dto;

import br.com.core.dto.ProductDTO;
import br.com.java.back.end.model.Product;

public class ProductConvertDTO {
	
	public static ProductDTO convert(Product product) {
		return new ProductDTO(product.getId(),
							  product.getName(), 
							  product.getPrice(), 
							  CategoryConvertDTO.convert(product.getCategory()));
	}

}
