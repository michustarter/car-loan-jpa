package com.capgemini.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.capgemini.listeners.CreateEntityListener;
import com.capgemini.listeners.UpdateEntityListener;

@Entity
@Table(name = "customer")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@EntityListeners({ CreateEntityListener.class, UpdateEntityListener.class })
public class CustomerEntity extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = -4931663921358032018L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false, length = 20)
	private String firstName;

	@Column(nullable = false, length = 30)
	private String lastName;

	@ManyToOne
	@JoinColumn(name = "address_id")
	private AddressCustomerEntity address;

	@OneToMany(targetEntity = LoanEntity.class, mappedBy = "customer", cascade = CascadeType.REMOVE)
	private List<LoanEntity> loans = new ArrayList<>();

	@Column(nullable = false)
	private Date birthDate;

	@Column(nullable = false, length = 12)
	private String phoneNumber;

	@Column(nullable = false, length = 16)
	private String creditCardNumber;

	@Column(nullable = false, length = 30)
	private String mail;

	public CustomerEntity() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public AddressCustomerEntity getAddress() {
		return address;
	}

	public void setAddress(AddressCustomerEntity address) {
		this.address = address;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public List<LoanEntity> getLoans() {
		return loans;
	}

	public void setLoans(List<LoanEntity> loans) {
		this.loans = loans;
	}

}
