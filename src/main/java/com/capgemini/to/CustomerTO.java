package com.capgemini.to;

import java.sql.Timestamp;

public class CustomerTO {

	private Long id;
	private String firstName;
	private String lastName;
	private AddressTO address;
	private Timestamp birthDate;
	private String phoneNumber;
	private String creditCardNumber;
	private String mail;

	public CustomerTO() {
		super();
	}

	public CustomerTO(String firstName, String lastName, AddressTO address, Timestamp birthDate, String phoneNumber,
			String creditCardNumber, String mail) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.birthDate = birthDate;
		this.phoneNumber = phoneNumber;
	}

	public CustomerTO(String firstName, String lastName, AddressTO address, Timestamp birthDate, String phoneNumber,
			String creditCardNumber, String mail, Long id) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.birthDate = birthDate;
		this.phoneNumber = phoneNumber;
		this.id = id;
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

	public AddressTO getAddress() {
		return address;
	}

	public void setAddress(AddressTO address) {
		this.address = address;
	}

	public Timestamp getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Timestamp birthDate) {
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

	public static CustomerTOBuilder builder() {
		return new CustomerTOBuilder();
	}

	public static class CustomerTOBuilder {
		private Long id;
		private String firstName;
		private String lastName;
		private AddressTO address;
		private Timestamp birthDate;
		private String phoneNumber;
		private String creditCardNumber;
		private String mail;

		public CustomerTOBuilder() {
			super();
		}

		public CustomerTOBuilder withId(Long id) {
			this.id = id;
			return this;
		}

		public CustomerTOBuilder withFirstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public CustomerTOBuilder withLastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public CustomerTOBuilder withAddress(AddressTO address) {
			this.address = address;
			return this;
		}

		public CustomerTOBuilder withBirthDate(Timestamp birthDate) {
			this.birthDate = birthDate;
			return this;
		}

		public CustomerTOBuilder withPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
			return this;
		}

		public CustomerTOBuilder withCreditCardNumber(String creditCardNumber) {
			this.creditCardNumber = creditCardNumber;
			return this;
		}

		public CustomerTOBuilder withMail(String mail) {
			this.mail = mail;
			return this;
		}

		public CustomerTO build() {
			checkBeforeBuild(firstName, lastName, address, birthDate, phoneNumber, creditCardNumber, mail);
			return new CustomerTO(firstName, lastName, address, birthDate, phoneNumber, creditCardNumber, mail, id);

		}

		private void checkBeforeBuild(String firstName, String lastName, AddressTO address, Timestamp birthDate,
				String phoneNumber, String creditCardNumber, String mail) {
			if (firstName == null || firstName.isEmpty() || lastName == null || lastName.isEmpty() || address == null
					|| birthDate == null || phoneNumber == null || phoneNumber.length() != 12
					|| creditCardNumber == null || creditCardNumber.length() != 16 || mail == null || mail.isEmpty()) {
				throw new RuntimeException("Incorrect customer to be created");
			}
		}
	}

	@Override
	public String toString() {
		return "CustomerTO [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address
				+ ", birthDate=" + birthDate + ", phoneNumber=" + phoneNumber + ", creditCardNumber=" + creditCardNumber
				+ ", mail=" + mail + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((birthDate == null) ? 0 : birthDate.hashCode());
		result = prime * result + ((creditCardNumber == null) ? 0 : creditCardNumber.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((mail == null) ? 0 : mail.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerTO other = (CustomerTO) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (birthDate == null) {
			if (other.birthDate != null)
				return false;
		} else if (!birthDate.equals(other.birthDate))
			return false;
		if (creditCardNumber == null) {
			if (other.creditCardNumber != null)
				return false;
		} else if (!creditCardNumber.equals(other.creditCardNumber))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (mail == null) {
			if (other.mail != null)
				return false;
		} else if (!mail.equals(other.mail))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		return true;
	}

}