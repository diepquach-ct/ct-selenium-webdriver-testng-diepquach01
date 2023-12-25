import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


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
    public void verifyErrorMessage_BlankFullName(String errMgsExpected){
        WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(@class, 'mocked-styled-11') and text()='Vui lòng nhập tên.']")));
        String mgsError = errorElement.getText();
        Assert.assertEquals(errMgsExpected, mgsError);
    }

    public void verifyErrorMessage_FullName(String errMgsExpected) {
        WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Lưu thay đổi')]//preceding-sibling::div//div[contains(@class,'error')]/div")));
        // getText() để lấy văn bản của phần tử
        String mgsError = errorElement.getText();
        // assertEquals() để kiểm tra văn bản
        Assert.assertEquals(errMgsExpected, mgsError);
    }
}


