package io.jctiru.springbootcrudrest.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.jctiru.springbootcrudrest.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	List<Employee> findByLastName(String lastName);

}
