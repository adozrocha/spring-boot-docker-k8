package br.com.java.back.end.model;

import br.com.core.dto.ItemDTO;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Item {
	
	private String productIdentifier;
	private Float price;
		
	public static Item convert(ItemDTO itemDTO) {
		return new Item(itemDTO.getProductIdentifier(), itemDTO.getPrice());
	}
}

