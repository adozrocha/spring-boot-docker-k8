package br.com.java.back.end.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.core.dto.ShopDTO;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

	public Shop(String userIdentifier2, float total2, LocalDateTime date2) {
		this.userIdentifier = userIdentifier2;
		this.total = total2;
		this.date = date2;
	}

	public static Shop convert(ShopDTO shopDTO) {
		Shop shop = new Shop(shopDTO.getUserIdentifier(), shopDTO.getTotal(), shopDTO.getDate());
		shop.setItems(shopDTO.getItems().stream().map(Item::convert).collect(Collectors.toList()));
		return shop;
	}

}
