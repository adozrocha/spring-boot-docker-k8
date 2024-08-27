package br.com.java.back.end.converter;

import java.util.stream.Collectors;

import br.com.core.dto.ItemDTO;
import br.com.core.dto.ShopDTO;
import br.com.java.back.end.model.Item;
import br.com.java.back.end.model.Shop;

public class DTOConverter {
	
	public static ItemDTO convert(Item item) {
		return new ItemDTO(item.getProductIdentifier(), item.getPrice());
	}
	
	public static ShopDTO convert(Shop shop) {
		return new ShopDTO(shop.getUserIdentifier(), 
				shop.getTotal(), 
				shop.getDate(), 
				shop.getItems().stream().map(DTOConverter::convert).collect(Collectors.toList()));
	}


}
