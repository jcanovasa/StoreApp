package com.javaschool.project.models;

import javax.persistence.*;

@Entity
@Table(name="Products")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nameItem", length = 60, nullable = false) 
	private String nameItem;
	
	@Column(name = "price", nullable = false)
	private float price;
	
	@Column(name = "brand", length = 60, nullable = false)
	private String brand;
	
	@Column(name = "color", length = 60, nullable = false)
	private String color;
	
	@Column(name = "weight", nullable = false)
	private String weight;
	
	@Column(name = "volume", length = 60, nullable = false)
	private String volume;
	
	@ManyToOne
	@JoinColumn(name = "category", nullable = false) 
	private Category category;
	
	@Column(name = "stock", nullable = false)
	private int stock;

	public Product() {
		
	}
	
	public Product(Long id, String nameItem, float price, String brand, String color, String weight, String volume,
			Category category, int stock) {
		super();
		this.id = id;
		this.nameItem = nameItem;
		this.price = price;
		this.brand = brand;
		this.color = color;
		this.weight = weight;
		this.volume = volume;
		this.category = category;
		this.stock = stock;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNameItem() {
		return nameItem;
	}

	public void setNameItem(String nameItem) {
		this.nameItem = nameItem;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

}
