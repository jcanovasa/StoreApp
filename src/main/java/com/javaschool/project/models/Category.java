package com.javaschool.project.models;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Categories")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "category", length = 60, nullable = false)
	private String category;
	
	@OneToMany(mappedBy="category", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Product> products;

	public Category() {
		
	}
	
	public Category(Long id, String category) {
		super();
		this.id = id;
		this.category = category;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
