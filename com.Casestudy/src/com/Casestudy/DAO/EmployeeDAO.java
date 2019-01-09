/**
 * 
 */
package com.Casestudy.DAO;

import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.Casestudy.DAOI.EmployeeDAOI;
import com.Casestudy.Models.Address;
import com.Casestudy.Models.EmpAddress;
import com.Casestudy.Models.Employee;


/**
 * @author amahome
 *
 */
public class EmployeeDAO extends OracleConnection implements EmployeeDAOI{
	
	/**
	 * @author Manju Ajithkumar
	 * This method gets the employee details according to the email, from the database
	 * @param empEmail
	 * return type - Employee (object)
	 *
	 */
	
	Employee employee = new Employee();
	Connection connection = null;
	public Employee getEmployeeByEmail(String empEmail) {
		try {
			connection = getConnection();
			ps = connection.prepareStatement(SQL.GET_EMPLOYEE_BY_EMAIL.getQuery());
			ps.setString(1, empEmail);
			rs = ps.executeQuery();
			if (rs.next()) {
				Employee employee = new Employee(rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getInt(4), rs.getString(5));
                return employee;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.dispose();
		}
		return null;
	}
	
	
	/**
	 * @author Manju Ajithkumar
	 * This method adds an employee to the database
	 * the method first checks if the employee already exists in the database and then if not exists adds the employee
	 * @param fullName, empEmail, role, desgn
	 * return type - boolean
	 *
	 */
	
	public boolean addEmployee(String fullName, String empEmail, int role, String desgn) {
		String s = RandomString.getAlphaNumericString(7);
		int roleId=0;
		int desgnId=0;
		try {
			connection = getConnection();
			ps = connection.prepareStatement(SQL.CHECK_EMP_EXISTS.getQuery());
			ps.setString(1, fullName);
			rs = ps.executeQuery();
			if (rs.next()) {
				System.out.println("Already registered!");
				return false;
			}else {
				connection = getConnection();
				ps = connection.prepareStatement(SQL.GET_EMPROLE_ID.getQuery());
				ps.setInt(1, role);
				rs = ps.executeQuery();
				if (rs.next()) {
					roleId = rs.getInt(1);
				}
				ps = connection.prepareStatement(SQL.GET_EMPDESGN_ID.getQuery());
				ps.setString(1, desgn);
				rs = ps.executeQuery();
				if (rs.next()) {
					desgnId = rs.getInt(1);
				}
				ps = connection.prepareStatement(SQL.ADD_EMPLOYEE.getQuery());
				ps.setString(1, fullName);
				ps.setString(2, empEmail);
				ps.setString(3, s);
				ps.setInt(4, roleId);
				ps.setInt(5, desgnId);
				rs = ps.executeQuery();
				if (rs.next()) {
					return true;
				}
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.dispose();
		}
		return false;		
	}
	
	
	/**
	 * @author Manju Ajithkumar
	 * This method gets the employee id according to the fullName, from the database
	 * @param fullName
	 * return type - int
	 *
	 */
	
	
	public int getEmpId(String fullName) {
		int empId = 0;
		try {
			connection = getConnection();
			ps = connection.prepareStatement(SQL.GET_EMP_ID.getQuery());
			rs = ps.executeQuery();
			if (rs.next()) {
				empId = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.dispose();
			return empId;
		}

	}
	
	
	/**
	 * @author Manju Ajithkumar
	 * This method gets the lists of all the employees from the database
	 *
	 * return type - List<Employee>
	 *
	 */
	
	public List<Employee> getAllEmployee(){
		List<Employee> empList = new ArrayList<Employee>();
		try {
			connection = getConnection();
			ps = connection.prepareStatement(SQL.GET_ALL_EMPLOYEE.getQuery());
			rs = ps.executeQuery();
			while (rs.next()) {
				empList.add(new Employee(rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getInt(4), rs.getString(5)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.dispose();
			return empList;
		}
	}
	
	
	/**
	 * @author Manju Ajithkumar
	 * This method changes the passsword of an employee according to the given email
	 *@param empPassword, empEmail
	 * return type - boolean
	 *
	 */
	
	public boolean changePassword(String empPassword, String empEmail) {
		try {
			connection = getConnection();
			ps = connection.prepareStatement(SQL.CHANGE_PASSWORD.getQuery());
			ps.setString(1, empPassword);
			ps.setString(2, empEmail);
			rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.dispose();
		}
		return false;
	}
	
	/**
	 * @author Manju Ajithkumar
	 * This method validates the email and password of an employee and returns the role of the employee
	 *@param Employee emp, String empPassword
	 * return type - String
	 *
	 */
	
	public String validateEmployee(Employee emp, String empPassword){
		if (emp.getEmpPassword() != null) {
			if(emp.getEmpPassword().equals(empPassword) && emp.getRoleNumber() == 1) {
				return "Admin";
			}else if (emp.getEmpPassword().equals(empPassword)){
				return "Employee";
			}else {
				return "Not a registered Employee";
			}
		}
		return "not good";
	}
    
	/**
	 * @author Manju Ajithkumar
	 * This method gets the id of the employee for the given email
	 *@param String fullName
	 * return type - int
	 *
	 */
	
	
    public int getEmployeeIdByName(String fullName) {
    	int empId = 0;
		try {
			connection = getConnection();
			ps = connection.prepareStatement(SQL.GET_EMPLOYEEID_BY_NAME.getQuery());
			ps.setString(1, fullName);
			rs = ps.executeQuery();
			if (rs.next()) {
				empId = rs.getInt(1);
				return empId;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.dispose();
		}
		return empId;
    }


}
