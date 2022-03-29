package com.supya.ems.bussiness;

import com.supya.ems.Employee;

public class ContractEmployeeSalaryCalculator extends SalaryCalculator
{

	public void calculateNetSalary(Employee e, int actualSalary)
    {
		int grossSalary = getGrossSalary(e,actualSalary);
    	int tds = 2000;
    	int netSalary = grossSalary - tds;
    	System.out.println("Contract Employee Salary Details");
    	System.out.println("EmpId = " + e.getEmpId());
    	System.out.println("EmpName = " + e.getEmpName());
    	System.out.println("Designation " + e.getDesignation());
    	System.out.println("Gross Salary = " + grossSalary);
    	System.out.println("Net Salary " + netSalary);
    	System.out.println("Deduction = "+ tds);
    	
    }
}
