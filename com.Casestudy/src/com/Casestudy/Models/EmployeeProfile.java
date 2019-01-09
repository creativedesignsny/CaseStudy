/**
 * 
 */
package com.Casestudy.Models;

import java.sql.Blob;
import java.util.Date;

/**
 * @author amahome
 *
 */
public class EmployeeProfile {
	private int empId;
	private String firstName;
	private String lastName;
	private Date dob;
	private Long empHomePhone;
	private Long empMobile;
	private Address EmpAddress;
	private String empEmail;
	private String empPassword;
	private Blob empImg;

}
