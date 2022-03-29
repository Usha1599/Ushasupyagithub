package com.supya.ems.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.supya.emp.exceptions.EmployeeNotFoundException;
import com.supya.ems.Employee;

public class EmployeeDAOMysqlImpl implements IEmployeeDAO 
{

	private Connection cn = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;

	public static final String INS_COMMAND = " INSERT INTO employee VALUES(?,?,?,?)";
	public static final String UPDATE_COMMAND = "UPDATE employee SET empname=?, designation=?, WHERE empId=?";
	public static final String DELETE_COMMAND = "DELETE FROM employee WHERE empId=?";
	public static final String FIND_COMMAND = "SELECT * FROM  employee WHERE empId=?";
	public static final String SELECT_ALL = "SELECT * FROM employee ";

	public EmployeeDAOMysqlImpl()
	{

		try 
		{
			cn = DriverManager.getConnection(IEmployeeDAO.url, IEmployeeDAO.USERNAME, IEmployeeDAO.PASSWORD);
		} catch (SQLException e)
		{
			System.out.println("Unable to establish the connection with Database");

			e.printStackTrace();
		}

	}

	@Override
	public void addEmployee(Employee e)
	{
		int i = 0;
		try 
		{
			pst = cn.prepareStatement(INS_COMMAND);
			pst.setInt(1, e.getEmpId());
			pst.setString(2, e.getEmpName());
			pst.setString(3, e.getDesignation());
			pst.setInt(4, e.getDaysAttended());
			i = pst.executeUpdate();

		} catch (SQLException e1)
		{
			System.out.println(" Adding record failed..Unable to execute ");
			e1.printStackTrace();
		} finally
		{
			try
			{
				pst.close();
			} catch (SQLException e1)
			{
				e1.printStackTrace();
			}
		}
		if (i > 1) 
		{
			System.out.println("Record added...");
		}

	}

	@Override
	public void deleteEmployee(int empId) 
	{
		int i = 0;
		try 
		{
			pst = cn.prepareStatement(DELETE_COMMAND);
			pst.setInt(1, empId);
			i = pst.executeUpdate();
		} catch (SQLException e) 
		{
			System.out.println("Delete operation is failed..Unable to execute");
			e.printStackTrace();
		} finally 
		{
			try 
			{
				pst.close();
			} catch (SQLException e) 
			{

				e.printStackTrace();
			}
			if (i > 0) 
			{
				System.out.println("Record Deleted Successfully");
			}
		}

	}

	@Override
	public void updateEmployee(Employee e) 
	{
		int i = 0;
		try 
		{
			pst = cn.prepareStatement(UPDATE_COMMAND);
			pst.setInt(4, e.getEmpId());
			pst.setString(1, e.getEmpName());
			pst.setString(2, e.getDesignation());
			pst.setInt(3, e.getDaysAttended());
			i = pst.executeUpdate();
		} catch (SQLException e1) {
			System.out.println("Update Operaton failed..Unable to execute");
			e1.printStackTrace();
		} finally 
		{
			try 
			{
				pst.close();
			} catch (SQLException e1)
			{

				e1.printStackTrace();
			}
		}
		if (i > 0)
		{
			System.out.println("Record Updated Successfully");
		}

	}

	@Override
	public Employee findEmployee(Employee e) throws EmployeeNotFoundException
	{
		Employee findTemp = null;
		try 
		{
			findTemp = null;
			pst = cn.prepareStatement(FIND_COMMAND);
			pst.setInt(1, e.getEmpId());
			rs = pst.executeQuery();
			if (rs.next()) 
			{
				throw new EmployeeNotFoundException(e.getEmpId());

			}
			findTemp = new Employee();
			findTemp.setEmpName(rs.getString("empName"));
			findTemp.setDesignation(rs.getString("designation"));
			findTemp.setDaysAttended(rs.getInt("daysAttended"));
			findTemp.setEmpId(e.getEmpId());
		} 
		catch (SQLException e1)
		{
			e1.printStackTrace();
		} 
		catch (EmployeeNotFoundException e1)
		{

			e1.printStackTrace();
		} 
		finally 
		{
			try 
			{
				pst.close();
				rs.close();
			} 
			catch (SQLException e1) 
			{

				e1.printStackTrace();
			}
		}

		return findTemp;
	}

	@Override
	public List<Employee> showAllEmployees()
	{
		Employee selectAllTemp = null;
		List<Employee> elist = new LinkedList<>();
		try
		{
			pst = cn.prepareStatement(SELECT_ALL);
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		try 
		{
			rs = pst.executeQuery();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		try 
		{
			while (rs.next())
			{
				selectAllTemp = new Employee();
				selectAllTemp.setEmpId(rs.getInt("empId"));
				selectAllTemp.setEmpName(rs.getString("empName"));
				selectAllTemp.setDesignation(rs.getString("designation"));
				selectAllTemp.setDaysAttended(rs.getInt("daysAttended"));
				elist.add(selectAllTemp);

			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return elist;
	}

}
