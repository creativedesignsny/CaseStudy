/**
 * 
 */
package com.Casestudy.DAOI;

import java.math.BigDecimal;

import com.Casestudy.Models.Address;
import com.Casestudy.Models.Profile;

/**
 * @author amahome
 *
 */
public interface ProfileDAOI {
	
	enum SQL {
		
		/** Gets the details of the employee for the given email **/
		GET_EMP_PROFILE_BY_EMAIL("SELECT EMPID, fullName, TO_CHAR(dob,'MM/DD/YYYY'),\r\n" +
				"				TO_CHAR(EMPHOMEPHONE, '000g000g0000','nls_numeric_characters=.-'), TO_CHAR(EMPMOBILE, '000g000g0000','nls_numeric_characters=.-'),\r\n" +
				"				address.homeAptno, address.streetName, address.city,\r\n" + 
				"				address.state, address.ZIPCODE, empEmail, EMPIMG FROM EMPLOYEE\r\n" +
				"				JOIN address ON employee.EMPADDRESSID = address.ADDRESSID\r\n" +
				"				WHERE empEmail = ?"),
		
		/**updates the profile details **/
		UPDATE_PROFILE("UPDATE EMPLOYEE SET fullName = ?, dob = TO_DATE(?, 'MM/DD/YYYY'), EMPHOMEPHONE = TO_NUMBER(?, '000g000g0000', 'nls_numeric_characters=.-'),\r\n" +
				"				EMPMOBILE= TO_NUMBER(?, '000g000g0000', 'nls_numeric_characters=.-'), EMPEMAIL = ? WHERE EMPID = ?"),
		
		/**updates the project address **/
		UPDATE_PROFILE_ADDRESS("UPDATE ADDRESS SET homeAptno = ?, streetName = ?, city = ?, state = ?, zipcode = ? WHERE\r\n"+
				" 				ADDRESSID = (SELECT EMPADDRESSID FROM EMPLOYEE WHERE FULLNAME = ?)");
		private final String query;
		private SQL(String s) {
			this.query = s;
		}
		public String getQuery() {
			return query;
		}
	}
	
	
	/** method to get the employee detail
	 * @param email
	 * 
	 * return type - Profile
	 * **/
	public Profile getEmpProfileByEmail(String email);
	
	public boolean updateProfile(String fullName, String dob, String empHomePhone, String empMobilePhone, String empEmail, BigDecimal empId);
	
	public boolean updateProfileAddress(String homeAptno, String streetName, String city, String state, int zipcode, String fullName);

}
