package com.supya.ems.dao;

import java.util.List;

import com.supya.emp.exceptions.EmployeeNotFoundException;
import com.supya.ems.Employee;

public interface IEmployeeDAO 
{
   public abstract  void addEmployee(Employee e);
   public abstract void deleteEmployee(int empId);
   public abstract void updateEmployee(Employee e);
   public abstract  Employee findEmployee(Employee e) throws EmployeeNotFoundException;
   public List<Employee>showAllEmployees();
   public static final String url="jdbc:mysql://localhost:3308/mysql";
   public static final String USERNAME="root";
   public static  final String PASSWORD="Mysql@sup15" ;
   public static final String DRIVER_CLASSNAME="com.mysql.jdbc.Driver";

   
   
   
}
