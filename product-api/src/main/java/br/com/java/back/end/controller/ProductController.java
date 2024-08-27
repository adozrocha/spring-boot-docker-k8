package br.com.java.back.end.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import br.com.java.back.end.dto.CategoryDTO;
import br.com.java.back.end.dto.ProductDTO;
//import br.com.java.back.end.exception.ProductNotFoundException;
import br.com.java.back.end.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
		
	@GetMapping
	public List<ProductDTO> getProducts() {		
		return productService.getAll();
	}
	
	@GetMapping("/categorys")
	public List<CategoryDTO> getCategorys() {		
		return productService.getAllCategorys();
	}
	
	@GetMapping("/category/{categoryId}")
	public List<ProductDTO> getProductByCategory(@PathVariable Long categoryId) {		
		return productService.getProductByCategoryId(categoryId);
	}
		
	@GetMapping("/{productIdentifier}")
	public ProductDTO findById(@PathVariable String productIdentifier) throws Exception {
	    return productService.findByProductIdentifier(productIdentifier);
	}
	
	@PostMapping
	public ProductDTO newProduct(@RequestBody ProductDTO productDTO) throws Exception {
	    return productService.save(productDTO);
	}
		
	@DeleteMapping("/{id}")
	public ProductDTO delete(@PathVariable Long id) throws Exception {
	    return productService.delete(id);
	}

	@GetMapping("/pageable")
	public Page<ProductDTO> getProductsPage(Pageable pageable) {
		return productService.getAllPage(pageable);
	}

	@PostMapping("/{id}")
	public ProductDTO editProduct(@PathVariable Long id,
							@RequestBody ProductDTO productDTO) {
		return productService.editProduct(id, productDTO);
	}
	

}
