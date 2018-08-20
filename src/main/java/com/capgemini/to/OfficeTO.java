package com.capgemini.to;

import java.util.LinkedList;
import java.util.List;

public class OfficeTO {

	private Long id;
	private AddressTO address;
	private String phoneNumber;
	private String mail;
	private List<LoanTO> loansFrom = new LinkedList<>();
	private List<LoanTO> loansTo = new LinkedList<>();

	public OfficeTO() {}

	public OfficeTO(Long id, AddressTO address, String phoneNumber, String mail, List<LoanTO> loansFrom, List<LoanTO> loansTo) {
		super();
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.mail = mail;
		this.id = id;
		this.loansFrom=loansFrom;
		this.loansTo=loansTo;
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

	public List<LoanTO> getLoansFrom() {
		return loansFrom;
	}

	public void setLoansFrom(List<LoanTO> loansFrom) {
		this.loansFrom = loansFrom;
	}

	public List<LoanTO> getLoansTo() {
		return loansTo;
	}

	public void setLoansTO(List<LoanTO> loansTo) {
		this.loansTo = loansTo;
	}

	public static OfficeTOBuilder builder() {
		return new OfficeTOBuilder();
	}

	public static class OfficeTOBuilder {
		private Long id;
		private AddressTO address;
		private String phoneNumber;
		private String mail;
		private List<LoanTO> loansFrom = new LinkedList<>();
		private List<LoanTO> loansTo = new LinkedList<>();

		public OfficeTOBuilder() {}

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
		public OfficeTOBuilder withLoanFrom(LoanTO loanFrom) {
			this.loansFrom.add(loanFrom);
			return this;
		}

		public OfficeTOBuilder withLoansFrom(List<LoanTO> loansFromToAdded) {
			this.loansFrom.addAll(loansFromToAdded);
			return this;
		}
		public OfficeTOBuilder withLoanTo(LoanTO loanTo) {
			this.loansTo.add(loanTo);
			return this;
		}

		public OfficeTOBuilder withLoansTo(List<LoanTO> loansToToAdded) {
			this.loansTo.addAll(loansToToAdded);
			return this;
		}

		public OfficeTO build() {
			checkBeforeBuild(address, phoneNumber, mail);
			return new OfficeTO(id,address, phoneNumber, mail, loansFrom,loansTo);
		}

		private void checkBeforeBuild(AddressTO address, String phoneNumber, String mail) {
			if (address == null || phoneNumber == null || mail == null) {
				throw new RuntimeException("Incorrect office to be created");
			}
		}
	}

	@Override
	public String toString() {
		return "OfficeTO [id=" + id + ", address=" + address + ", phoneNumber=" + phoneNumber + ", mail=" + mail
				+ ", loansFrom=" + loansFrom + ", loansTo=" + loansTo + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((loansFrom == null) ? 0 : loansFrom.hashCode());
		result = prime * result + ((loansTo == null) ? 0 : loansTo.hashCode());
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
		if (loansFrom == null) {
			if (other.loansFrom != null)
				return false;
		} else if (!loansFrom.equals(other.loansFrom))
			return false;
		if (loansTo == null) {
			if (other.loansTo != null)
				return false;
		} else if (!loansTo.equals(other.loansTo))
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
