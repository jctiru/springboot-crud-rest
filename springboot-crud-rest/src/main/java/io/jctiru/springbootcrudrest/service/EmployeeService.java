package io.jctiru.springbootcrudrest.service;

import java.util.List;

import io.jctiru.springbootcrudrest.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll();

	public Employee findById(int id);

	public void save(Employee employee);

	public void deleteById(int id);

}
