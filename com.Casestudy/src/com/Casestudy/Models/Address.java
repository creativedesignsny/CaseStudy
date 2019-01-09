/**
 * 
 */
package com.Casestudy.Models;

/**
 * @author amahome
 * Model class for the address
 */
public class Address {

	private String homeAptno;
	private String streetName;
	private String city;
	private String state;
	private int zipcode;

	/**
	 * @param addressId
	 * @param homeAptno
	 * @param streetName
	 * @param city
	 * @param state
	 * @param zipcode
	 * @param relatedTo
	 * @param relationId
	 */
	public Address(String homeAptno, String streetName, String city, String state, int zipcode) {
		super();
		//this.addressId = addressId;
		this.homeAptno = homeAptno;
		this.streetName = streetName;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}
	
	public Address() {
		
	}

//	/**
//	 * @return the addressId
//	 */
//	public int getAddressId() {
//		return addressId;
//	}
//
//	/**
//	 * @param addressId the addressId to set
//	 */
//	public void setAddressId(int addressId) {
//		this.addressId = addressId;
//	}

	/**
	 * @return the homeAptno
	 */
	public String getHomeAptno() {
		return homeAptno;
	}

	/**
	 * @param homeAptno the homeAptno to set
	 */
	public void setHomeAptno(String homeAptno) {
		this.homeAptno = homeAptno;
	}

	/**
	 * @return the streetName
	 */
	public String getStreetName() {
		return streetName;
	}

	/**
	 * @param streetName the streetName to set
	 */
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the zipcode
	 */
	public int getZipcode() {
		return zipcode;
	}

	/**
	 * @param zipcode the zipcode to set
	 */
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	/**
	 * @return the relatedTo
	 */

	
}
