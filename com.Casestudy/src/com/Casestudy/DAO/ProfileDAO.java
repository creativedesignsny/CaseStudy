/**
 * 
 */
package com.Casestudy.DAO;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.SQLException;

import com.Casestudy.DAOI.ProfileDAOI;
import com.Casestudy.DAOI.ProjectDAOI.SQL;
import com.Casestudy.Models.Address;
import com.Casestudy.Models.Profile;

/**
 * @author amahome
 *
 */
public class ProfileDAO extends OracleConnection implements ProfileDAOI{
	
	/**
	 * @author Manju Ajithkumar
	 * this method gets the profile details of an employee from the employee table for the given email
	 * @param String email
	 *return type - Profile (object)
	 */
	
	public Profile getEmpProfileByEmail(String email) {
		Profile profile = new Profile();
		Address address = new Address();
		try {
			connection = getConnection();
			ps = connection.prepareStatement(SQL.GET_EMP_PROFILE_BY_EMAIL.getQuery());
			ps.setString(1, email);
			rs = ps.executeQuery();
			if (rs.next()) {
				profile.setEmpId(rs.getBigDecimal(1));
				profile.setFullName(rs.getString(2));
				profile.setDob(rs.getString(3));
				profile.setEmpHomePhone(rs.getString(4));
				profile.setEmpMobilePhone(rs.getString(5));
				profile.setEmpAddress(address);
				profile.setEmpEmail(rs.getString(11));
				address.setHomeAptno(rs.getString(6));
				address.setStreetName(rs.getString(7));
				address.setCity(rs.getString(8));
				address.setState(rs.getString(9));
				address.setZipcode(rs.getInt(10));
	            return profile;
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
	 * this method updates the profile details of an employee from the employee table for the given email
	 * @param String fullName, String dob, String empHomePhone, String empMobilePhone, String empEmail, BigDecimal empId
	 *return type - boolean
	 */
	
	public boolean updateProfile(String fullName, String dob, String empHomePhone, String empMobilePhone, String empEmail, BigDecimal empId) {
		boolean success=false;
		try {
			connection = getConnection();
			ps = connection.prepareStatement(SQL.UPDATE_PROFILE.getQuery());
			ps.setString(1, fullName);
			ps.setString(2, dob);
			ps.setString(3, empHomePhone);
			ps.setString(4, empMobilePhone);
			ps.setString(5, empEmail);
			ps.setBigDecimal(6, empId);
			rs = ps.executeQuery();
			if (rs.next()) {
				success = true;
				return success;
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
		return success;
	}
	
	
	/**
	 * @author Manju Ajithkumar
	 * this method updates the address details of an employee for the given employee name
	 * @param String homeAptno, String streetName, String city, String state, int zipcode, String fullName
	 *return type - boolean
	 */
	public boolean updateProfileAddress(String homeAptno, String streetName, String city, String state, int zipcode, String fullName) {
		boolean success=false;
		try {
			connection = getConnection();
			ps = connection.prepareStatement(SQL.UPDATE_PROFILE_ADDRESS.getQuery());
			ps.setString(1, homeAptno);
			ps.setString(2, streetName);
			ps.setString(3, city);
			ps.setString(4, state);
			ps.setInt(5, zipcode);
			ps.setString(6, fullName);
			rs = ps.executeQuery();
			if (rs.next()) {
				success = true;
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
		return success;
	}



}
