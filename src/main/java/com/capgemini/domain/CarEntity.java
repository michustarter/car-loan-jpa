package com.capgemini.domain;

import java.io.Serializable;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.capgemini.listeners.CreateEntityListener;
import com.capgemini.listeners.UpdateEntityListener;

@Entity
@Table(name = "car")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@EntityListeners({ CreateEntityListener.class, UpdateEntityListener.class })
public class CarEntity extends AbstractEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false, length = 20)
	private String type;

	@Column(nullable = false, length = 20)
	private String brand;

	@Column(nullable = false, length = 20)
	private String model;

	@Column(nullable = false)
	private Year productionYear;

	@Column(nullable = false, length = 20)
	private String color;

	@Column(nullable = false)
	private int engineCapacity;

	@Column(nullable = false)
	private int power;

	@Column(nullable = false)
	private int mileage;

	@OneToMany(targetEntity = LoanEntity.class, mappedBy = "car", cascade = CascadeType.REMOVE)
	private List<LoanEntity> loans = new ArrayList<>();

	public CarEntity() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Year getProductionYear() {
		return productionYear;
	}

	public void setProductionYear(Year productionYear) {
		this.productionYear = productionYear;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getEngineCapacity() {
		return engineCapacity;
	}

	public void setEngineCapacity(int engineCapacity) {
		this.engineCapacity = engineCapacity;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	public List<LoanEntity> getLoans() {
		return loans;
	}

	public void setLoans(List<LoanEntity> loans) {
		this.loans = loans;
	}

	@Override
	public String toString() {
		return "CarEntity [id=" + id + ", type=" + type + ", brand=" + brand + ", model=" + model + ", productionYear="
				+ productionYear + ", color=" + color + ", engineCapacity=" + engineCapacity + ", power=" + power
				+ ", mileage=" + mileage + ", loans=" + loans + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + engineCapacity;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((loans == null) ? 0 : loans.hashCode());
		result = prime * result + mileage;
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + power;
		result = prime * result + ((productionYear == null) ? 0 : productionYear.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		CarEntity other = (CarEntity) obj;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (engineCapacity != other.engineCapacity)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (loans == null) {
			if (other.loans != null)
				return false;
		} else if (!loans.equals(other.loans))
			return false;
		if (mileage != other.mileage)
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (power != other.power)
			return false;
		if (productionYear == null) {
			if (other.productionYear != null)
				return false;
		} else if (!productionYear.equals(other.productionYear))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}



}
