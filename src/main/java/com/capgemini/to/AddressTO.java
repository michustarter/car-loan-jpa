package com.capgemini.to;

public class AddressTO {

	private String street;
	private String postCode;
	private String city;

	public AddressTO() {
	}

	public AddressTO(String street, String postCode, String city) {
		super();
		this.street = street;
		this.postCode = postCode;
		this.city = city;
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

	public static AddressTOBuilder builder() {
		return new AddressTOBuilder();
	}

	public static class AddressTOBuilder {
		private String street;
		private String postCode;
		private String city;

		public AddressTOBuilder() {
			super();
		}

		public AddressTOBuilder withStreet(String street) {
			this.street = street;
			return this;
		}

		public AddressTOBuilder withPostCode(String postCode) {
			this.postCode = postCode;
			return this;
		}

		public AddressTOBuilder withCity(String city) {
			this.city = city;
			return this;
		}

		public AddressTO build() {
			checkBeforeBuild(street, postCode, city);
			return new AddressTO(street, postCode, city);
		}

		private void checkBeforeBuild(String street, String postCode, String city) {
			if (street == null || street.isEmpty() || postCode == null || postCode.isEmpty() || city == null
					|| city.isEmpty()) {
				throw new RuntimeException("Incorrect adress to be created");
			}
		}
	}

	@Override
	public String toString() {
		return "AddressTO [street=" + street + ", postCode=" + postCode + ", city=" + city + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((postCode == null) ? 0 : postCode.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
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
		AddressTO other = (AddressTO) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (postCode == null) {
			if (other.postCode != null)
				return false;
		} else if (!postCode.equals(other.postCode))
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		return true;
	}

}