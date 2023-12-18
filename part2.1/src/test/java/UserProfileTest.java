import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UserProfileTest extends BaseTest {
//    @Test
//    public void verifySuccessfulProfileUpdate() {
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

    @Test
    public void verifyMandatoryFieldValidation () {
        CommonFunctions commonFunctions = new CommonFunctions(driver);
        Login login = new Login(driver);
        OTPScreen otpScreen = new OTPScreen(driver);

        // Open the Chotot login page
        commonFunctions.openApplication("https://id.chotot.org/");

        // Maximize the window
        commonFunctions.maximizeWindow();

        // Perform login
        login.login("0348971747", "Chotot@123");

        // Check if OTP popup is displayed
        if (isOTPPopupDisplayed()) {
            // Open OTP input page
            otpScreen.clickOTPPopup();
            commonFunctions.openApplication("https://id.chotot.org/login/otp?phone=0348971747&continue=https%3A%2F%2Fwww.chotot.org%2F");

            // Input OTP
            otpScreen.enterOTP("123456");

            // Click "Tiếp tục" button
            otpScreen.clickContinueOTPScreen();
        }

        //khai báo Object User Profile
        UpdateProfileFunctions updateProfile = new UpdateProfileFunctions(driver);
        // Open the Chotot login page
        commonFunctions.openApplication("https://chotot.org/");

        // Navigate to UserProfile
        updateProfile.navigateToUserProfile();
        // Assert error message for a mandatory field
        String xpathForMandatoryField = "//input[@name='full_name']"; // Replace with the correct XPath
        String expectedErrorMessage = "Vui lòng nhập tên."; // Replace with the expected error message
        updateProfile.assertErrorMessageDisplayed(xpathForMandatoryField, expectedErrorMessage);
    }

}




