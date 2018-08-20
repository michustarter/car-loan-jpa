package com.capgemini.service;

import java.util.ArrayList;
import java.util.Date;

import com.capgemini.util.NotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.to.AddressTO;
import com.capgemini.to.EmployeeTO;
import com.capgemini.to.OfficeTO;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = "spring.profiles.active=hsql")
@Transactional
public class EmployeeServiceTest {

    @Autowired
    private EmployeeService employeeService;

    @Test
    public void testShouldAddNewEmployee() {
        // given
        EmployeeTO newEmployee = employeeService.addNewEmployee(createEmployeeTO());

        // when
        EmployeeTO foundEmployee = employeeService.findEmployeeById(newEmployee.getId());

        // then
        assertThat(foundEmployee, equalTo(newEmployee));
    }

    @Test
    public void testShouldDeleteEmployee() {
        // given
        EmployeeTO employee = employeeService.addNewEmployee(createEmployeeTO());

        // when
        employeeService.deleteEmployee(employee);

        // then
        EmployeeTO found = employeeService.findEmployeeById(employee.getId());
        assertThat(found, nullValue());
    }

    @Test
    public void testShouldFindEmployeeById() {
        // given
        EmployeeTO employee = employeeService.addNewEmployee(createEmployeeTO());

        // when
        EmployeeTO found = employeeService.findEmployeeById(employee.getId());

        // then
        assertThat(found, equalTo(employee));
    }

    @Test
    public void testShouldUpdateEmployeeData() {
        // given
        EmployeeTO employee = employeeService.addNewEmployee(createEmployeeTO());

        // when
        employee.setFirstName("Tomasz");
        employee.setLastName("Janicki");
        EmployeeTO updatedEmployee = employeeService.update(employee);

        // then
        EmployeeTO found = employeeService.findEmployeeById(updatedEmployee.getId());
        assertThat(found, equalTo(updatedEmployee));
    }

    @Test
    public void testShouldDeleteEmployeeFromOffice() {
        // given
        AddressTO address = new AddressTO.AddressTOBuilder()
                .withStreet("Jeziorna")
                .withPostCode("99-120")
                .withCity("Kutno")
                .build();

        OfficeTO office = new OfficeTO.OfficeTOBuilder()
                .withAddress(address)
                .withPhoneNumber("123456123456")
                .withMail("mail@mail.com")
                .build();

        EmployeeTO employee = new EmployeeTO.EmployeeTOBuilder()
                .withOffice(office)
                .withFirstName("Kazimierz")
                .withLastName("Wielki")
                .withBirthDate(new Date(19890303))
                .withCars(new ArrayList<>())
                .build();

        employee = employeeService.addNewEmployee(employee);

        // when
        EmployeeTO found = employeeService.deleteEmployeeFromOffice(employee);

        // then
        assertThat(found.getOffice(), nullValue());
    }

    @Test(expected = NotFoundException.class)
    public void testShouldThrowNotFoundExceptionIfEmployeeIdIsEqualToNull() {
        // given
        EmployeeTO employee = createEmployeeTO();
        employee = employeeService.addNewEmployee(employee);
        employee.setId(null);

        // expect
        employeeService.deleteEmployeeFromOffice(employee);
    }

    private static EmployeeTO createEmployeeTO() {
        return new EmployeeTO.EmployeeTOBuilder()
                .withFirstName("Kazimierz")
                .withLastName("Wielki")
                .withBirthDate(new Date(19890303))
                .withCars(new ArrayList<>())
                .build();
    }
}
