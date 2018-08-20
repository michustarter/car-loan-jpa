package com.capgemini.service;

import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.to.CarTO;
import com.capgemini.to.EmployeeTO;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = "spring.profiles.active=hsql")
@Transactional
public class CarServiceTest {

	@Autowired
    private EmployeeService employeeService;

	@Autowired
    private CarService carService;
    
	@Test
    public void testShouldAddNewCar() {
		// given
		CarTO newCar = createCar();
		CarTO savedCar = carService.addNewCar(newCar);

		// when
		CarTO foundCar = carService.findCarById(savedCar.getId());

		// then
		assertThat(foundCar, equalTo(savedCar));
	}

	@Test
    public void testShouldDeleteCar() {
		// given
		CarTO car = createCar();
		CarTO carToRemove = carService.addNewCar(car);

		// when
		carService.deleteCar(carToRemove.getId());

		// then
		CarTO foundCar = carService.findCarById(carToRemove.getId());
		assertThat(foundCar, nullValue());
 	}
	
	@Test
    public void testShouldUpdateCarData() {
		// given
	 	CarTO car = createCar();
	 	CarTO savedCar = carService.addNewCar(car);

	 	// when
		savedCar.setType("SUV");
		savedCar.setMileage(500000);
		CarTO updatedCar = carService.updateCarData(savedCar);
	 
		// then
		CarTO found = carService.findCarById(updatedCar.getId());
		assertThat(found, equalTo(updatedCar));
	}

	@Test
    public void testShouldFindCarById() {
		// given
		CarTO car = createCar();
		CarTO savedCar = carService.addNewCar(car);

		// when
		CarTO foundCar = carService.findCarById(savedCar.getId());

		// then
		assertThat(foundCar, equalTo(savedCar));
	}

	@Test
	public void testShouldAssignToKeeper() {
		// given
		CarTO car = carService.addNewCar(createCar());
		EmployeeTO keeper = new EmployeeTO.EmployeeTOBuilder()
				.withFirstName("Kazimierz")
				.withLastName("Wielki")
				.withBirthDate(new Date(19890303))
				.withCars(new ArrayList<>())
				.build();

		keeper = employeeService.addNewEmployee(keeper);

		// when
		carService.assignToKeeper(car, keeper);

		// then
		List<CarTO> expectedCars = carService.findCarsByKeeper(keeper);
		assertThat(expectedCars, hasSize(1));
		assertThat(expectedCars, contains(car));
	}

	@Test
    public void testShouldFindCarByTypeAndBrand() {
		// given
	 	CarTO car1 = new CarTO.CarTOBuilder()
			.withType("sedan")
			.withBrand("Audi")
			.withModel("A4")
			.withProductionYear(Year.parse("2000"))
			.withColor("blue")
			.withEngineCapacity(1900)
			.withPower(123)
			.withMileage(233000)
			.build();

		CarTO expectedCar1 = carService.addNewCar(car1);

		CarTO car2 = new CarTO.CarTOBuilder()
			.withType("sedan")
			.withBrand("Audi")
			.withModel("A5")
			.withProductionYear(Year.parse("2007"))
			.withColor("green")
			.withEngineCapacity(2100)
			.withPower(153)
			.withMileage(11100)
			.build();

		CarTO expectedCar2 = carService.addNewCar(car2);

		// when
		List<CarTO> foundCars = carService.findCarsByTypeAndBrand("sedan","Audi");

		// then
		assertThat(foundCars, hasSize(2));
		assertThat(foundCars, contains(expectedCar1, expectedCar2));
	}
	
	@Test
    public void testShouldFindCarsByKeeper() {
		// given
		CarTO car1 = new CarTO.CarTOBuilder()
			.withType("sedan")
			.withBrand("Audi")
			.withModel("A4")
			.withProductionYear(Year.parse("2000"))
			.withColor("blue")
			.withEngineCapacity(1900)
			.withPower(123)
			.withMileage(233000)
			.build();

		car1 = carService.addNewCar(car1);

		CarTO car2 = new CarTO.CarTOBuilder()
			.withType("sedan")
			.withBrand("Audi")
			.withModel("A5")
			.withProductionYear(Year.parse("2007"))
			.withColor("green")
			.withEngineCapacity(2100)
			.withPower(153)
			.withMileage(11100)
			.build();

		car2 = carService.addNewCar(car2);

		List<CarTO> cars = Arrays.asList(car1, car2);
		EmployeeTO keeper = new EmployeeTO.EmployeeTOBuilder()
			.withFirstName("Kazimierz")
			.withLastName("Wielki")
			.withBirthDate(new Date(19890303))
			.withCars(cars)
			.build();

		keeper = employeeService.addNewEmployee(keeper);

		// when
		List<CarTO> keeperCars = carService.findCarsByKeeper(keeper);

		// then
		assertThat(keeperCars, hasSize(2));
		assertThat(keeperCars, contains(car1, car2));
	}

	private static CarTO createCar() {
		return new CarTO.CarTOBuilder()
				.withType("sedan")
				.withBrand("Audi")
				.withModel("A4")
				.withProductionYear(Year.parse("2000"))
				.withColor("blue")
				.withEngineCapacity(1900)
				.withPower(123)
				.withMileage(233000)
				.build();
	}
}
