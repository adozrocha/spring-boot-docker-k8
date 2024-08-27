package br.com.java.back.end.dto;

import br.com.core.dto.CategoryDTO;
import br.com.java.back.end.model.Category;

public class CategoryConvertDTO {
	
	public static CategoryDTO convert(Category category) {
		return new CategoryDTO(category.getId(), category.getName());
	}

}
