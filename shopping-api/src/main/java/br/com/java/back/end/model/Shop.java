package br.com.java.back.end.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.java.back.end.dto.ShopDTO;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

@Entity(name="shop")
public class Shop {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;	
	private String userIdentifier;	
	private float total;	
	private LocalDateTime date;
	
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "item", joinColumns = @JoinColumn(name = "shop_id"))
	private List<Item> items;

	public Shop() {
	}
    
	public Shop(String userIdentifier2, float total2, LocalDateTime date2) {
		this.userIdentifier = userIdentifier2;
		this.total = total2;
		this.date = date2;
	}

	public Shop(long id, String userIdentifier, float total, LocalDateTime date, List<Item> items) {
		super();
		this.id = id;
		this.userIdentifier = userIdentifier;
		this.total = total;
		this.date = date;
		this.items = items;
	}

	public static Shop convert(ShopDTO shopDTO) {
		Shop shop = new Shop(shopDTO.getUserIdentifier(), shopDTO.getTotal(), shopDTO.getDate());
		shop.setItems(shopDTO.getItems().stream().map(Item::convert).collect(Collectors.toList()));
		return shop;
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



	public float getTotal() {
		return total;
	}



	public void setTotal(float total) {
		this.total = total;
	}



	public LocalDateTime getDate() {
		return date;
	}



	public void setDate(LocalDateTime date) {
		this.date = date;
	}



	public List<Item> getItems() {
		return items;
	}



	public void setItems(List<Item> items) {
		this.items = items;
	}


}
