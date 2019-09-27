package io.jctiru.springbootcrudrest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.jctiru.springbootcrudrest.dao.EmployeeRepository;
import io.jctiru.springbootcrudrest.entity.Employee;

@Service
public class EmployeeServiceSpringJpaImpl implements EmployeeService {

	// JpaRepository already provides @Transactional functionality
	@Autowired
	private EmployeeRepository employeeDao;

	@Override
	public List<Employee> findAll() {
		return employeeDao.findAll();
	}

	@Override
	public Employee findById(int id) {
		Optional<Employee> result = employeeDao.findById(id);
		Employee employee = null;

		if (result.isPresent()) {
			employee = result.get();
		}

		return employee;
	}

	@Override
	public void save(Employee employee) {
		employeeDao.save(employee);
	}

	@Override
	public void deleteById(int id) {
		employeeDao.deleteById(id);
	}

}
