package com.capgemini.to;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;

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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.capgemini.listeners.CreateEntityListener;
import com.capgemini.listeners.UpdateEntityListener;


public class EmployeeTO  {

	private static final long serialVersionUID = 4877970461361752711L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "office")
	private OfficeTO office;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="employee_position")
	private EmployeePositionTO employeePosition;

	@Column(nullable = false, length = 20)
	private String firstName;

	@Column(nullable = false, length = 30)
	private String lastName;

	@Column(nullable = false)
	private Timestamp birthDate;

	@ManyToMany(mappedBy = "employee")
	private Collection<CarTO> cars ;


	public EmployeeTO() {
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


	public Collection<CarTO> getCars() {
		return cars;
	}


	public void setCars(Collection<CarTO> cars) {
		this.cars = cars;
	}


	@Override
	public String toString() {
		return "EmployeeEntity [id=" + id + ", office=" + office + ", employeePosition=" + employeePosition
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", birthDate=" + birthDate + ", cars=" + cars
				+ "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
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
		if (!super.equals(obj))
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
