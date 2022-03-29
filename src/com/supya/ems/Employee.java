package com.supya.ems;

public class Employee
{
	/**
	 * @param empId
	 * @param empName
	 * @param designation
	 * @param daysAttended
	 */
	public Employee(int empId, String empName, String designation, int daysAttended) {
		this.empId = empId;
		this.empName = empName;
		this.designation = designation;
		this.daysAttended = daysAttended;
	}

	/**
	 * 
	 */
	public Employee() 
	{
		super();
		// TODO Auto-generated constructor stub
	}

	private int empId;
	private String empName;
	private String designation;
	private int daysAttended;

	public int getEmpId() 
	{
		return empId;
	}

	public String getEmpName() 
	{
		return empName;
	}

	public String getDesignation()
	{
		return designation;
	}

	public int getDaysAttended() 
	{
		return daysAttended;
	}

	public void setEmpId(int empId)
	{
		this.empId = empId;
	}

	public void setEmpName(String empName) 
	{
		this.empName = empName;
	}

	public void setDesignation(String designation) 
	{
		this.designation = designation;
	}

	public void setDaysAttended(int daysAttended) 
	{
		this.daysAttended = daysAttended;
	}
}