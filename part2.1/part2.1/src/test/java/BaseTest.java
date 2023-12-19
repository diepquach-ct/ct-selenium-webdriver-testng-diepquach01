import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver; // protected: có thể được truy cập từ các lớp con.
    String projectPath = System.getProperty("user.dir"); //user/drivers


    @BeforeMethod
    public void setUp () {
        // Setup đường dẫn đến WebDriver của Firefox (geckodriver)
        System.setProperty("webdriver.gecko.driver", projectPath + "/drivers/geckodriver") ;
        // Khởi tạo trình duyệt Firefox
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

//    @AfterMethod
//    public void tearDown() { //1. Resource Cleanup, 2. Logging and Reporting
//        if (driver != null) { //driver !=null để không bị lỗi NullPointerException
//            driver.quit();
//        }
//    }
}
