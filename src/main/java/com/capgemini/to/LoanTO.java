package com.capgemini.to;

import java.sql.Timestamp;

public class LoanTO {

	private Long id;
	private CustomerTO customer;
	private CarTO car;
	private OfficeTO officeFrom;
	private OfficeTO officeTo;
	private Timestamp rentalDate;
	private Timestamp returnDate;
	private int loanPrice;

	public LoanTO() {
		super();
	}

	public LoanTO(CustomerTO customer, CarTO car, OfficeTO officeFrom, OfficeTO officeTo, Timestamp rentalDate,
			Timestamp returnDate, int loanPrice) {
		super();
		this.customer = customer;
		this.car = car;
		this.officeFrom = officeFrom;
		this.officeTo = officeTo;
		this.rentalDate = rentalDate;
		this.returnDate = returnDate;
		this.loanPrice = loanPrice;
	}

	public LoanTO(CustomerTO customer, CarTO car, OfficeTO officeFrom, OfficeTO officeTo, Timestamp rentalDate,
			Timestamp returnDate, int loanPrice, Long id) {
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

	public static LoanTOBuilder builder() {
		return new LoanTOBuilder();
	}

	public static class LoanTOBuilder {
		private Long id;
		private CustomerTO customer;
		private CarTO car;
		private OfficeTO officeFrom;
		private OfficeTO officeTo;
		private Timestamp rentalDate;
		private Timestamp returnDate;
		private int loanPrice;

		public LoanTOBuilder() {
			super();
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

		public LoanTOBuilder withRentalDate(Timestamp rentalDate) {
			this.rentalDate = rentalDate;
			return this;
		}

		public LoanTOBuilder withReturnDate(Timestamp returnDate) {
			this.returnDate = returnDate;
			return this;
		}

		public LoanTOBuilder withLoanPrice(int loanPrice) {
			this.loanPrice = loanPrice;
			return this;
		}

		public LoanTO build() {
			checkBeforeBuild(customer, car, officeFrom, officeTo, rentalDate, returnDate, loanPrice);
			return new LoanTO(customer, car, officeFrom, officeTo, rentalDate, returnDate, loanPrice, id);
		}

		private void checkBeforeBuild(CustomerTO customer, CarTO car, OfficeTO officeFrom, OfficeTO officeTo,
				Timestamp rentalDate, Timestamp returnDate, int loanPrice) {
			if (customer == null || car == null || officeFrom == null || officeTo == null || rentalDate == null
					|| returnDate == null || rentalDate.after(returnDate) || loanPrice <= 0) {
				throw new RuntimeException("Incorrect loan to be created");
			}
		}

	}
}