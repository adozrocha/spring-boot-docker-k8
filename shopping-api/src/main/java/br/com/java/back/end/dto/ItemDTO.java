package br.com.java.back.end.dto;

public class ItemDTO {
	
	String productIdentifier; 
	Float price;

	public ItemDTO(String productIdentifier, Float price) {
		this.productIdentifier = productIdentifier;
		this.price = price;
	}
	
	public String getProductIdentifier() {
		return productIdentifier;
	}
	
	public void setProductIdentifier(String productIdentifier) {
		this.productIdentifier = productIdentifier;
	}
	
	public Float getPrice() {
		return price;
	}
	
	public void setPrice(Float price) {
		this.price = price;
	}
	
	

}
