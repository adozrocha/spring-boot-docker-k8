package br.com.java.back.end.dto;

import java.util.stream.Collectors;

import br.com.java.back.end.model.Shop;

public class ShopConvertDTO {
	
	public static ShopDTO convert(Shop shop) {
		return new ShopDTO(shop.getId(), 
				shop.getUserIdentifier(), 
				shop.getTotal(), 
				shop.getDate(), 
				shop.getItems().stream().map(ItemConvertDTO::convert).collect(Collectors.toList()));
	}


}
