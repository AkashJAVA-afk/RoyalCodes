package com.nt.tset;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.nt.dao.ILoginDAO;
import com.nt.service.ILoginmangmntService;
import com.nt.service.IloginmangmntServiceImpl;



public class LoginmangmntServiceTest {

	private static ILoginmangmntService loginService;
	private static ILoginDAO loginDAOMock;
	
	@BeforeAll
	public static void setupOnce() {
		//create mock object
		/*mock generating inmemory class implementing ILoginDAO(I)
		 * having null method definations for Authentication (-,-) method.
		*/
		loginDAOMock=Mockito.mock(ILoginDAO.class);
		
		//create service class object.
		loginService=new IloginmangmntServiceImpl(loginDAOMock);
	}
	
	@AfterAll
	public void clearOnce() {
		loginDAOMock=null;
		loginService=null;
	}
	
	@Test
	public static void testLoginWithValidCredintial() {
		//provide stub or temporary functianlity for dao
		Mockito.when(loginDAOMock.Authenticate("RAJA","RANI")).thenReturn(1);
		//unit test
		assertTrue(loginService.login("RAJA", "RANI"));	
	}
	
	@Test
	public static void testLoginWithInValidCredintial() {
		//provide stub or temporary functianlity for dao
		Mockito.when(loginDAOMock.Authenticate("RAJA","RANI")).thenReturn(0);
		//unit test
		assertFalse(loginService.login("RAJA", "RANI"));
         }
	
	@Test
	public static void testLoginWithNoValidCredintial() {
	//testing
		assertThrows(IllegalArgumentException.class, ()->{loginService.login("", "");});
        }
} 