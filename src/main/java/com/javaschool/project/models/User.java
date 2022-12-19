package com.javaschool.project.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "Users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name", length = 60, nullable = false)
	private String name;
	
	@Column(name = "surname", length = 60, nullable = false)
	private String surname;
	
	@Column(name = "email", length = 60, nullable = false)
	private String email;

	@Column(name = "data_birth", length = 60, nullable = false)
	@Temporal(TemporalType.DATE)
	private Date birth;

	@Column(name = "password", length = 60)
	private String pwd;

	@Column(name = "rol")
	private String rol;

	//Aquí la anotación JoinColumn, el 'name' se utiliza para especificar el nombre
	//de la columna en la tabla de usuarios que almacenará la clave foránea que se refiere a la clave
	//primaria de tabla de cesta
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "order_id", referencedColumnName = "id")
	private Order order;


	public User(){}

	public User(Long id, String name, String surname, String email, Date birth, String pwd, String rol, Order order) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.birth = birth;
		this.pwd = pwd;
		this.rol = rol;
		this.order = order;
	}


	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
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

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getRol() {
		return rol;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	

}
