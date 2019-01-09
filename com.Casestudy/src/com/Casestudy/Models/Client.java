/**
 * 
 */
package com.Casestudy.Models;

/**
 * @author amahome
 *Model class for client
 */
public class Client {
	
	private String clientFullName;
	private Long clientHomePhone;
	private Long clientMobile;
	private String clientEmail;
	private Address clientAddress;
	/**
	 * @param clientId
	 * @param clientFullName
	 * @param clientHomePhone
	 * @param clientMobile
	 * @param clientEmail
	 * @param clientAddress
	 * Constructor with all fields
	 */
	public Client(String clientFullName, Long clientHomePhone, Long clientMobile, String clientEmail,
			Address clientAddress) {
		//super();
		//this.clientId = clientId;
		this.clientFullName = clientFullName;
		this.clientHomePhone = clientHomePhone;
		this.clientMobile = clientMobile;
		this.clientEmail = clientEmail;
		this.clientAddress = clientAddress;
	}
	
	
	/* Empty Constructor*/
	public Client() {
		
	}
	
	

//	/**
//	 * @return the clientId
//	 */
//	public int getClientId() {
//		return clientId;
//	}
//
//	/**
//	 * @param clientId the clientId to set
//	 */
//	public void setClientId(int clientId) {
//		this.clientId = clientId;
//	}

	/**
	 * @return the clientFullName
	 */
	public String getClientFullName() {
		return clientFullName;
	}

	/**
	 * @param clientFullName the clientFullName to set
	 */
	public void setClientFullName(String clientFullName) {
		this.clientFullName = clientFullName;
	}

	/**
	 * @return the clientHomePhone
	 */
	public Long getClientHomePhone() {
		return clientHomePhone;
	}

	/**
	 * @param clientHomePhone the clientHomePhone to set
	 */
	public void setClientHomePhone(Long clientHomePhone) {
		this.clientHomePhone = clientHomePhone;
	}

	/**
	 * @return the clientMobile
	 */
	public Long getClientMobile() {
		return clientMobile;
	}

	/**
	 * @param clientMobile the clientMobile to set
	 */
	public void setClientMobile(Long clientMobile) {
		this.clientMobile = clientMobile;
	}

	/**
	 * @return the clientEmail
	 */
	public String getClientEmail() {
		return clientEmail;
	}

	/**
	 * @param clientEmail the clientEmail to set
	 */
	public void setClientEmail(String clientEmail) {
		this.clientEmail = clientEmail;
	}

	/**
	 * @return the clientAddress
	 */
	public Address getClientAddress() {
		return clientAddress;
	}

	/**
	 * @param clientAddress the clientAddress to set
	 */
	public void setClientAddress(Address clientAddress) {
		this.clientAddress = clientAddress;
	}
	
	public boolean equals(Object a) {
		Client c = (Client)a;
		return this.getClientFullName().equals(c.getClientFullName()) && this.getClientHomePhone().equals(c.getClientHomePhone()) &&
				this.getClientMobile().equals(c.getClientMobile()) && this.getClientEmail().equals(c.getClientEmail()) &&
				this.getClientAddress().getHomeAptno().equals(c.getClientAddress().getHomeAptno()) &&
				this.getClientAddress().getStreetName().equals(c.getClientAddress().getStreetName()) &&
				this.getClientAddress().getCity().equals(c.getClientAddress().getCity()) && this.getClientAddress().getState().equals(c.getClientAddress().getState()) &&
						this.getClientAddress().getZipcode()==c.getClientAddress().getZipcode();
		
	}
	

}
