package com.supya.emp.exceptions;

@SuppressWarnings("serial")
public class EmployeeNotFoundException extends Exception
{
      private int empID;
     
	public EmployeeNotFoundException(int empId) {
		this.empID = empId;
	}
	
	public String toString()
	{
		   return "Employee Not Found Exception " + this.empID;
	}

}
