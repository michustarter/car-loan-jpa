package com.capgemini.to;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.util.CollectionUtils;

public class EmployeeTO {

	private Long id;
	private OfficeTO office;
	private EmployeePositionTO employeePosition;
	private String firstName;
	private String lastName;
	private Timestamp birthDate;
	private List<CarTO> cars;

	public EmployeeTO() {
		super();
	}

	public EmployeeTO(OfficeTO office, EmployeePositionTO employeePosition, String firstName, String lastName,
			Timestamp birthDate, List<CarTO> cars) {
		super();
		this.office = office;
		this.employeePosition = employeePosition;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.cars = cars;
	}

	public EmployeeTO(OfficeTO office, EmployeePositionTO employeePosition, String firstName, String lastName,
			Timestamp birthDate, List<CarTO> cars, Long id) {
		super();
		this.office = office;
		this.employeePosition = employeePosition;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.cars = cars;
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public OfficeTO getOffice() {
		return office;
	}

	public void setOffice(OfficeTO office) {
		this.office = office;
	}

	public EmployeePositionTO getEmployeePosition() {
		return employeePosition;
	}

	public void setEmployeePosition(EmployeePositionTO employeePosition) {
		this.employeePosition = employeePosition;
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

	public Timestamp getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Timestamp birthDate) {
		this.birthDate = birthDate;
	}

	public List<CarTO> getCars() {
		return cars;
	}

	public void setCars(List<CarTO> cars) {
		this.cars = cars;
	}

	public static EmployeeTOBuilder builder() {
		return new EmployeeTOBuilder();
	}

	public static class EmployeeTOBuilder {
		private Long id;
		private OfficeTO office;
		private EmployeePositionTO employeePosition;
		private String firstName;
		private String lastName;
		private Timestamp birthDate;
		private List<CarTO> cars = new ArrayList<>();

		public EmployeeTOBuilder() {
			super();
		}

		public EmployeeTOBuilder withId(Long id) {
			this.id = id;
			return this;
		}

		public EmployeeTOBuilder withOffice(OfficeTO office) {
			this.office = office;
			return this;
		}

		public EmployeeTOBuilder withEmployeePosition(EmployeePositionTO employeePosition) {
			this.employeePosition = employeePosition;
			return this;
		}

		public EmployeeTOBuilder withFirstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public EmployeeTOBuilder withLastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public EmployeeTOBuilder withBirthDate(Timestamp birthDate) {
			this.birthDate = birthDate;
			return this;
		}

		public EmployeeTOBuilder withCar(CarTO car) {
			this.cars.add(car);
			return this;
		}

		public EmployeeTOBuilder withCars(List<CarTO> carsToBeAdded) {
			this.cars.addAll(carsToBeAdded);
			return this;
		}

		public EmployeeTO build() {
			checkBeforeBuild(office, employeePosition, firstName, lastName, birthDate, cars);
			return new EmployeeTO(office, employeePosition, firstName, lastName, birthDate, cars, id);
		}

		private void checkBeforeBuild(OfficeTO office, EmployeePositionTO employeePosition, String firstName,
				String lastName, Timestamp birthDate, List<CarTO> cars) {
			if (office == null || employeePosition == null || firstName == null || firstName.isEmpty()
					|| lastName == null || lastName.isEmpty() || birthDate == null || CollectionUtils.isEmpty(cars)) {
				throw new RuntimeException("Incorrect employee to be created");
			}
		}
	}

	@Override
	public String toString() {
		return "EmployeeTO [id=" + id + ", office=" + office + ", employeePosition=" + employeePosition + ", firstName="
				+ firstName + ", lastName=" + lastName + ", birthDate=" + birthDate + ", cars=" + cars + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((birthDate == null) ? 0 : birthDate.hashCode());
		result = prime * result + ((cars == null) ? 0 : cars.hashCode());
		result = prime * result + ((employeePosition == null) ? 0 : employeePosition.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((office == null) ? 0 : office.hashCode());
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
		EmployeeTO other = (EmployeeTO) obj;
		if (birthDate == null) {
			if (other.birthDate != null)
				return false;
		} else if (!birthDate.equals(other.birthDate))
			return false;
		if (cars == null) {
			if (other.cars != null)
				return false;
		} else if (!cars.equals(other.cars))
			return false;
		if (employeePosition == null) {
			if (other.employeePosition != null)
				return false;
		} else if (!employeePosition.equals(other.employeePosition))
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
		if (office == null) {
			if (other.office != null)
				return false;
		} else if (!office.equals(other.office))
			return false;
		return true;
	}

}
