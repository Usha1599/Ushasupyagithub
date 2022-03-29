package com.supya.ems.bussiness;

import com.supya.ems.Employee;

public class PermanentEmployeeSalaryCalculator extends SalaryCalculator
{
	
	public void calculateNetSalary(Employee e, int actualSalary)
    {
    	int grossSalary = getGrossSalary(e,actualSalary);
    	int incometax = 1000; 
    	int pf = 800;
    	int gratuity = 100;
    	int netSalary = grossSalary - (incometax + pf + gratuity);
    	System.out.println("Permanent Employee Salary Details");
    	System.out.println("EmpId = " + e.getEmpId());
    	System.out.println("EmpName = " + e.getEmpName());
    	System.out.println("Designation " + e.getDesignation());
    	System.out.println("Gross Salary = " + grossSalary);
    	System.out.println("Net Salary " + netSalary);
    	System.out.println("Deduction = "+ (pf + incometax + gratuity));
    	
    }
}
