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
	
	@Column(name = "brand", length = 60)
	private String brand;
	
	@Column(name = "color", length = 60)
	private String color;
	
	@Column(name = "weight", length=5)
	private String weight;
	
	@Column(name = "volume", length = 5)
	private String volume;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	@Column(name = "stock")
	private int stock;

	@Column(name = "image")
	private String imgURL;

	@Column(name = "description")
	private String description;

	public Product() {
		
	}
	
	public Product(Long id, String nameItem, float price, String brand, String color, String weight, String volume,
			Category category, int stock, String imgURL, String description) {
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
		this.imgURL = imgURL;
		this.description = description;
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

	public String getImgURL() {
		return imgURL;
	}

	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
