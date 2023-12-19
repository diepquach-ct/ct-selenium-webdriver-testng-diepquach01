import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class UpdateProfileFunctions extends CommonFunctions {
    public UpdateProfileFunctions(WebDriver driver) {
        super(driver); //gọi constructor của lớp cha để đảm bảo rằng các thuộc tính và phương thức của lớp cha được khởi tạo đúng cách
    }

    public void navigateToUserProfile() {
        //Click đăng tin để popup biến mất
        clickElement(By.xpath("//a[@href='https://www.chotot.org/dang-tin']"));
        // Chờ cho element Thú cưng có thể được nhấp vào
        clickElement(By.xpath("//*[*[label[text()='Thú cưng']]]"));
        // Chờ cho element Gà có thể được nhấp vào
        clickElement(By.xpath("//*[*[label[text()='Gà']]]"));
        // Đợi 5 giây trước khi làm mới trang
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.navigate().refresh(); //refresh là do app wapper nhiều khi chưa sync kịp name login
        //Click xpath = class thay the name on wrapper
        clickElement(By.xpath("//span[contains(@class, 'aw__n40viec')]"));
        //clickElement(By.xpath("//*[*[text()='QA Verticals Test']]"));

        //Click 'Cài đặt tài khoản' on more menu
        clickElement(By.xpath("//a[contains(@href, 'dashboard/profile')]"));
    }

    public void updateUserProfile(String newFullName, String addressDetail, String description, String CCCD, String idPlace) {
        //-------------Hồ Sơ cá nhân-------------------------//
        clickElement(By.xpath("//*[@name='full_name']"));

        //xoá nội dung hiện tại trong Họ và Tên
        clearInputField(By.xpath("//*[@name='full_name']"));
        // input text mới trong Họ và tên
        enterText(By.xpath("//*[@name='full_name']"), newFullName);

        //click dropdown-list Dia chỉ
        clickElement(By.xpath("//select[option[text()='Địa chỉ']]"));

        //selecting dropdown-list thanh pho
        selectDropdownByValue(By.xpath("//select[@name='region']"), "13000");
        //selecting dropdown-list quan
        selectDropdownByValue(By.xpath("//select[@name='area']"), "13102");
        //selecting dropdown-list phuong có Loop
        selectDropdownByValueAndLoopAddress(By.xpath("//select[@name='ward']"));

        //enter địa chỉ cụ thể
        clearInputField(By.xpath("//*[@name='address_detail']"));
        enterText(By.xpath("//*[@name='address_detail']"), addressDetail);

        //click button Xong
        clickElement(By.xpath("//button[text()='XONG']"));

        //textarea Giới thiệu
        clearInputField(By.xpath("//textarea[@name='description']"));
        enterText(By.xpath("//textarea[@name='description']"), description);

        //--------------------------------------------------------------------------//


        //-----------Thông tin bảo mật---------------
        //CCCD
        clickElement(By.xpath("//select[option[text()='CCCD / CMND / Hộ chiếu']]"));
        clearInputField(By.xpath("//*[@name='id_number']"));
        enterText(By.xpath("//*[@name='id_number']"), CCCD);
        //Ngay cap
        //open datepicker
        clickElement(By.xpath("//div[label[text()='Ngày cấp']]/input"));
        //open month dropdownlist
        clickElement(By.xpath("//select[@class='react-datepicker__month-select']"));
        selectDropdownByValueAndLoopMonth(By.xpath("//select[@class='react-datepicker__month-select']"));
        //open year dropdownlist
        clickElement(By.xpath("//select[@class='react-datepicker__year-select']"));
        selectDropdownByValueAndLoopYearID(By.xpath("//select[@class='react-datepicker__year-select']"));
        // select default week and tab_index of day = 0
        clickElement(By.xpath("//div[contains(@class,'datepicker__week')]/div[(not(contains(@class,'datepicker__day--outside-month')) and (text()='1'))]"));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        clearInputField(By.xpath("//*[@name='id_place']"));
        enterText(By.xpath("//*[@name='id_place']"), idPlace);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='XONG']")));
        clickElement(By.xpath("//button[text()='XONG']"));


        //Danh mục yêu thích
        String[] categoriesToActivate = {"Điện thoại", "Máy tính bảng", "Thiết bị đeo thông minh"};
        //String[] categoriesToDeactivate = {"Tivi, Âm thanh","Điện thoại", "Máy tính bảng", "Thiết bị đeo thông minh"};
        clickElement(By.xpath("//div[contains(@class, 'i191zk3d') and label[text()='Danh mục yêu thích']]"));
        // Kiểm tra và thực hiện các thao tác Active
        activateCategories(categoriesToActivate);
        clickElement(By.xpath("//button[text()='LƯU THAY ĐỔI']"));

//        // Kiểm tra và thực hiện các thao tác Deactivate
//        clickElement(By.xpath("//div[contains(@class, 'i191zk3d') and label[text()='Danh mục yêu thích']]"));
//        deactivateCategories(categoriesToDeactivate);
//        clickElement(By.xpath("//button[text()='LƯU THAY ĐỔI']"));

        //giói tính
        selectDropdownByValue(By.xpath("//select[@name='gender']"), "f");
        //clickElement(By.xpath("//select[@name='gender']/option[@value='f']"));
        //ngay thang nam sinh
        //open datepicker
        clickElement(By.xpath("//div[label[text()='Ngày, tháng, năm sinh']]/input"));
        //open month dropdownlist
        clickElement(By.xpath("//select[@class='react-datepicker__month-select']"));
        selectDropdownByValueAndLoopMonth(By.xpath("//select[@class='react-datepicker__month-select']"));
        //open year dropdownlist
        clickElement(By.xpath("//select[@class='react-datepicker__year-select']"));
        selectDropdownByValueAndLoopYearBirthday(By.xpath("//select[@class='react-datepicker__year-select']"));
        // select default week and tab_index of day = 0
        clickElement(By.xpath("//div[contains(@class,'datepicker__week')]/div[(not(contains(@class,'datepicker__day--outside-month')) and (text()='1'))]"));
        clickElement(By.xpath("//button[contains(text(), 'Lưu thay đổi')]"));

    }
    //---dang lam error message khúc nay tro xuong
    public void assertErrorMessageDisplayed(String fieldXPath, String expectedErrorMessageXPath) {
        // Click vào trường dữ liệu để kích hoạt thông báo lỗi và lấy thông báo lỗi trả về
        String actualErrorMessage = activateFieldAndTriggerError(fieldXPath);

        // Check xem có thông báo lỗi hay không
        if (actualErrorMessage != null) {
            // So sánh thông báo lỗi thực tế với thông báo lỗi mong đợi
            if (expectedErrorMessageXPath.equals(actualErrorMessage)) {
                // Nhấn vào thông báo lỗi và kiểm tra xem có khớp với XPath mong đợi hay không
                clickAndCheckErrorMessage(By.xpath("//p[contains(@class, 'mocked-styled-11') and text()='Vui lòng nhập tên.']"), expectedErrorMessageXPath);
            } else {
                // Nếu thông báo lỗi không khớp với dự kiến, ném một AssertionError
                throw new AssertionError("Thông báo lỗi không khớp cho trường: " + fieldXPath
                        + ". Dự kiến: " + expectedErrorMessageXPath + ", Thực tế: " + actualErrorMessage);
            }
        } else {
            // Nếu không có thông báo lỗi, ném một AssertionError
            throw new AssertionError("Không có thông báo lỗi được hiển thị cho trường: " + fieldXPath);
        }
    }

    public String activateFieldAndTriggerError(String fieldXPath) {
        // Nhấn vào trường dữ liệu để kích hoạt thông báo lỗi
        clickElement(By.xpath(fieldXPath));
        clearInputField(By.xpath(fieldXPath));
        clickElement(By.xpath("//button[contains(text(), 'Lưu thay đổi')]"));

        // Sử dụng WebDriverWait để chờ đến khi thông báo lỗi xuất hiện
        By errorLocator = By.xpath("//p[contains(@class, 'mocked-styled-11') and text()='Vui lòng nhập tên.']");
        WebDriverWait wait = new WebDriverWait(driver, 10);

        try {
            WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(errorLocator));

            // Lấy nội dung của thông báo lỗi
            return errorElement.getText();
        } catch (TimeoutException e) {
            // Nếu không có thông báo lỗi xuất hiện, trả về null
            return null;
        }
    }

}


