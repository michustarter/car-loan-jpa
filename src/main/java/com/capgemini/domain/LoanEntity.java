package com.capgemini.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.capgemini.listeners.CreateEntityListener;
import com.capgemini.listeners.UpdateEntityListener;

@Entity
@Table(name = "loan")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@EntityListeners({ CreateEntityListener.class, UpdateEntityListener.class })
public class LoanEntity extends AbstractEntity implements Serializable {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
    private CustomerEntity customer;

	@ManyToOne
    private CarEntity car;

	@ManyToOne
	private OfficeEntity officeFrom;

	@ManyToOne
	private OfficeEntity officeTo;

	@Column(nullable = false)
	private Timestamp rentalDate;

	@Column(nullable = true)
	private Timestamp returnDate;

	@Column(nullable = false)
	private int loanPrice;

	public LoanEntity() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CustomerEntity getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}

	public CarEntity getCar() {
		return car;
	}

	public void setCar(CarEntity car) {
		this.car = car;
	}

	public OfficeEntity getOfficeFrom() {
		return officeFrom;
	}

	public void setOfficeFrom(OfficeEntity officeFrom) {
		this.officeFrom = officeFrom;
	}

	public OfficeEntity getOfficeTo() {
		return officeTo;
	}

	public void setOfficeTo(OfficeEntity officeTo) {
		this.officeTo = officeTo;
	}

	public Timestamp getRentalDate() {
		return rentalDate;
	}

	public void setRentalDate(Timestamp rentalDate) {
		this.rentalDate = rentalDate;
	}

	public Timestamp getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Timestamp returnDate) {
		this.returnDate = returnDate;
	}

	public int getLoanPrice() {
		return loanPrice;
	}

	public void setLoanPrice(int loanPrice) {
		this.loanPrice = loanPrice;
	}

}
