package com.capgemini.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.capgemini.listeners.CreateEntityListener;
import com.capgemini.listeners.UpdateEntityListener;

@Entity
@Table(name = "employee")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@EntityListeners({ CreateEntityListener.class, UpdateEntityListener.class })
public class EmployeeEntity extends AbstractEntity implements Serializable {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "office_id")
	private OfficeEntity office;

	@ManyToOne
	@JoinColumn(name="employee_position_id")
	private EmployeePositionEntity employeePosition;

	@Column(nullable = false, length = 20)
	private String firstName;

	@Column(nullable = false, length = 30)
	private String lastName;

	@Column(nullable = false)
	private Date birthDate;

	@ManyToMany
	@JoinTable(name = "keeper", joinColumns = { @JoinColumn(name = "employee_id") }, inverseJoinColumns = {
			@JoinColumn(name = "car_id") })
	private List<CarEntity> cars=new ArrayList<>();


	public EmployeeEntity() {
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public OfficeEntity getOffice() {
		return office;
	}


	public void setOffice(OfficeEntity office) {
		this.office = office;
	}


	public EmployeePositionEntity getEmployeePosition() {
		return employeePosition;
	}


	public void setEmployeePosition(EmployeePositionEntity employeePosition) {
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


	public Date getBirthDate() {
		return birthDate;
	}


	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}


	public List<CarEntity> getCars() {
		return cars;
	}


	public void setCars(List<CarEntity> cars) {
		this.cars = cars;
	}


	
}
