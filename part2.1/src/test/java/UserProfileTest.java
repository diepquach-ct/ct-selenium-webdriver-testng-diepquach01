import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UserProfileTest extends BaseTest {
//    @Test
//    public void TC_01_verifySuccessfulProfileUpdate() {
//        CommonFunctions commonFunctions = new CommonFunctions(driver);
//        Login login = new Login(driver);
//        OTPScreen otpScreen = new OTPScreen(driver);
//
//        // Open the Chotot login page
//        commonFunctions.openApplication("https://id.chotot.org/");
//
//        // Maximize the window
//        commonFunctions.maximizeWindow();
//
//        // Perform login
//        login.login("0348971747", "Chotot@123");
//
//        // Check if OTP popup is displayed
//        if (isOTPPopupDisplayed()) {
//            // Open OTP input page
//            otpScreen.clickOTPPopup();
//            commonFunctions.openApplication("https://id.chotot.org/login/otp?phone=0348971747&continue=https%3A%2F%2Fwww.chotot.org%2F");
//
//            // Input OTP
//            otpScreen.enterOTP("123456");
//
//            // Click "Tiếp tục" button
//            otpScreen.clickContinueOTPScreen();
//        }
//
//        //khai báo Object User Profile
//        UpdateProfileFunctions updateProfile = new UpdateProfileFunctions(driver);
//        // Open the Chotot login page
//        commonFunctions.openApplication("https://chotot.org/");
//
//        // Navigate to UserProfile
//        updateProfile.navigateToUserProfile();
//
//        //Perform updateUserProfile
//        updateProfile.updateUserProfile("QA GV Test","06 Tân Trào","hello guys","001002003004","HCM");
//
//
//        // Close the application
//        //commonFunctions.closeApplication();
//    }

    private boolean isOTPPopupDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            // Check if the OTP popup has been displayed
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Xác thực')]")));
            return true;
        } catch (Exception e) {
            // OTP popup has not been displayed
            return false;
        }
    }

//    @Test
//    public void TC_02_verifyBlankFullNameField() {
//        CommonFunctions commonFunctions = new CommonFunctions(driver);
//        Login login = new Login(driver);
//        OTPScreen otpScreen = new OTPScreen(driver);
//
//        // 1. Open the Chotot login page
//        commonFunctions.openApplication("https://id.chotot.org/");
//
//        // 2. Maximize the window
//        commonFunctions.maximizeWindow();
//
//        // 3. Perform login
//        login.login("0348971747", "Chotot@123");
//
//        // 4. Check if OTP popup is displayed
//        if (isOTPPopupDisplayed()) {
//            // Open OTP input page
//            otpScreen.clickOTPPopup();
//            commonFunctions.openApplication("https://id.chotot.org/login/otp?phone=0348971747&continue=https%3A%2F%2Fwww.chotot.org%2F");
//
//            // Input OTP
//            otpScreen.enterOTP("123456");
//
//            // Click "Tiếp tục" button
//            otpScreen.clickContinueOTPScreen();
//        }
//
//        // Declare Object User Profile
//        UpdateProfileFunctions updateProfile = new UpdateProfileFunctions(driver);
//        // 5. Open the Chotot login page
//        commonFunctions.openApplication("https://chotot.org/");
//
//        // 6. Navigate to UserProfile
//        updateProfile.navigateToUserProfile();
//        //7. Click full_name field
//        commonFunctions.clickElement(By.xpath("//*[@name='full_name']"));
//        //8. Clear full_name field
//        commonFunctions.clearInputField(By.xpath("//*[@name='full_name']"));
//        //9. Click Save button
//        commonFunctions.clickElement(By.xpath("//button[contains(text(), 'Lưu thay đổi')]"));
//        // 7. Verify full name field validation
//        updateProfile.verifyErrorMessage_BlankFullName("Vui lòng nhập tên.");
//    }

    @Test
    public void TC_03_verifyNumberFullNameField() {
        CommonFunctions commonFunctions = new CommonFunctions(driver);
        Login login = new Login(driver);
        OTPScreen otpScreen = new OTPScreen(driver);

        // 1. Open the Chotot login page
        commonFunctions.openApplication("https://id.chotot.org/");

        // 2. Maximize the window
        commonFunctions.maximizeWindow();

        // 3. Perform login
        login.login("0348971747", "Chotot@123");

        // 4. Check if OTP popup is displayed
        if (isOTPPopupDisplayed()) {
            // Open OTP input page
            otpScreen.clickOTPPopup();
            commonFunctions.openApplication("https://id.chotot.org/login/otp?phone=0348971747&continue=https%3A%2F%2Fwww.chotot.org%2F");

            // Input OTP
            otpScreen.enterOTP("123456");

            // Click "Tiếp tục" button
            otpScreen.clickContinueOTPScreen();
        }

        // Declare Object User Profile
        UpdateProfileFunctions updateProfile = new UpdateProfileFunctions(driver);
        // 5. Open the Chotot login page
        commonFunctions.openApplication("https://chotot.org/");

        // 6. Navigate to UserProfile
        updateProfile.navigateToUserProfile();
        //7. Click full_name field
        commonFunctions.clickElement(By.xpath("//*[@name='full_name']"));
        //8. clear full_name field
        commonFunctions.clearInputField(By.xpath("//*[@name='full_name']"));
        //8. Input the number into full_name field
        commonFunctions.enterText(By.xpath("//*[@name='full_name']"), "123456");

        //9. Click Save button
        commonFunctions.clickElement(By.xpath("//button[contains(text(), 'Lưu thay đổi')]"));
        // 7. Verify full name field validation
        updateProfile.verifyErrorMessage_FullName("Tên không được chứa toàn số");
    }

}




