/**
 * 
 */
package com.Casestudy.services;

import com.Casestudy.DAO.EmployeeDAO;
import com.Casestudy.Models.Employee;

/**
 * @author amahome
 *
 */
public class Login {
	
	public String loginValidation(String email, String password) {
		EmployeeDAO empDAO = new EmployeeDAO();
		Employee emp = new Employee();
		emp = empDAO.getEmployeeByEmail(email);
		String redirectMessage="";
		if ((email==null || email.isEmpty()) || (password==null || password.isEmpty())) {
			redirectMessage = "Please enter Email and password";
		}else {
			if (emp != null) {
				redirectMessage = empDAO.validateEmployee(emp, password);
			}else {
				redirectMessage = "Not a registered Employee";
			}
		}
		return redirectMessage;
	}

}
