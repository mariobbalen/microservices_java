package br.edu.atitus.product_service.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.atitus.product_service.entities.ProductEntity;
import br.edu.atitus.product_service.repositories.ProductRepository;

@RestController
@RequestMapping("product")
public class OpenProductController {
	private final ProductRepository repo;

	public OpenProductController(ProductRepository repo) {
		super();
		this.repo = repo;
	}
	
	@Value("${server.port}")
	private int serverPort;
	
	@GetMapping("/{idProduct}/{targetCurrency}")
	public ResponseEntity<ProductEntity> getProduct(
				@PathVariable Long idProduct,
				@PathVariable String targetCurrency
			) throws Exception{
		ProductEntity product = repo.findById(idProduct)
				.orElseThrow(()-> new Exception("Product Unsupported"));
		
		product.setConvertedPrice(product.getPrice());
		product.setEnviroment("Product-service running on port: " + serverPort);
		
		return ResponseEntity.ok(product);
	}
}
