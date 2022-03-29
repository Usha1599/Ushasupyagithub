package com.supya.ems.service;

import java.util.List;

import com.supya.emp.exceptions.EmployeeNotFoundException;
import com.supya.ems.Employee;

public interface IEmployeeService
{
	public abstract  void addEmployee(Employee e);
	   public abstract void deleteEmployee(int empId);
	   public abstract void updateEmployee(Employee e);
	   public abstract  Employee findEmployee(Employee e) throws EmployeeNotFoundException;
	   public List<Employee>showAllEmployees();
}
