package com.supya.ems.service;

import java.util.List;

import com.supya.emp.exceptions.EmployeeNotFoundException;
import com.supya.ems.Employee;
import com.supya.ems.dao.EmployeeDAOMysqlImpl;
import com.supya.ems.dao.IEmployeeDAO;

public class EmployeeServiceImpl implements IEmployeeService 
{
	private IEmployeeDAO empDao = new EmployeeDAOMysqlImpl();

	@Override
	public void addEmployee(Employee e)
	{
		empDao.addEmployee(e);
	}

	@Override
	public void deleteEmployee(int empId) 
	{
		empDao.deleteEmployee(empId);

	}

	@Override
	public void updateEmployee(Employee e)
	{
		empDao.updateEmployee(e);
	}

	@Override
	public Employee findEmployee(Employee e) throws EmployeeNotFoundException 
	{
		return empDao.findEmployee(e);
	}

	@Override
	public List<Employee> showAllEmployees() 
	{
		return empDao.showAllEmployees();
	}

}
