/**
 * 
 */
package com.Casestudy.DAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.Casestudy.DAOI.VendorDAOI;
import com.Casestudy.DAOI.ClientDAOI.SQL;
import com.Casestudy.Models.Address;
import com.Casestudy.Models.Vendor;

/**
 * @author amahome
 *
 */
public class VendorDAO extends OracleConnection implements VendorDAOI{
	
	/**
	 * @author Manju Ajithkumar
	 * This method gets the list of all the Vendors from the database
	 *return type - List<Task>
	 */
	
	public List<Vendor> getAllVendors(){
		List<Vendor> vendorList = new ArrayList<Vendor>();
		try {
			connection = getConnection();
			ps = connection.prepareStatement(SQL.GET_ALL_VENDORS.getQuery());
			rs = ps.executeQuery();
			while (rs.next()) {
				Vendor vendor = new Vendor();
				Address address = new Address();
				vendor.setVendorFullName(rs.getString(1));
				vendor.setVendorHomePhone(rs.getLong(2));
				vendor.setVendorMobile(rs.getLong(3));
				vendor.setVendorEmail(rs.getString(4));
				address.setHomeAptno(rs.getString(5));
				address.setStreetName(rs.getString(6));
				address.setCity(rs.getString(7));
				address.setState(rs.getString(8));
				address.setZipcode(rs.getInt(9));
				vendor.setVendorAddress(address);
				vendorList.add(vendor);
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
		return vendorList;
	}
	
	
	/**
	 * @author Manju Ajithkumar
	 * This method adds a Vendor to the database
	 * the method first checks if the vendor already exists in the database, if not then adds the Vendor
	 * @param String vendorFullName, Long vendorHomePhone, Long vendorMobile, String vendorEmail
	 *return type - boolean
	 */
	

	public boolean addVendor(String vendorFullName, Long vendorHomePhone, Long vendorMobile, String vendorEmail) {
		boolean success = false;
		try {
			connection = getConnection();
			ps = connection.prepareStatement(SQL.CHECK_VENDOR_EXISTS.getQuery());
			ps.setString(1, vendorFullName);
			rs = ps.executeQuery();
			if (rs.next()) {
				System.out.println("Vendor already exists!");
				success = false;
			}else {
				ps = connection.prepareStatement(SQL.ADD_VENDOR.getQuery());
				ps.setString(1, vendorFullName);
				ps.setLong(2, vendorHomePhone);
				ps.setLong(3, vendorMobile);
				ps.setString(4, vendorEmail);
				rs = ps.executeQuery();
				if (rs.next()) {
					success = true;
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
		return success;
	}
	
	/**
	 * @author Manju Ajithkumar
	 * This method adds the  address of the Vendor to the database
	 * the method first gets the address relation id, then the maxid from the vendor table and then adds the address
	 * @param String vendor, String homeAptno, String streetName, String city, String state, int zipcode
	 *return type - boolean
	 */
	
	public boolean addVendorAddress(String vendor, String homeAptno, String streetName, String city, String state, int zipcode) {
		boolean success = false;
		int maxId = 0;
		int relId = 0;
		try {
			connection = getConnection();
			ps = connection.prepareStatement(SQL.GET_ADDRESS_RELATION_ID.getQuery());
			ps.setString(1, vendor);
			rs = ps.executeQuery();
			if (rs.next()) {
				relId = rs.getInt(1);
			}
			ps = connection.prepareStatement(SQL.GET_MAX_VENDOR_ID.getQuery());
			rs = ps.executeQuery();
			if (rs.next()) {
				maxId = rs.getInt(1);
			}
			ps = connection.prepareStatement(SQL.CHECK_ADDRESS.getQuery());
			ps.setString(1, homeAptno);
			ps.setString(2, streetName);
			rs = ps.executeQuery();
			if (rs.next()) {
				success = false;
			}else {
				ps = connection.prepareStatement(SQL.ADD_VENDOR_ADDRESS.getQuery());
				ps.setString(1, homeAptno);
				ps.setString(2, streetName);
				ps.setString(3, city);
				ps.setString(4, state);
				ps.setInt(5, zipcode);
				ps.setInt(6, maxId);
				ps.setInt(7, relId);
				rs = ps.executeQuery();
				if (rs.next()) {
					ps = connection.prepareStatement(SQL.UPDATE_VENDOR.getQuery());
					ps.setInt(1, maxId);
					rs = ps.executeQuery();
					if (rs.next()) {
						success = true;
					}
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
		return success;
			
	}
	

}
