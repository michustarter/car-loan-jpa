package com.capgemini.to;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import org.springframework.util.CollectionUtils;

public class CarTO {

	private Long id;
	private String type;
	private String brand;
	private String model;
	private Year productionYear;
	private String color;
	private int engineCapacity;
	private int power;
	private int mileage;
	private List<EmployeeTO> keepers;

	public CarTO() {
		super();
	}

	public CarTO(String type, String brand, String model, Year productionYear, String color, int engineCapacity,
			int power, int mileage, List<EmployeeTO> keepers) {
		super();
		this.type = type;
		this.brand = brand;
		this.model = model;
		this.productionYear = productionYear;
		this.color = color;
		this.engineCapacity = engineCapacity;
		this.power = power;
		this.mileage = mileage;
		this.keepers = keepers;
	}

	public CarTO(String type, String brand, String model, Year productionYear, String color, int engineCapacity,
			int power, int mileage, List<EmployeeTO> keepers, Long id) {
		super();
		this.type = type;
		this.brand = brand;
		this.model = model;
		this.productionYear = productionYear;
		this.color = color;
		this.engineCapacity = engineCapacity;
		this.power = power;
		this.mileage = mileage;
		this.keepers = keepers;
		this.id = id;
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

	public List<EmployeeTO> getKeepers() {
		return keepers;
	}

	public void setKeepers(List<EmployeeTO> keepers) {
		this.keepers = keepers;
	}

	public static CarTOBuilder builder() {
		return new CarTOBuilder();
	}

	public static class CarTOBuilder {
		private Long id;
		private String type;
		private String brand;
		private String model;
		private Year productionYear;
		private String color;
		private int engineCapacity;
		private int power;
		private int mileage;
		private List<EmployeeTO> keepers = new ArrayList<>();

		public CarTOBuilder() {
			super();
		}

		public CarTOBuilder withId(Long id) {
			this.id = id;
			return this;
		}

		public CarTOBuilder withType(String type) {
			this.type = type;
			return this;
		}

		public CarTOBuilder withBrand(String brand) {
			this.brand = brand;
			return this;
		}

		public CarTOBuilder withModel(String model) {
			this.model = model;
			return this;
		}

		public CarTOBuilder withProductionYear(Year productionYear) {
			this.productionYear = productionYear;
			return this;
		}

		public CarTOBuilder withColor(String color) {
			this.color = color;
			return this;
		}

		public CarTOBuilder withEngineCapacity(int engineCapacity) {
			this.engineCapacity = engineCapacity;
			return this;
		}

		public CarTOBuilder withPower(int power) {
			this.power = power;
			return this;
		}

		public CarTOBuilder withMileage(int mileage) {
			this.mileage = mileage;
			return this;
		}

		public CarTOBuilder withEmployee(EmployeeTO employee) {
			this.keepers.add(employee);
			return this;
		}

		public CarTOBuilder withKeepers(List<EmployeeTO> keepersToBeadded) {
			this.keepers.addAll(keepersToBeadded);
			return this;
		}

		public CarTO build() {
			checkBeforeBuild(type, brand, model, productionYear, color, engineCapacity, power, mileage, keepers);
			return new CarTO(type, brand, model, productionYear, color, engineCapacity, power, mileage, keepers, id);
		}

		private void checkBeforeBuild(String type, String brand, String model, Year productionYear, String color,
				int engineCapacity, int power, int mileage, List<EmployeeTO> keepers) {
			if (type == null || type.isEmpty() || brand == null || brand.isEmpty() || model == null || model.isEmpty()
					|| productionYear == null || color == null || color.isEmpty() || engineCapacity <= 0 || power <= 0
					|| mileage < 0 || CollectionUtils.isEmpty(keepers)) {
				throw new RuntimeException("Incorrect car to be created");
			}
		}
	}

	@Override
	public String toString() {
		return "CarTO [id=" + id + ", type=" + type + ", brand=" + brand + ", model=" + model + ", productionYear="
				+ productionYear + ", color=" + color + ", engineCapacity=" + engineCapacity + ", power=" + power
				+ ", mileage=" + mileage + ", keepers=" + keepers + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + engineCapacity;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((keepers == null) ? 0 : keepers.hashCode());
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
		CarTO other = (CarTO) obj;
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
		if (keepers == null) {
			if (other.keepers != null)
				return false;
		} else if (!keepers.equals(other.keepers))
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