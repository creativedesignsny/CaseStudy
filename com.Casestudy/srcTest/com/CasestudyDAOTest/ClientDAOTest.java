/**
 * 
 */
package com.CasestudyDAOTest;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.Casestudy.DAO.ClientDAO;
import com.Casestudy.Models.Address;
import com.Casestudy.Models.Client;
import com.Casestudy.DAOI.ClientDAOI.SQL;

/**
 * @author amahome
 *
 */
public class ClientDAOTest {
	
	static ClientDAO clientDAO;
	
	private final static String url = "jdbc:oracle:thin:@10.0.0.87:1521:student";
	private final static String user = "C##student";
	private final static String pass = "school";
	private final static Driver driver = new oracle.jdbc.driver.OracleDriver();
	
	protected static Connection conn = null;
	protected Statement stmt = null;
	protected PreparedStatement ps = null;
	protected ResultSet rs = null;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		DriverManager.registerDriver(driver);
		conn = DriverManager.getConnection(url, user, pass);
		clientDAO = new ClientDAO();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		conn.close();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.Casestudy.DAO.ClientDAO#getAllClients()}.
	 */
	@Test
	public final void testGetAllClients() {
		List<Client> ex_clientList = new ArrayList<Client>();
		List<Client> act_clientList = new ArrayList<Client>();
		Client c = new Client();
		try {
			ps = conn.prepareStatement(SQL.GET_ALL_CLIENTS.getQuery());
			rs = ps.executeQuery();
			while (rs.next()) {
				Client client = new Client();
				Address address = new Address();
				client.setClientFullName(rs.getString(1));
				client.setClientHomePhone(rs.getLong(2));
				client.setClientMobile(rs.getLong(3));
				client.setClientEmail(rs.getString(4));
				address.setHomeAptno(rs.getString(5));
				address.setStreetName(rs.getString(6));
				address.setCity(rs.getString(7));
				address.setState(rs.getString(8));
				address.setZipcode(rs.getInt(9));
				client.setClientAddress(address);
				ex_clientList.add(client);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		act_clientList.addAll(clientDAO.getAllClients());
		assertEquals(ex_clientList, act_clientList);
	}
	
	@Test
	public final void testGetAllClientsFail() {
		List<Client> ex_clientList = new ArrayList<Client>();
		List<Client> act_clientList = new ArrayList<Client>();
			Client client = new Client();
			Address address = new Address();
			client.setClientFullName("Graciela Ruta");
			client.setClientHomePhone(4407808425L);
			client.setClientMobile(4405797763L);
			client.setClientEmail("gruta@cox.net");
			address.setHomeAptno("98");
			address.setStreetName("Connecticut Ave Nw");
			address.setCity("Geauga");
			address.setState("Ohio");
			address.setZipcode(44023);
			client.setClientAddress(address);
			ex_clientList.add(client);

		act_clientList.addAll(clientDAO.getAllClients());
		assertEquals(ex_clientList, act_clientList);
	}


	/**
	 * Test method for {@link com.Casestudy.DAO.ClientDAO#addClient(java.lang.String, java.lang.Long, java.lang.Long, java.lang.String)}.
	 */
	@Test
	public final void testAddClient() {
		boolean expected = false;
		boolean actual;
		try {
			ps = conn.prepareStatement(SQL.CHECK_CLIENT_EXISTS.getQuery());
			ps.setString(1, "Glenna Slayton");
			rs = ps.executeQuery();
			if (rs.next()) {
				System.out.println("Client already exists!");
				expected = false;
			}else {
				ps = conn.prepareStatement(SQL.ADD_CLIENT.getQuery());
				ps.setString(1, "Glenna Slayton");
				ps.setLong(2, 9016409178L);
				ps.setLong(3, 9018694314L);
				ps.setString(4, "glenna_slayton@cox.net");
				rs = ps.executeQuery();
				if (rs.next()) {
					expected = true;
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		actual = clientDAO.addClient("Vilma Berlanga", 6167373085L, 6165684113L, "vberlanga@berlanga.com");
		assertEquals(expected, actual);
	}
	
	@Test
	public final void testAddClientFail() {
		boolean expected = false;
		boolean actual;
		try {
			ps = conn.prepareStatement(SQL.CHECK_CLIENT_EXISTS.getQuery());
			ps.setString(1, "Janine Rhoden");
			rs = ps.executeQuery();
			if (rs.next()) {
				System.out.println("Client already exists!");
				expected = false;
			}else {
				ps = conn.prepareStatement(SQL.ADD_CLIENT.getQuery());
				ps.setString(1, "Janine Rhoden");
				ps.setLong(2, 7182285894L);
				ps.setLong(3, 7187285051L);
				ps.setString(4, "jrhoden@yahoo.com");
				rs = ps.executeQuery();
				if (rs.next()) {
					expected = true;
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		actual = clientDAO.addClient("Vilma Berlanga", 6167373085L, 6165684113L, "vberlanga@berlanga.com");
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link com.Casestudy.DAO.ClientDAO#addClientAddress(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int)}.
	 */
	@Test
	public final void testAddClientAddress() {
		boolean expected = false;
		boolean actual;
		try {
			ps = conn.prepareStatement(SQL.ADD_CLIENT_ADDRESS.getQuery());
			ps.setString(1, "2759"); 
			ps.setString(2, "Livingston Ave");
			ps.setString(3, "Shelby");
			ps.setString(4, "Tennessee");
			ps.setInt(5, 38118);
			ps.setInt(6, 41);
			ps.setInt(7, 2);
			rs = ps.executeQuery();
			if (rs.next()) {
				ps = conn.prepareStatement(SQL.UPDATE_CLIENT.getQuery());
				ps.setInt(1, 41);
				rs = ps.executeQuery();
				if (rs.next()) {
					expected = true;
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		actual = clientDAO.addClientAddress("client", "79", "S Howell Ave", "Grand Rapids", "Michigan", 49546);
		assertEquals(expected, actual);
	}
	
	
	
	
	@Test
	public final void testAddClientAddressFail() {
		boolean expected = false;
		boolean actual;
		try {
			ps = conn.prepareStatement(SQL.ADD_CLIENT_ADDRESS.getQuery());
			ps.setString(1, "5");   
			ps.setString(2, "Boston Ave #88");
			ps.setString(3, "Sioux Falls");
			ps.setString(4, "South Dakota");
			ps.setInt(5, 57105);
			ps.setInt(6, 87);
			ps.setInt(7, 2);
			rs = ps.executeQuery();
			if (rs.next()) {
				ps = conn.prepareStatement(SQL.UPDATE_CLIENT.getQuery());
				ps.setInt(1, 42);
				rs = ps.executeQuery();
				if (rs.next()) {
					expected = true;
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		actual = clientDAO.addClientAddress("vendor", "79", "S Howell Ave", "Grand Rapids", "Michigan", 49546);
		assertEquals(expected, actual);
	}

}
