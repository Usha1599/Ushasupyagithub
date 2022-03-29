package com.supya.ems.main;

import com.supya.ems.Employee;
import com.supya.ems.bussiness.ContractEmployeeSalaryCalculator;
import com.supya.ems.bussiness.PermanentEmployeeSalaryCalculator;

public class EmployeeSalaryMain 
{

	public static void main(String[] args) 
	{
       PermanentEmployeeSalaryCalculator pe = new PermanentEmployeeSalaryCalculator();
       pe.calculateNetSalary(new Employee(1234, "A","clerk",29), 30000);
       ContractEmployeeSalaryCalculator ce = new ContractEmployeeSalaryCalculator();
       ce.calculateNetSalary (new Employee(4321,"B","Manager",20),50000);
	}

}
