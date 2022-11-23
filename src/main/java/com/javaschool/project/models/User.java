package com.javaschool.project.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

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
	
	public User() {
		
	}

	public User(Long id, String name, String surname, String email, Date birth, String pwd) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.birth = birth;
		this.pwd = pwd;
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
