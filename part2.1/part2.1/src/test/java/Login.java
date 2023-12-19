import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login extends CommonFunctions {
    public Login(WebDriver driver) {
        super(driver);
    }
    public void login (String phone, String password ) {
        // Enter phone and password using XPath
        enterText(By.xpath("//input[@type = 'tel']"),phone);
        enterText(By.xpath("//input[@type = 'password']"),password);

        // Click the dang nhap button using XPath
        clickElement(By.xpath("//button[contains(text(),'Đăng nhập')]"));
    }
}
