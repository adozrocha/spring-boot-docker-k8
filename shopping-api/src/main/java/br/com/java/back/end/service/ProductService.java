package br.com.java.back.end.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import br.com.core.dto.ProductDTO;
import br.com.core.exception.ProductNotFoundException;
import reactor.core.publisher.Mono;

@Service
public class ProductService {
	
	@Value("http://localhost:8081")
	private String productApiURL;
	
	public ProductDTO getProductById(String id) {

		try {
			WebClient webClient = WebClient.builder()
					.baseUrl(productApiURL)
					.build();

			Mono<ProductDTO> product = webClient.get()
					.uri("/product/" + id)
					.retrieve()
					.bodyToMono(ProductDTO.class);

			return product.block();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ProductNotFoundException();
		}

	}

}
