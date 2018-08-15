package com.capgemini.to;

public class OfficeTO {

	private Long id;
	private AddressTO address;
	private String phoneNumber;
	private String mail;

	public OfficeTO() {
		super();
	}

	public OfficeTO(AddressTO address, String phoneNumber, String mail) {
		super();
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.mail = mail;
	}

	public OfficeTO(AddressTO address, String phoneNumber, String mail, Long id) {
		super();
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.mail = mail;
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AddressTO getAddress() {
		return address;
	}

	public void setAddress(AddressTO address) {
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

	public static OfficeTOBuilder builder() {
		return new OfficeTOBuilder();
	}

	public static class OfficeTOBuilder {
		private Long id;
		private AddressTO address;
		private String phoneNumber;
		private String mail;

		public OfficeTOBuilder() {
			super();
		}

		public OfficeTOBuilder withId(Long id) {
			this.id = id;
			return this;
		}

		public OfficeTOBuilder withAddress(AddressTO address) {
			this.address = address;
			return this;
		}

		public OfficeTOBuilder withPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
			return this;
		}

		public OfficeTOBuilder withMail(String mail) {
			this.mail = mail;
			return this;
		}

		public OfficeTO build() {
			checkBeforeBuild(address, phoneNumber, mail);
			return new OfficeTO(address, phoneNumber, mail, id);
		}

		private void checkBeforeBuild(AddressTO address, String phoneNumber, String mail) {
			if (address == null || phoneNumber == null || mail == null) {
				throw new RuntimeException("Incorrect customer to be created");
			}
		}
	}

	@Override
	public String toString() {
		return "OfficeTO [id=" + id + ", address=" + address + ", phoneNumber=" + phoneNumber + ", mail=" + mail + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		OfficeTO other = (OfficeTO) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
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
