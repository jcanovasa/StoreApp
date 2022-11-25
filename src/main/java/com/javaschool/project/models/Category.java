package com.javaschool.project.models;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Categories")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name", length = 60, nullable = false)
	private String name;

	//@OneToMany(mappedBy="category", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	//private List<Product> products;

	public Category() {
		
	}
	
	public Category(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
