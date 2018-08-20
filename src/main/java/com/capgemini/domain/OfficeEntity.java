package com.capgemini.domain;

import java.io.Serializable;
import java.util.LinkedList;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.capgemini.listeners.CreateEntityListener;
import com.capgemini.listeners.UpdateEntityListener;

@Entity
@Table(name = "office")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@EntityListeners({ CreateEntityListener.class, UpdateEntityListener.class })
public class OfficeEntity extends AbstractEntity implements Serializable {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToOne
	@JoinColumn(name="address_id")
	private AddressOfficeEntity address;

	@Column(nullable = false, length = 12)
	private String phoneNumber;

	@Column(nullable = false, length = 30)
	private String mail;
	
	@OneToMany(targetEntity = LoanEntity.class, mappedBy = "officeFrom", cascade = CascadeType.REMOVE)
    private List<LoanEntity> loansFrom = new LinkedList<>();

    @OneToMany(targetEntity = LoanEntity.class, mappedBy = "officeTo", cascade = CascadeType.REMOVE)
    private List<LoanEntity> loansTo = new LinkedList<>();

	public OfficeEntity() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AddressOfficeEntity getAddress() {
		return address;
	}

	public void setAddress(AddressOfficeEntity address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public List<LoanEntity> getLoansFrom() {
		return loansFrom;
	}

	public void setLoansFrom(List<LoanEntity> loansFrom) {
		this.loansFrom = loansFrom;
	}

	public List<LoanEntity> getLoansTo() {
		return loansTo;
	}

	public void setLoansTo(List<LoanEntity> loansTo) {
		this.loansTo = loansTo;
	}

	
}
