package pages;

import com.microsoft.playwright.Page;

public class LoginPage {
	
	private Page page;
	private String username="#userName";
	private String password="#password";
	private String loginbtn="#login";
	public LoginPage(Page page) {
		this.page=page;
		
	}
	public void login(String user,String pass) {
		page.fill(username, pass);
		page.fill(password, pass);
		page.click(loginbtn);
		
	}

}
