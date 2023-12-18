import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OTPScreen extends CommonFunctions {
    public OTPScreen(WebDriver driver) {
        super(driver); //gọi constructor của lớp cha để đảm bảo rằng các thuộc tính và phương thức của lớp cha được khởi tạo đúng cách
    }

    public void clickOTPPopup() {
        // Click Xác thực button using XPath
        clickElement(By.xpath("//button[contains(text(),'Xác thực')]"));
    }

    public void enterOTP(String otpValue) {
        // Wait for the OTP popup to display
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='tel'][1]")));

        // Split the OTP value ra từng chữ số
        char[] otpDigits = otpValue.toCharArray();

        // Enter OTP on each field
        for (int i = 0; i < otpDigits.length; i++) {
            String locator = String.format("//input[@type='tel'][%d]", i + 1);

            // Wait for the OTP input field
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));

            enterText(By.xpath(locator), String.valueOf(otpDigits[i]));

            // Thêm 500 milliseconds deplay giữa mỗi lần nhập số
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void clickContinueOTPScreen() {
        clickElement(By.xpath("//button[contains(text(),'TIẾP TỤC')]"));
    }
}
