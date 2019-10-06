package io.jctiru.springbootcrudrest;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import io.jctiru.springbootcrudrest.dao.EmployeeRepository;
import io.jctiru.springbootcrudrest.entity.Employee;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootCrudRestApplicationTests {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testFindByFirstName() {
		List<Employee> employeeList = employeeRepository.findByLastName("Salvador");
		employeeList.forEach(e -> System.out.println(e));
	}

	@Test
	public void testFindAllPaging() {
		Pageable pageable = PageRequest.of(9, 1);
		Page<Employee> results = employeeRepository.findAll(pageable);
		results.forEach(e -> System.out.println(e));
	}

	@Test
	public void testFindAllSorting() {
		// List<Employee> employeeList =
		// employeeRepository.findAll(Sort.by("lastName").descending());
		List<Employee> employeeList = employeeRepository.findAllByOrderByLastNameDesc();
		employeeList.forEach(e -> System.out.println(e.getLastName()));
		// employeeList.forEach(System.out::println);
	}

	@Test
	public void testFindAllEmployees() {
		List<Employee> employeeList = employeeRepository.findAllEmployees();
		employeeList.forEach(e -> System.out.println(e.getLastName() + " " + e.getFirstName()));
	}

	@Test
	public void testFindAllEmployeesPartialData() {
		List<Object[]> employeeList = employeeRepository.findAllEmployeesPartialData();
		for (Object[] objects : employeeList) {
			System.out.println(objects[1] + " " + objects[0]);
		}
	}

	@Test
	public void testFindAllEmployeesByFirstName() {
		System.out.println(employeeRepository.findAllEmployeesByFirstName("Yuri"));
	}

	@Test
	@Transactional // JUnit automatically rolls back transaction
	@Rollback(true) // Set to false to disable rollback, default true
	public void testDeleteEmployeeByLastName() {
		employeeRepository.deleteEmployeeByLastName("Salvador");
	}

}
