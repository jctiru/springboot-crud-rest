package io.jctiru.springbootcrudrest.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.jctiru.springbootcrudrest.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	/*
	 * Spring Data’s method parsing uses prefix keywords like find, exists, count,
	 * and delete and a terminating By keyword. Everything you put in between find
	 * and By makes your method name more expressive and does not affect query
	 * derivation.
	 */

	List<Employee> findByLastName(String lastName);

	List<Employee> findAllByOrderByLastName();

	List<Employee> findAllByOrderByLastNameDesc();

}
