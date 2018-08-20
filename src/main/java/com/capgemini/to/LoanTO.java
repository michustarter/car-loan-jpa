package com.capgemini.to;

import java.util.Date;

public class LoanTO {

	private Long id;
	private CustomerTO customer;
	private CarTO car;
	private OfficeTO officeFrom;
	private OfficeTO officeTo;
	private Date rentalDate;
	private Date returnDate;
	private int loanPrice;

	public LoanTO() {
	}

	public LoanTO(Long id, CustomerTO customer, CarTO car, OfficeTO officeFrom, OfficeTO officeTo, Date rentalDate,
			Date returnDate, int loanPrice) {
		super();
		this.customer = customer;
		this.car = car;
		this.officeFrom = officeFrom;
		this.officeTo = officeTo;
		this.rentalDate = rentalDate;
		this.returnDate = returnDate;
		this.loanPrice = loanPrice;
		this.id = id;
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

	public Date getRentalDate() {
		return rentalDate;
	}

	public void setRentalDate(Date rentalDate) {
		this.rentalDate = rentalDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public int getLoanPrice() {
		return loanPrice;
	}

	public void setLoanPrice(int loanPrice) {
		this.loanPrice = loanPrice;
	}

	public static LoanTOBuilder builder() {
		return new LoanTOBuilder();
	}

	public static class LoanTOBuilder {
		private Long id;
		private CustomerTO customer;
		private CarTO car;
		private OfficeTO officeFrom;
		private OfficeTO officeTo;
		private Date rentalDate;
		private Date returnDate;
		private int loanPrice;

		public LoanTOBuilder() {
		}

		public LoanTOBuilder withId(Long id) {
			this.id = id;
			return this;
		}

		public LoanTOBuilder withCustomer(CustomerTO customer) {
			this.customer = customer;
			return this;
		}

		public LoanTOBuilder withCar(CarTO car) {
			this.car = car;
			return this;
		}

		public LoanTOBuilder withOfficeFrom(OfficeTO officeFrom) {
			this.officeFrom = officeFrom;
			return this;
		}

		public LoanTOBuilder withOfficeTo(OfficeTO officeTo) {
			this.officeTo = officeTo;
			return this;
		}

		public LoanTOBuilder withRentalDate(Date rentalDate) {
			this.rentalDate = rentalDate;
			return this;
		}

		public LoanTOBuilder withReturnDate(Date returnDate) {
			this.returnDate = returnDate;
			return this;
		}

		public LoanTOBuilder withLoanPrice(int loanPrice) {
			this.loanPrice = loanPrice;
			return this;
		}

		public LoanTO build() {
			checkBeforeBuild(customer, car, officeFrom, officeTo, rentalDate, returnDate, loanPrice);
			return new LoanTO(id, customer, car, officeFrom, officeTo, rentalDate, returnDate, loanPrice);
		}

		private void checkBeforeBuild(CustomerTO customer, CarTO car, OfficeTO officeFrom, OfficeTO officeTo,
				Date rentalDate, Date returnDate, int loanPrice) {
			if (customer == null || car == null || officeFrom == null || officeTo == null || rentalDate == null
					|| returnDate == null || rentalDate.after(returnDate) || loanPrice <= 0) {
				throw new RuntimeException("Incorrect loan to be created");
			}
		}
	}
}
