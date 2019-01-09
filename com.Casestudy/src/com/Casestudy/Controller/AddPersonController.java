/**
 * 
 */
package com.Casestudy.Controller;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.Casestudy.DAO.ClientDAO;
import com.Casestudy.DAO.EmployeeDAO;
import com.Casestudy.DAO.VendorDAO;

/**
 * @author amahome
 *
 */

@Controller
@RequestMapping("/")
public class AddPersonController {
	
	@RequestMapping(value = "/person", method=RequestMethod.GET)
	public ModelAndView addPerson() {
		ModelAndView mav = new ModelAndView("addPerson");
		return mav;
	}
	
	
	@RequestMapping(value = "/add-person", method=RequestMethod.POST)
	public ModelAndView submitPerson(@RequestParam("person") String person, @RequestParam("fullName") String fullName,
			@RequestParam("email") String email, @RequestParam("desgn") String desgn, @RequestParam("role") String role,
			@RequestParam("homephone") String homephone, @RequestParam("mobilephone") String mobilephone,
			@RequestParam("homeAptno") String homeAptno, @RequestParam("street") String street,
			@RequestParam("city") String city, @RequestParam("state") String state,
			@RequestParam("zipcode") String zipcode) {
//		if(errors.hasErrors()) {
//			ModelAndView mav = new ModelAndView("addPerson");
//			return mav;
//		}
		ModelAndView mav = new ModelAndView("addPerson");
		EmployeeDAO empDAO = new EmployeeDAO();
		ClientDAO clientDAO = new ClientDAO();
		VendorDAO vendorDAO = new VendorDAO();
		String phoneString1 = homephone.replaceAll("\\D", "");
		String phoneString2 = mobilephone.replaceAll("\\D", "");
		Long homePhone = Long.parseLong(phoneString1);
		Long mobilePhone = Long.parseLong(phoneString2);
		int zip = Integer.parseInt(zipcode);
		boolean personAdd;
		boolean addaddress;

		if (person == null || (person.isEmpty())){
			mav.addObject("successMessage", "Please choose person to add!");
		}else {
			if (person.equals("employee")) {
				int emprole = Integer.parseInt(role);
				System.out.println(emprole);
				fullName = fullName.replaceFirst("^,", "");
				email = email.replaceFirst("^,", "");
				personAdd = empDAO.addEmployee(fullName, email, emprole, desgn);
				if (personAdd) {
					mav.addObject("successMessage", "Successfully added Employee");
				}else {
					mav.addObject("successMessage", "Failed to add Employee");
				}
		
			}else if(person.equals("client")) {
				fullName = fullName.replaceFirst("^,", "");
				email = email.replaceFirst("^,", "");
				personAdd = clientDAO.addClient(fullName, homePhone, mobilePhone, email);
				if (personAdd) {
					addaddress = clientDAO.addClientAddress(person, homeAptno, street, city, state, zip);
					if(addaddress) {
						mav.addObject("successMessage", "Successfully added Client");
					}else {
						mav.addObject("successMessage", "Failed to add address");
					}
				}else {
					mav.addObject("successMessage", "Failed to add Client");
				}
			}else if(person.equals("vendor")) {
				fullName = fullName.replaceFirst("^,", "");
				email = email.replaceFirst("^,", "");
				personAdd = vendorDAO.addVendor(fullName, homePhone, mobilePhone, email);
				if (personAdd) {
					addaddress = vendorDAO.addVendorAddress(person, homeAptno, street, city, state, zip);
					if(addaddress) {
						mav.addObject("successMessage", "Successfully added Vendor");
					}else {
						mav.addObject("successMessage", "Failed to add address");
					}
				}else {
					mav.addObject("successMessage", "Failed to add Client");
				}
			}
		}
		
		return mav;
	}
	
}