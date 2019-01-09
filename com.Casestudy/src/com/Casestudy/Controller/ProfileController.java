/**
 * 
 */
package com.Casestudy.Controller;

import java.math.BigDecimal;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.Casestudy.DAO.EmployeeDAO;
import com.Casestudy.DAO.ProfileDAO;
import com.Casestudy.Models.Address;
import com.Casestudy.Models.Employee;
import com.Casestudy.Models.Profile;
import com.Casestudy.Models.Project;

/**
 * @author amahome
 *
 */

@Controller
@RequestMapping("/")
public class ProfileController {
	
	
	@RequestMapping(value = "/profile", method=RequestMethod.GET)
	public ModelAndView displayProfile(HttpSession session) {
		ModelAndView mav = new ModelAndView ("profile");
		String empemail = (String)session.getAttribute("empEmail");
		Employee emp = new Employee();
		EmployeeDAO empDAO = new EmployeeDAO();
		Profile profile = new Profile();
		ProfileDAO profileDAO = new ProfileDAO();
		emp = empDAO.getEmployeeByEmail(empemail);
		profile = profileDAO.getEmpProfileByEmail(empemail);
		mav.addObject("employee", emp);
		mav.addObject("empprofile", profile);
		return mav;
	}
	
	@RequestMapping(value = "/update-profile", method=RequestMethod.GET)
	public ModelAndView updateProfile(@ModelAttribute("profile") Profile profile, HttpSession session) {
		ModelAndView mav = new ModelAndView ("profile");
		String empemail = (String)session.getAttribute("empEmail");
		Employee emp = new Employee();
		EmployeeDAO empDAO = new EmployeeDAO();
		Profile empProfile = new Profile();
		ProfileDAO profileDAO = new ProfileDAO();
		emp = empDAO.getEmployeeByEmail(empemail);
		empProfile = profileDAO.getEmpProfileByEmail(empemail);
		boolean updateProfile;
		boolean updateProfileAddress;
		BigDecimal id = empProfile.getEmpId();
		System.out.println(id);
		updateProfile = profileDAO.updateProfile(profile.getFullName(), profile.getDob(), profile.getEmpHomePhone(), profile.getEmpMobilePhone(),
				profile.getEmpEmail(), empProfile.getEmpId());
		if (updateProfile) {
			updateProfileAddress = profileDAO.updateProfileAddress(profile.getEmpAddress().getHomeAptno(), profile.getEmpAddress().getStreetName(),
					profile.getEmpAddress().getCity(), profile.getEmpAddress().getState(), profile.getEmpAddress().getZipcode(), empProfile.getFullName());
			if (updateProfileAddress) {
				mav.addObject("message", "Update Successfully");
				empProfile = profileDAO.getEmpProfileByEmail(empemail);
				emp = empDAO.getEmployeeByEmail(empemail);
			}
		}else {
			mav.addObject("message", "Profile not updated");
		}
		mav.addObject("employee", emp);
		mav.addObject("empprofile", empProfile);
		return mav;
	}
	

	@ModelAttribute("profile")
	public Profile setupUserModel(BigDecimal empId, String fullName, String dob, String empHomePhone, String empMobilePhone, String empEmail,
	Address empAddress) {
		return new Profile(empId, fullName, dob, empHomePhone, empMobilePhone, empEmail, empAddress);
	}
	
}
