package objectRepo;

import org.openqa.selenium.By;

public interface LoginObject {

	By txtLogin = By.id("user-name");
	By txtPassword_id = By.id("password");
	By invaliMsg_id = By.className("error-button");
	By loginButton_id = By.id("login-button");
	
}
