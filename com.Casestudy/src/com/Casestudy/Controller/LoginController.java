/**
 * 
 */
package com.Casestudy.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.Casestudy.DAO.EmployeeDAO;
import com.Casestudy.DAO.ProjectDAO;
import com.Casestudy.Models.EmpLogin;
import com.Casestudy.Models.Employee;
import com.Casestudy.Models.Project;
import com.Casestudy.services.Login;


/**
 * @author amahome
 *
 */
@Controller
@RequestMapping("/")
public class LoginController {
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setDisallowedFields(new String[] {"username"});
	}
	
	
	@RequestMapping(value = "/", method=RequestMethod.GET)
	public ModelAndView displayHomePage() {
		return new ModelAndView("index");
	}
	
	@RequestMapping(value = "/home", method=RequestMethod.GET)
	public ModelAndView displayIndexPage() {
		return new ModelAndView("index");
	}
	
//	@RequestMapping(value="/login", method = RequestMethod.GET)
//	@ResponseBody
//	public String getResponse(@RequestParam("empEmail") String email,
//				@RequestParam("empPassword") String password, HttpSession session) {
//		Login login = new Login();
//		session.setAttribute("empemail", email);
//		String errorMsg = login.loginValidation(email, password);
//		return errorMsg;
//	}
	
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView dashboard(@ModelAttribute("empkey") @Valid EmpLogin empLogin,
			BindingResult errors, HttpSession session) {
		Login login = new Login();
		Employee emp = new Employee();
		EmployeeDAO empDAO = new EmployeeDAO();
		session.setAttribute("empEmail", empLogin.getEmpEmail());
		List<Employee> empList = new ArrayList<Employee>();
		if (errors.hasErrors()) {
			ModelAndView mav = new ModelAndView ("index");
			return mav;
		}else {
			System.out.println(empLogin.getEmpEmail());
			String errorMsg = login.loginValidation(empLogin.getEmpEmail(), empLogin.getEmpPassword());
			session.setAttribute("errorMsg", errorMsg);
			emp = empDAO.getEmployeeByEmail(empLogin.getEmpEmail());
			if (errorMsg.equals("Admin")) {
				ModelAndView mav = new ModelAndView ("adminDashboard");
				empList = empDAO.getAllEmployee();
				session.setAttribute("empName", emp.getFullName());
				mav.addObject("listEmp", empList);
				mav.addObject("message", errorMsg);
				mav.addObject("fullName", emp.getFullName());
				return mav;
			}else if(errorMsg.equals("Employee")){
				ModelAndView mav = new ModelAndView ("empDashboard");
				empList = empDAO.getAllEmployee();
				session.setAttribute("empName", emp.getFullName());
				List<Project> projectList = new ArrayList<Project>();
				ProjectDAO projectDAO = new ProjectDAO();
				projectList = projectDAO.getAllProjects();
				mav.addObject("projects", projectList);
				mav.addObject("message", errorMsg);
				mav.addObject("fullName", emp.getFullName());
				return mav;
			}else {
				ModelAndView mav = new ModelAndView("index");
				mav.addObject("message", errorMsg);
				return mav;
			}

		}
	}
	
	@RequestMapping(value = "/dashboard", method=RequestMethod.GET)
	public ModelAndView viewDashboard(HttpSession session) {
		Employee emp = new Employee();
		EmployeeDAO empDAO = new EmployeeDAO();
		List<Employee> empList = new ArrayList<Employee>();
		emp = empDAO.getEmployeeByEmail((String) session.getAttribute("empEmail"));
		if (session.getAttribute("errorMsg").equals("Admin")) {
			ModelAndView mav = new ModelAndView ("adminDashboard");
			empList = empDAO.getAllEmployee();
			mav.addObject("listEmp", empList);
			mav.addObject("fullName", emp.getFullName());
			return mav;
		}else if(session.getAttribute("errorMsg").equals("Employee")){
			ModelAndView mav = new ModelAndView ("empDashboard");
			List<Project> projectList = new ArrayList<Project>();
			ProjectDAO projectDAO = new ProjectDAO();
			projectList = projectDAO.getAllProjects();
			mav.addObject("projects", projectList);
			mav.addObject("fullName", emp.getFullName());
			return mav;
		}
		return null;
	
	}
	
	
	@RequestMapping(value = "/forgot-password", method=RequestMethod.GET)
	public ModelAndView forgotPassword() {
		EmployeeDAO empDAO = new EmployeeDAO();
		List<Employee> empList = new ArrayList<Employee>();
		ModelAndView mav = new ModelAndView ("forgotPassword");
		empList = empDAO.getAllEmployee();
		mav.addObject("listEmp", empList);
		return mav;
	}
	
	@RequestMapping(value = "/enter-email", method=RequestMethod.POST)
	public ModelAndView reenterEmail(@RequestParam("email") String email, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		session.setAttribute("empEmail", email);
		Employee emp = new Employee();
		EmployeeDAO empDAO = new EmployeeDAO();
		emp = empDAO.getEmployeeByEmail(email);
		if (emp != null) {
			mav = new ModelAndView ("resetPassword");
		}else {
			mav = new ModelAndView ("forgotPassword");
			mav.addObject("message", "You are not registered!");
		}
		return mav;
	}
	
	
	@RequestMapping(value = "/passwordReset", method=RequestMethod.POST)
	public ModelAndView resetPassword(@RequestParam("newPswd") String newPassword, @RequestParam("conPswd") String conPassword,
			HttpSession session) {
		ModelAndView mav = new ModelAndView();
		EmployeeDAO empDAO = new EmployeeDAO();
		boolean changePswd;
		String email = (String)session.getAttribute("empEmail");
		System.out.println(email);
		if (newPassword.equals(conPassword)) {
			changePswd = empDAO.changePassword(conPassword, (String)session.getAttribute("empEmail"));
			if (changePswd) {
				mav = new ModelAndView ("index");
			}else {
				mav = new ModelAndView ("resetPassword");
				mav.addObject("message", "Password not reset!");
			}
		}else {
			mav = new ModelAndView ("resetPassword");
			mav.addObject("message", "Password does not match!");
		}
		return mav;
	}
	
	@RequestMapping(value = "/logout", method=RequestMethod.GET)
	public ModelAndView logoutUser(HttpSession session) {
        session.setAttribute("empEmail", null);
        session.setAttribute("empkey", null);
        return new ModelAndView("index");
	}
	
	@ModelAttribute("empkey")
	public EmpLogin setupUserModel(String empEmail, String empPassword) {
		return new EmpLogin(empEmail, empPassword);
	}
	
//	@ModelAttribute("empkey")
//	public Employee setupUserModel(String fullName, String empEmail, String empPassword, int roleNumber, String desnName) {
//		return new Employee(fullName, empEmail, empPassword, roleNumber, desnName);
//	}
}
