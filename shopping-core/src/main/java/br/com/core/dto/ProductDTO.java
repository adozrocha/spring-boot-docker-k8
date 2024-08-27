package br.com.core.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    @NotBlank
	private String productIdentifier;
    @NotBlank
	private String name;
    @NotNull
    private Float price;
    @NotNull
	private CategoryDTO category;
	
}
