/**
 * 
 */
package com.CasestudyDAOTest;

import static org.junit.Assert.*;

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

import com.Casestudy.DAO.VendorDAO;
import com.Casestudy.Models.Address;
import com.Casestudy.Models.Client;
import com.Casestudy.Models.Vendor;
import com.Casestudy.DAOI.VendorDAOI.SQL;

/**
 * @author amahome
 *
 */
public class VendorDAOTest {
	
	static VendorDAO vendorDAO;
	
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
		vendorDAO = new VendorDAO();
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
	 * Test method for {@link com.Casestudy.DAO.VendorDAO#getAllVendors()}.
	 */
	@Test
	public final void testGetAllVendors() {
		//fail("Not yet implemented");
		List<Vendor> ex_vendorList = new ArrayList<Vendor>();
		List<Vendor> act_vendorList = new ArrayList<Vendor>();
		try {
			ps = conn.prepareStatement(SQL.GET_ALL_VENDORS.getQuery());
			rs = ps.executeQuery();
			while (rs.next()) {
				Vendor v = new Vendor();
				Address address = new Address();
				v.setVendorFullName(rs.getString(1));
				v.setVendorHomePhone(rs.getLong(2));
				v.setVendorMobile(rs.getLong(3));
				v.setVendorEmail(rs.getString(4));
				address.setHomeAptno(rs.getString(5));
				address.setStreetName(rs.getString(6));
				address.setCity(rs.getString(7));
				address.setState(rs.getString(8));
				address.setZipcode(rs.getInt(9));
				v.setVendorAddress(address);
				ex_vendorList.add(v);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		act_vendorList.addAll(vendorDAO.getAllVendors());
		assertEquals(ex_vendorList, act_vendorList);
	}
	
	
	@Test
	public final void testGetAllVendorsFail() {
		//fail("Not yet implemented");
		List<Vendor> ex_vendorList = new ArrayList<Vendor>();
		List<Vendor> act_vendorList = new ArrayList<Vendor>();
		try {
			ps = conn.prepareStatement(SQL.GET_ALL_VENDORS.getQuery());
			rs = ps.executeQuery();
			while (rs.next()) {
				Vendor v = new Vendor();
				Address address = new Address();
				v.setVendorFullName("Graciela Ruta");
				v.setVendorHomePhone(4407808425L);
				v.setVendorMobile(4405797763L);
				v.setVendorEmail("gruta@cox.net");
				address.setHomeAptno("98");
				address.setStreetName("Connecticut Ave Nw");
				address.setCity("Geauga");
				address.setState("Ohio");
				address.setZipcode(44023);
				v.setVendorAddress(address);
				ex_vendorList.add(v);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		act_vendorList.addAll(vendorDAO.getAllVendors());
		assertEquals(ex_vendorList, act_vendorList);
	}

	/**
	 * Test method for {@link com.Casestudy.DAO.VendorDAO#addVendor(java.lang.String, java.lang.Long, java.lang.Long, java.lang.String)}.
	 */
	@Test
	public final void testAddVendor() {
		//fail("Not yet implemented");
		boolean expected = false;
		boolean actual;
		try {
			ps = conn.prepareStatement(SQL.CHECK_VENDOR_EXISTS.getQuery());
			ps.setString(1, "Brandon Callaro");
			rs = ps.executeQuery();
			if (rs.next()) {
				System.out.println("Vendor already exists!");
				expected = false;
			}else {
				ps = conn.prepareStatement(SQL.ADD_VENDOR.getQuery());
				ps.setString(1, "Brandon Callaro");
				ps.setLong(2, 8082156832L);
				ps.setLong(3, 8082405168L);
				ps.setString(4, "brandon_callaro@hotmail.com");
				rs = ps.executeQuery();
				if (rs.next()) {
					expected = true;
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		actual = vendorDAO.addVendor("Howard Paulas", 3036234241L, 3036923118L, "hpaulas@gmail.com");
		assertEquals(expected, actual);
	}
	
	
	@Test
	public final void testAddVendorFail() {
		boolean expected = false;
		boolean actual;
		try {
			ps = conn.prepareStatement(SQL.CHECK_VENDOR_EXISTS.getQuery());
			ps.setString(1, "Lucina	Lary");
			rs = ps.executeQuery();
			if (rs.next()) {
				System.out.println("Vendor already exists!");
				expected = false;
			}else {
				ps = conn.prepareStatement(SQL.ADD_VENDOR.getQuery());
				ps.setString(1, "Lucina	Lary");
				ps.setLong(2, 3217494981L);
				ps.setLong(3, 3216324668L);
				ps.setString(4, "lucina_lary@cox.net");
				rs = ps.executeQuery();
				if (rs.next()) {
					expected = true;
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		actual = vendorDAO.addVendor("Howard Paulas", 3036234241L, 3036923118L, "hpaulas@gmail.com");
		assertEquals(expected, actual);
		
	}

	/**
	 * Test method for {@link com.Casestudy.DAO.VendorDAO#addVendorAddress(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int)}.
	 */
	@Test
	public final void testAddVendorAddress() {
		//fail("Not yet implemented");
		boolean expected = false;
		boolean actual;
		try {
			ps = conn.prepareStatement(SQL.ADD_VENDOR_ADDRESS.getQuery());
			ps.setString(1, "8597"); 
			ps.setString(2, "W National Ave");
			ps.setString(3, "Brevard");
			ps.setString(4, "Florida");
			ps.setInt(5, 32922);
			ps.setInt(6, 21);
			ps.setInt(7, 3);
			rs = ps.executeQuery();
			if (rs.next()) {
				ps = conn.prepareStatement(SQL.UPDATE_VENDOR.getQuery());
				ps.setInt(1, 21);
				rs = ps.executeQuery();
				if (rs.next()) {
					expected = true;
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		actual = vendorDAO.addVendorAddress("vendor", "6", "Gilson St", "Bronx", "New York", 10468);
		assertEquals(expected, actual);
	}
	
	
	@Test
	public final void testAddVendorAddressFail() {
		boolean expected = false;
		boolean actual;
		try {
			ps = conn.prepareStatement(SQL.ADD_VENDOR_ADDRESS.getQuery());
			ps.setString(1, "5");   
			ps.setString(2, "Boston Ave #88");
			ps.setString(3, "Sioux Falls");
			ps.setString(4, "South Dakota");
			ps.setInt(5, 57105);
			ps.setInt(6, 87);
			ps.setInt(7, 2);
			rs = ps.executeQuery();
			if (rs.next()) {
				ps = conn.prepareStatement(SQL.UPDATE_VENDOR.getQuery());
				ps.setInt(1, 42);
				rs = ps.executeQuery();
				if (rs.next()) {
					expected = true;
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		actual = vendorDAO.addVendorAddress("vendor", "79", "S Howell Ave", "Grand Rapids", "Michigan", 49546);
		assertEquals(expected, actual);
	}

}
