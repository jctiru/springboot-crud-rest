package io.jctiru.springbootcrudrest.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import io.jctiru.springbootcrudrest.entity.Employee;

@Repository
public class EmployeeDaoHibernateImpl implements EmployeeDao {

	@Autowired
	private EntityManager entityManager;

	@Override
	@Transactional
	public List<Employee> findAll() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Employee> query = currentSession.createQuery("from Employee", Employee.class);
		List<Employee> employeeList = query.getResultList();

		return employeeList;
	}

}
