package br.edu.atitus.product_service.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.atitus.product_service.clients.CurrencyClient;
import br.edu.atitus.product_service.clients.CurrencyResponse;
import br.edu.atitus.product_service.entities.ProductEntity;
import br.edu.atitus.product_service.repositories.ProductRepository;

@RestController
@RequestMapping("product")
public class OpenProductController {
	private final ProductRepository repo;
	private final CurrencyClient currencyClient;

	public OpenProductController(ProductRepository repo, CurrencyClient currencyClient) {
		super();
		this.repo = repo;
		this.currencyClient = currencyClient;
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
		
		if(targetCurrency.equals(product.getCurrency()))
			product.setConvertedPrice(product.getPrice());
		else {
			CurrencyResponse currency = currencyClient.getCurrency(product.getPrice(), product.getCurrency(), targetCurrency);
			product.setConvertedPrice(currency.getConvertedValue());
			product.setEnviroment(product.getEnviroment() + " - " + currency.getEnviroment());
		}
		
		return ResponseEntity.ok(product);
	}
}
