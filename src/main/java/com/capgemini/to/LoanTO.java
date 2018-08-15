package com.capgemini.to;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.capgemini.listeners.CreateEntityListener;
import com.capgemini.listeners.UpdateEntityListener;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@EntityListeners({ CreateEntityListener.class, UpdateEntityListener.class })
@Table(name = "loan")
public class LoanTO extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = -6540895967742828596L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	private CustomerTO customer;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "car")
	private CarTO car;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "office_from")
	private OfficeTO officeFrom;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "office_to")
	private OfficeTO officeTo;

	@Column(nullable = false)
	private Timestamp rentalDate;

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Timestamp returnDate;

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private int loanPrice;

	public LoanTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CustomerTO getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerTO customer) {
		this.customer = customer;
	}

	public CarTO getCar() {
		return car;
	}

	public void setCar(CarTO car) {
		this.car = car;
	}

	public OfficeTO getOfficeFrom() {
		return officeFrom;
	}

	public void setOfficeFrom(OfficeTO officeFrom) {
		this.officeFrom = officeFrom;
	}

	public OfficeTO getOfficeTo() {
		return officeTo;
	}

	public void setOfficeTo(OfficeTO officeTo) {
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

	@Override
	public String toString() {
		return "LoanEntity [id=" + id + ", customer=" + customer + ", car=" + car + ", officeFrom=" + officeFrom
				+ ", officeTo=" + officeTo + ", rentalDate=" + rentalDate + ", returnDate=" + returnDate
				+ ", loanPrice=" + loanPrice + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((car == null) ? 0 : car.hashCode());
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + loanPrice;
		result = prime * result + ((officeFrom == null) ? 0 : officeFrom.hashCode());
		result = prime * result + ((officeTo == null) ? 0 : officeTo.hashCode());
		result = prime * result + ((rentalDate == null) ? 0 : rentalDate.hashCode());
		result = prime * result + ((returnDate == null) ? 0 : returnDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoanTO other = (LoanTO) obj;
		if (car == null) {
			if (other.car != null)
				return false;
		} else if (!car.equals(other.car))
			return false;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (loanPrice != other.loanPrice)
			return false;
		if (officeFrom == null) {
			if (other.officeFrom != null)
				return false;
		} else if (!officeFrom.equals(other.officeFrom))
			return false;
		if (officeTo == null) {
			if (other.officeTo != null)
				return false;
		} else if (!officeTo.equals(other.officeTo))
			return false;
		if (rentalDate == null) {
			if (other.rentalDate != null)
				return false;
		} else if (!rentalDate.equals(other.rentalDate))
			return false;
		if (returnDate == null) {
			if (other.returnDate != null)
				return false;
		} else if (!returnDate.equals(other.returnDate))
			return false;
		return true;
	}
	
	
}
