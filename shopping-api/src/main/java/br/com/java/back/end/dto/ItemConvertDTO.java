package br.com.java.back.end.dto;

import br.com.java.back.end.model.Item;

public class ItemConvertDTO {
	
	public static ItemDTO convert(Item item) {
		return new ItemDTO(item.getProductIdentifier(), item.getPrice());
	}


}
