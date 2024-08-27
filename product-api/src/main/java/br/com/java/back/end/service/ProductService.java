package br.com.java.back.end.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.java.back.end.dto.CategoryConvertDTO;
import br.com.java.back.end.dto.CategoryDTO;
import br.com.java.back.end.dto.ProductConvertDTO;
import br.com.java.back.end.dto.ProductDTO;
import br.com.java.back.end.exception.CategoryNotFoundException;
import br.com.java.back.end.exception.ProductNotFoundException;
import br.com.java.back.end.model.Category;
import br.com.java.back.end.model.Product;
import br.com.java.back.end.repository.CategoryRepository;
import br.com.java.back.end.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<ProductDTO> getAll(){
		List<Product> products = productRepository.findAll();
		
		return products
				.stream()
				.map(ProductConvertDTO::convert)
				.collect(Collectors.toList());
	}
	
	public List<CategoryDTO> getAllCategorys(){
		List<Category> categorys = categoryRepository.findAll();
		
		return categorys
				.stream()
				.map(CategoryConvertDTO::convert)
				.collect(Collectors.toList());
	}

	
	public List<ProductDTO> getProductByCategoryId(Long categoryId) {
		List<Product> products = productRepository.getProductByCategory(categoryId);
		return products.stream().map(ProductConvertDTO::convert).collect(Collectors.toList());		
	}
	
		
	public ProductDTO findByProductIdentifier(String  productIdentifier) throws Exception {
		Product product = productRepository.findByProductIdentifier(productIdentifier);
		if (product != null) {
			return ProductConvertDTO.convert(product);
		}
		throw new ProductNotFoundException();
	}
	
	public ProductDTO save(ProductDTO productDTO) throws Exception {
		Boolean existsCategory = categoryRepository.existsById(productDTO.category().id());
		if (!existsCategory) {
			throw new CategoryNotFoundException();
		}				
		Product product = productRepository.save(Product.convert(productDTO));
		return ProductConvertDTO.convert(product);
	}
	
	public ProductDTO delete(long id) throws Exception {
		Optional<Product> Product = productRepository.findById(id);
		if (Product.isPresent()) {
			productRepository.delete(Product.get());
		}
		throw new ProductNotFoundException();
	}

	public Page<ProductDTO> getAllPage(Pageable page) {
		Page<Product> users = productRepository.findAll(page);
		return users
				.map(ProductConvertDTO::convert);
	}

	public ProductDTO editProduct(long id, ProductDTO dto) {
		Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));

		if (dto.nome() != null || !dto.nome().isEmpty()) {
			product.setNome(dto.nome());
		}
		if (dto.preco() != null) {
			product.setPreco(dto.preco());
		}
		return ProductConvertDTO.convert(productRepository.save(product));
	}

	

}
