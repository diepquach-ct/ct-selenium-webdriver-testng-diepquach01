import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class UserProfileTest extends BaseTest {
    @Test
    public void TC_01_verifySuccessfulProfileUpdate() {
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

        //Perform updateUserProfile
        updateProfile.updateUserProfile("QA GV Test","06 Tân Trào","hello guys","001002003004","HCM");
        // 7. Verify Successful Profile Update:
        updateProfile.verifySuccessfulProfileUpdate("Cập nhật thay đổi thành công.");

        //Close the application
        commonFunctions.closeApplication();
    }

    private boolean isOTPPopupDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
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
    public void TC_02_verifyBlankFullNameField() {
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
        //8. Clear full_name field
        commonFunctions.clearInputField(By.xpath("//*[@name='full_name']"));
        //9. Click Save button
        commonFunctions.clickElement(By.xpath("//button[contains(text(), 'Lưu thay đổi')]"));
        // 7. Verify full name field validation
        updateProfile.verifyErrorMessage_BlankFullName("Vui lòng nhập tên.");
        //Close the application
        commonFunctions.closeApplication();
    }

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
        //Close the application
        commonFunctions.closeApplication();
    }

    @Test
    public void TC_04_verifyErrorMessageLimitFullName() {
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
        commonFunctions.enterText(By.xpath("//*[@name='full_name']"), "Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. Separated they live in Bookmarksgrove right at the coast of the Semantics, a large language ocean. A small river named Duden flows by their place and supplies it with the necessary regelialia. It is a paradisematic country, in which roasted parts of");

        //9. Click Save button
        commonFunctions.clickElement(By.xpath("//button[contains(text(), 'Lưu thay đổi')]"));
        // 7. Verify full name field validation
        updateProfile.verifyErrorMessage_LimitFullName("Tên chứa nhiều hơn 100 ký tự");
        //Close the application
        commonFunctions.closeApplication();
    }

    @Test
    public void TC_05_verifyErrorMessage_OverLimitDescription() {
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
        //7. Click description field
        commonFunctions.clickElement(By.xpath("//textarea[@name='description']"));
        //8. Clear description field
        commonFunctions.clearInputField(By.xpath("//textarea[@name='description']"));
        //9. Enter description field
        commonFunctions.enterText(By.xpath("//textarea[@name='description']"), "Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. Separated they live in Bookmarksgrove right at the coast of the Semantics, a large language ocean. A small river named Duden flows by their place and supplies it with the necessary regelialia. It is a paradisematic country, in which roasted parts of");

        //9. Click Save button
        commonFunctions.clickElement(By.xpath("//button[contains(text(), 'Lưu thay đổi')]"));
        // 7. Verify description field validation
        updateProfile.verifyErrorMessage_OverLimitDescription("Giới thiệu không được vượt quá 60 từ.");
        //Close the application
        commonFunctions.closeApplication();
    }
}




