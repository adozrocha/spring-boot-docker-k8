package br.com.java.back.end.dto;

import br.com.java.back.end.model.Product;

public class ProductConvertDTO {
	
	public static ProductDTO convert(Product product) {
		return new ProductDTO(product.getId(), 
							  product.getNome(), 
							  product.getPreco(), 
							  product.getDescricao(),  
							  product.getProductIdentifier(), 
							  CategoryConvertDTO.convert(product.getCategory()));
	}

}
