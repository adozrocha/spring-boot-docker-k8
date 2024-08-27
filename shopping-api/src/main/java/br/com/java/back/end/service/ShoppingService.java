package br.com.java.back.end.service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.core.dto.ShopDTO;
import br.com.java.back.end.converter.DTOConverter;
import br.com.java.back.end.model.Shop;
import br.com.java.back.end.repository.ReportRepository;
import br.com.java.back.end.repository.ShopRepository;

@Service
public class ShoppingService {

	@Autowired
	private ShopRepository shopRepository;
	
	@Autowired
	private ReportRepository reportRepository;
		
	public List<ShopDTO> getAll() {
		List<Shop> shops = shopRepository.findAll();
		return shops.stream().map(DTOConverter::convert).collect(Collectors.toList());		
	}

	public List<ShopDTO> getByUser(String userIdentifier) {
		List<Shop> shops = shopRepository.findAllByUserIdentifier(userIdentifier);
		return shops.stream().map(DTOConverter::convert).collect(Collectors.toList());		
	}
		
	public List<ShopDTO> getByDate(ShopDTO shopDTO) {
		List<Shop> shops = shopRepository.findAllByDateGreaterThan(shopDTO.getDate());
		return shops.stream().map(DTOConverter::convert).collect(Collectors.toList());		
	}
		
	public ShopDTO findById(long ProductId) throws Exception {
		Optional<Shop> shop = shopRepository.findById(ProductId);
		if (shop.isPresent()) {
			return DTOConverter.convert(shop.get());
		}
		throw new Exception();
	}
	
	public ShopDTO save(ShopDTO shopDTO, String key) {		
//		validateProducts(shopDTO.getItems());
		
		shopDTO.setTotal(shopDTO.getItems()
				  .stream()
				  .map(x -> x.getPrice())
				  .reduce((float) 0, Float::sum));
		
		Shop shop = Shop.convert(shopDTO);
		shop.setDate(LocalDateTime.now());
		
		shop = shopRepository.save(shop);
		return DTOConverter.convert(shop);
	}

	public List<ShopDTO> getShopsByFilter(Date dataInicio, Date dataFim, Float valorMinimo) {
		List<Shop> shops = reportRepository.getShopsByFilters(dataInicio, dataFim, valorMinimo);
		return shops.stream().map(DTOConverter::convert).collect(Collectors.toList());		
		
	}

	/*
	private boolean validateProducts(List<ItemDTO> items) {
		for (ItemDTO  item : items) {
			ProductDTO productDTO = productService.getProductByIdentifier(item.getProductIdentifier());
			if (productDTO == null) {
				return false;
			}
			item.setPrice(productDTO.preco());
		}
		return true;		
	}
	*/
	
	
}
