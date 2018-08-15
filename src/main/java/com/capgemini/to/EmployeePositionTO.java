package com.capgemini.to;

public class EmployeePositionTO {

	private Long id;
	private String position;

	public EmployeePositionTO() {
		super();
	}

	public EmployeePositionTO(String position) {
		super();
		this.position = position;
	}

	public EmployeePositionTO(String position, Long id) {
		super();
		this.position = position;
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public static EmployeePositionTOBuilder builder() {
		return new EmployeePositionTOBuilder();
	}

	public static class EmployeePositionTOBuilder {
		private Long id;
		private String position;

		public EmployeePositionTOBuilder() {
			super();
		}
		public EmployeePositionTOBuilder withId(Long id) {
			this.id=id;
			return this;
		}
		public EmployeePositionTOBuilder withPosition(String position) {
			this.position=position;
			return this;
		}
		public EmployeePositionTO build() {
			checkBeforeBuild(position);
			return new EmployeePositionTO(position, id);
		}
		private void checkBeforeBuild(String position) {
			if (position == null||position.isEmpty()) {
				throw new RuntimeException("Incorrect employeePosition to be created");
			}
		}
	}

	@Override
	public String toString() {
		return "EmployeePositionTO [id=" + id + ", position=" + position + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((position == null) ? 0 : position.hashCode());
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
		EmployeePositionTO other = (EmployeePositionTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		return true;
	}
	
}
