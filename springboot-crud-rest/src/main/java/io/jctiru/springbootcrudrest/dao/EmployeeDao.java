package io.jctiru.springbootcrudrest.dao;

import java.util.List;

import io.jctiru.springbootcrudrest.entity.Employee;

public interface EmployeeDao {

	public List<Employee> findAll();

	public Employee findById(int id);

	public void save(Employee employee);

	public void deleteById(int id);

}
