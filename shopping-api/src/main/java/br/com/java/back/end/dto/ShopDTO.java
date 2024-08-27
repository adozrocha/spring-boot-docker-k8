package br.com.java.back.end.dto;

import java.time.LocalDateTime;
import java.util.List;

public class ShopDTO {
	
	long id; 
	String userIdentifier; 
	Float total; 
	LocalDateTime date; 
	List<ItemDTO> items;

	public ShopDTO(long id, String userIdentifier, Float total, LocalDateTime date, List<ItemDTO> items) {
		super();
		this.id = id;
		this.userIdentifier = userIdentifier;
		this.total = total;
		this.date = date;
		this.items = items;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUserIdentifier() {
		return userIdentifier;
	}
	public void setUserIdentifier(String userIdentifier) {
		this.userIdentifier = userIdentifier;
	}
	public Float getTotal() {
		return total;
	}
	public void setTotal(Float total) {
		this.total = total;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public List<ItemDTO> getItems() {
		return items;
	}
	public void setItems(List<ItemDTO> items) {
		this.items = items;
	}
	
	

}
