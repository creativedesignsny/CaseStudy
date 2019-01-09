/**
 * 
 */
package com.Casestudy.DAOI;

import java.util.List;

import com.Casestudy.Models.Client;
import com.Casestudy.Models.Vendor;

/**
 * @author amahome
 *
 */
public interface VendorDAOI {
	enum SQL {
		GET_ALL_VENDORS("SELECT vendor.vendorFullName, vendor.vendorHomePhone, vendor.vendorMobile, vendor.vendorEmail, address.homeAptno, address.streetName,\r\n"
				+ "address.city, address.state, address.zipcode FROM VENDOR JOIN ADDRESS on vendor.VENDORADDRESSID = ADDRESS.ADDRESSID"),
		GET_ADDRESS_RELATION_ID("SELECT RELATIONID FROM ADDRESSRELATION WHERE RELATIONLINK = ?"),
		CHECK_VENDOR_EXISTS("SELECT * FROM VENDOR WHERE vendorFullName = ?"),
		ADD_VENDOR("INSERT INTO VENDOR (vendorFullName, vendorHomePhone, vendorMobile, vendorEmail) VALUES (?, ?, ?, ?)"),
		GET_MAX_VENDOR_ID("SELECT max(VENDORID) FROM VENDOR"),
		ADD_VENDOR_ADDRESS("INSERT INTO ADDRESS (homeAptno, streetName, city, state, zipcode, relatedTo, relationId)\r\n"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)"),
		UPDATE_VENDOR("UPDATE VENDOR SET VENDORADDRESSID = (SELECT max (ADDRESSID) FROM ADDRESS) WHERE VENDORID = ?"),
		CHECK_ADDRESS("SELECT * FROM ADDRESS WHERE homeAptno = ? AND streetName = ?"),
		GET_VENDOR_BY_ADDRESS("SELECT vendorFullName, vendorHomePhone, vendorMobile, vendorEmail FROM VENDOR WHERE VENDORADDRESSID = ?");
		private final String query;
		private SQL(String s) {
			this.query = s;
		}
		public String getQuery() {
			return query;
		}
	}
	
	
	public List<Vendor> getAllVendors();
	
	public boolean addVendor(String vendorFullName, Long vendorHomePhone, Long vendorMobile, String vendorEmail);
	
	public boolean addVendorAddress(String vendor, String homeAptno, String streetName, String city, String state, int zipcode);

}
