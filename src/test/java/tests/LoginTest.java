package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class LoginTest extends BaseTest {
	@Test
	public void loginWithSecureCredentials() {
		String username=System.getenv("PW_USERNAME");
		String password=System.getenv("PW_PASSWORD");
		LoginPage loginPage=new LoginPage(page);
		loginPage.login(username, password);
	}

}
