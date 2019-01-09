/**
 * 
 */
package com.Casestudy.DAOI;

import java.util.List;

import com.Casestudy.Models.Address;
import com.Casestudy.Models.Client;

/**
 * @author amahome
 *
 */
public interface ClientDAOI {
	
	enum SQL {
		
		/** Get all the clients from client table with address from address table**/
		GET_ALL_CLIENTS("SELECT client.clientFullName, client.clientHomePhone, client.clientMobile, client.clientEmail, address.homeAptno, address.streetName,\r\n"
				+ "address.city, address.state, address.zipcode FROM CLIENT JOIN ADDRESS on client.CLIENTADDRESSID = address.ADDRESSID"),
		//Not required
		GET_ADDRESS_RELATION_ID("SELECT RELATIONID FROM ADDRESSRELATION WHERE RELATIONLINK = ?"),
		
		/** Checks if a client already exists in the database**/
		CHECK_CLIENT_EXISTS("SELECT * FROM client WHERE CLIENTFULLNAME = ?"),
		
		/**Adds a new client to the database **/
		ADD_CLIENT("INSERT INTO CLIENT (CLIENTFULLNAME, CLIENTHOMEPHONE, CLIENTMOBILE, CLIENTEMAIL) VALUES (?, ?, ?, ?)"),
		
		/** Get the last added client id**/
		GET_MAX_CLIENT_ID("SELECT max(CLIENTID) FROM CLIENT"),
		
		/** Adds the client address to the database**/
		ADD_CLIENT_ADDRESS("INSERT INTO ADDRESS (homeAptno, streetName, city, state, zipcode, relatedTo, relationId)\r\n"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)"),
		
		/**Update client info **/
		UPDATE_CLIENT("UPDATE CLIENT SET CLIENTADDRESSID = (SELECT max(ADDRESSID) FROM ADDRESS) WHERE CLIENTID = ?"),
		
		CHECK_ADDRESS("SELECT * FROM ADDRESS WHERE homeAptno = ? AND streetName = ?"),
		
		//Not required
		GET_CLIENT_BY_ADDRESS("SELECT CLIENTFULLNAME, CLIENTHOMEPHONE, CLIENTMOBILE, CLIENTEMAIL FROM client WHERE CLIENTADDRESSID = ?");
		private final String query;
		private SQL(String s) {
			this.query = s;
		}
		public String getQuery() {
			return query;
		}
	}
	
	
	/** Method to list all clients
	 * returns the list of clients**/
	public List<Client> getAllClients();
	
	/** Adds clients to database
	 * returns a boolean value**/
	public boolean addClient(String clientFullName, Long clientHomePhone, Long clientMobile, String clientEmail);
	
	
	/** Adds the address of the client to address table
	 * returns a boolean value**/
	public boolean addClientAddress(String client, String homeAptno, String streetName, String city, String state, int zipcode);

//	public Client getClientByAddress(String client);
}
