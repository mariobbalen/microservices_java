package br.edu.atitus.product_service.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "tb_product")
public class ProductEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "product_description", nullable = false)
	private String description;
	@Column(name = "product_brand", nullable = false)
	private String brand;
	@Column(name = "product_model", nullable = false)
	private String model;
	@Column(name = "product_price", nullable = false)
	private double price;
	@Column(name = "product_currency", nullable = false)
	private String currency;
	@Column(name = "product_stock", nullable = false)
	private Integer stock;
	
	@Transient
	private String enviroment;
	@Transient
	private double convertedPrice;
	
	//Getters and Setters
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public String getEnviroment() {
		return enviroment;
	}
	public void setEnviroment(String enviroment) {
		this.enviroment = enviroment;
	}
	public double getConvertedPrice() {
		return convertedPrice;
	}
	public void setConvertedPrice(double convertedPrice) {
		this.convertedPrice = convertedPrice;
	}
	
	
	
}
