package com.CasestudyDAOTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ClientDAOTest.class, EmployeeDAOTest.class, ProjectDAOTest.class, TaskDAOTest.class,
		VendorDAOTest.class })
public class AllTests {
	
	public static void main(String[] args) {
		
	}

}
