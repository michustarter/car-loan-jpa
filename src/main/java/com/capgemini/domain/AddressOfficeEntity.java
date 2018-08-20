package com.capgemini.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.capgemini.listeners.CreateEntityListener;
import com.capgemini.listeners.UpdateEntityListener;

@Entity
@Table(name = "address_office")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@EntityListeners({ CreateEntityListener.class, UpdateEntityListener.class })
public class AddressOfficeEntity  implements Serializable {

	private static final long serialVersionUID = 6858137678875851034L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false, length = 50)
	private String street;

	@Column(nullable = false, length = 6)
	private String postCode;

	@Column(nullable = false, length = 50)
	private String city;

	public AddressOfficeEntity() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}