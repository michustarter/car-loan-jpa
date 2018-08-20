package com.capgemini.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.time.Year;
import java.util.ArrayList;
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

@RunWith(SpringRunner.class)
@SpringBootTest(properties = "spring.profiles.active=hsql" )
public class CarServiceTest {

	@Autowired
    private OfficeService officeService;
	@Autowired
    private EmployeeService employeeService;
	@Autowired
    private CarService carService;
	@Autowired
    private AddressOfficeService addressOfficeService;
	@Autowired
    private AddressCustomerService addressCustomerService;
    
	@Test
    @Transactional
    public void testShouldAddNewCar() {
	//given
	 CarTO newCar=new CarTO.CarTOBuilder()
			 .withType("sedan")
			 .withBrand("Audi")
			 .withModel("A4")
			 .withProductionYear(Year.parse("2000"))
			 .withColor("blue")
			 .withEngineCapacity(1900)
			 .withPower(123)
			 .withMileage(233000)
			 .build();
	 CarTO addedCar=carService.addNewCar(newCar);
	 //when
	 CarTO foundCar=carService.findCarById(addedCar.getId());
	 
	 //then
	 assertEquals(addedCar.getType(), foundCar.getType());
	 assertEquals(addedCar.getBrand(), foundCar.getBrand());
	 assertEquals(addedCar.getModel(), foundCar.getModel());
	 assertEquals(addedCar.getColor(), foundCar.getColor());
	
 }
	@Test
    @Transactional
    public void testShouldDeleteCar() {
	//given
	 CarTO car=new CarTO.CarTOBuilder()
			 .withType("sedan")
			 .withBrand("Audi")
			 .withModel("A4")
			 .withProductionYear(Year.parse("2000"))
			 .withColor("blue")
			 .withEngineCapacity(1900)
			 .withPower(123)
			 .withMileage(233000)
			 .build();
	 CarTO removeCar=carService.addNewCar(car);
	 //when
	 carService.deleteCar(removeCar.getId());
	 
	 //then
	 assertNull(carService.findCarById(removeCar.getId()));
	
 }
	
	@Test
    @Transactional
    public void testShouldUpdateCarData() {
	//given
	 CarTO car=new CarTO.CarTOBuilder()
			 .withType("sedan")
			 .withBrand("Audi")
			 .withModel("A4")
			 .withProductionYear(Year.parse("2000"))
			 .withColor("blue")
			 .withEngineCapacity(1900)
			 .withPower(123)
			 .withMileage(233000)
			 .build();
	 CarTO newCar=carService.addNewCar(car);
	 //when
	newCar.setType("SUV");
	newCar.setMileage(500000);
	CarTO updateCar=carService.updateCarData(newCar);
	 
	//then
	assertEquals("SUV", carService.findCarById(updateCar.getId()).getType());
	assertEquals(500000, carService.findCarById(updateCar.getId()).getMileage());
	}
	@Test
    @Transactional
    public void testShouldFindCarById() {
	//given
	 CarTO car=new CarTO.CarTOBuilder()
			 .withType("sedan")
			 .withBrand("Audi")
			 .withModel("A4")
			 .withProductionYear(Year.parse("2000"))
			 .withColor("blue")
			 .withEngineCapacity(1900)
			 .withPower(123)
			 .withMileage(233000)
			 .build();
	 CarTO addedCar=carService.addNewCar(car);
	 //when
	CarTO wantedCar=carService.findCarById(addedCar.getId());
	 
	//then
	assertEquals(addedCar, wantedCar);
	
	}
	@Test
    @Transactional
    public void testShouldAssignToKeeper() {
	//given
	 CarTO car=new CarTO.CarTOBuilder()
			 .withType("sedan")
			 .withBrand("Audi")
			 .withModel("A4")
			 .withProductionYear(Year.parse("2000"))
			 .withColor("blue")
			 .withEngineCapacity(1900)
			 .withPower(123)
			 .withMileage(233000)
			 .build();
	 
		car = carService.addNewCar(car);
	 
	 List<CarTO> cars=new ArrayList<>();
	 EmployeeTO keeper=new EmployeeTO.EmployeeTOBuilder()
			 .withFirstName("Kazimierz")
			 .withLastName("Wielki")
			 .withBirthDate(new Date(19890303))
			 .withCars(cars)
			 .build();
			 
	 //when
	keeper.getCars().add(car);
	 
	//then
	assertTrue(keeper.getCars().contains(car));
	
	}
	@Test
    @Transactional
    public void testShouldFindCarByTypeAndBrand() {
	//given
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
	//when
		List<CarTO> wantedCars=carService.findCarsByTypeAndBrand("sedan","Audi");

	//then
	assertTrue(wantedCars.contains(car1));
	assertTrue(wantedCars.contains(car2));
	}
	
	@Test
    @Transactional
    public void testShouldFindCarsByKeeper() {
	//given
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
		
		List<CarTO> cars = new ArrayList<>();
		cars.add(car1);
		cars.add(car2);
		EmployeeTO keeper = new EmployeeTO.EmployeeTOBuilder()
				 .withFirstName("Kazimierz")
				 .withLastName("Wielki")
				 .withBirthDate(new Date(19890303))
				 .withCars(cars)
				 .build();
		keeper = employeeService.addNewEmployee(keeper);
		
		
		 //when
		List<CarTO> keeperCars=carService.findCarsByKeeper(keeper);
		 
		//then
		assertTrue(keeperCars.contains(car1));
		assertTrue(keeperCars.contains(car1));
	}
	
}

