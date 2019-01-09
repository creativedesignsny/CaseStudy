/**
 * 
 */
package com.CasestudyDAOTest;

import static org.junit.Assert.*;

import java.math.BigDecimal;
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

import com.Casestudy.DAO.TaskDAO;
import com.Casestudy.DAOI.TaskDAOI.SQL;
import com.Casestudy.Models.Task;

/**
 * @author amahome
 *
 */
public class TaskDAOTest {
	
	static TaskDAO taskDAO;
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
		taskDAO = new TaskDAO();
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
	 * Test method for {@link com.Casestudy.DAO.TaskDAO#getAllTasks()}.
	 */
	@Test
	public final void testGetAllTasks() {
		//fail("Not yet implemented");
		List<Task> ex_taskList = new ArrayList<Task>();
		List<Task> act_taskList = new ArrayList<Task>();
		try {
			ps = conn.prepareStatement(SQL.GET_ALL_TASKS.getQuery());
			rs = ps.executeQuery();
			while (rs.next()) {
				ex_taskList.add(new Task(rs.getBigDecimal(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10)));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		act_taskList.addAll(taskDAO.getAllTasks());
		assertEquals(ex_taskList, act_taskList);
	}
	
	@Test
	public final void testGetAllTasksFail() {
		//fail("Not yet implemented");
		List<Task> ex_taskList = new ArrayList<Task>();
		List<Task> act_taskList = new ArrayList<Task>();
			ex_taskList.add(new Task(new BigDecimal(50), "Order Recheck", "Pete Dubaldi", "Pete Dubaldi", "10/01/2019", "15/01/2019", "14/01/2019", "dhjhskf", "dhwfihfhsdj", "dhjh"));
		act_taskList.addAll(taskDAO.getAllTasks());
		assertEquals(ex_taskList, act_taskList);
	}

	/**
	 * Test method for {@link com.Casestudy.DAO.TaskDAO#getTaskByEmployee(int)}.
	 */
	@Test
	public final void testGetTaskByEmployee() {
		//fail("Not yet implemented");
		List<Task> ex_taskListByEmp = new ArrayList<Task>();
		List<Task> act_taskListByEmp = new ArrayList<Task>();
		try {
			ps = conn.prepareStatement(SQL.GET_TASK_BY_EMPLOYEE.getQuery());
			ps.setInt(1, 5);
			rs = ps.executeQuery();
			while (rs.next()) {
				ex_taskListByEmp.add(new Task(rs.getBigDecimal(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10)));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		act_taskListByEmp.addAll(taskDAO.getTaskByEmployee(5));
		assertEquals(ex_taskListByEmp, act_taskListByEmp);
	}
	
	
	@Test
	public final void testGetTaskByEmployeeFail() {
		//fail("Not yet implemented");
		List<Task> ex_taskListByEmp = new ArrayList<Task>();
		List<Task> act_taskListByEmp = new ArrayList<Task>();
		ex_taskListByEmp.add(new Task(new BigDecimal(50), "Order Recheck", "Pete Dubaldi", "Pete Dubaldi", "10/01/2019", "15/01/2019", "14/01/2019", "dhjhskf", "dhwfihfhsdj", "dhjh"));
		act_taskListByEmp.addAll(taskDAO.getTaskByEmployee(4));
		assertEquals(ex_taskListByEmp, act_taskListByEmp);
	}

	/**
	 * Test method for {@link com.Casestudy.DAO.TaskDAO#getTaskByName(java.lang.String)}.
	 */
	@Test
	public final void testGetTaskByName() {
		//fail("Not yet implemented");
		Task act_task = new Task();
		Task ex_task = null;
		try {
			ps = conn.prepareStatement(SQL.GET_TASK_BY_NAME.getQuery());
			ps.setString(1, "Order Preparation");
			rs = ps.executeQuery();
			if (rs.next()) {
				ex_task = new Task(rs.getBigDecimal(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		} 
		act_task = taskDAO.getTaskByName("Order Preparation");
		assertEquals(ex_task, act_task);
	}
	
	
	@Test
	public final void testGetTaskByNameFinal() {
		//fail("Not yet implemented");
		Task act_task = new Task();
		Task ex_task = null;
		try {
			ps = conn.prepareStatement(SQL.GET_TASK_BY_NAME.getQuery());
			ps.setString(1, "Order Preparation");
			rs = ps.executeQuery();
			if (rs.next()) {
				ex_task = new Task(new BigDecimal(50), "Order Recheck", "Pete Dubaldi", "Pete Dubaldi", "10/01/2019", "15/01/2019", "14/01/2019", "dhjhskf", "dhwfihfhsdj", "dhjh");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		} 
		act_task = taskDAO.getTaskByName("Order Preparation");
		assertEquals(ex_task, act_task);
	}

}
