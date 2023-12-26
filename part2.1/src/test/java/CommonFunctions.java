import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CommonFunctions {
    protected WebDriver driver; //protected: có thể được truy cập từ các lớp con.
    protected WebDriverWait wait;


    //tạo constructor
    public CommonFunctions(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20); // Thời gian chờ tối đa là 10 giây, bạn có thể điều chỉnh nếu cần thiết

    }

    public WebElement getElementByXPath(String xpath) {
        // Method WebDriverWait để chờ đến khi một phần tử xuất hiện theo đường dẫn XPath và trả về nó.
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }


    public void openApplication(String url) {
        if (driver != null) {
            driver.get(url);
        } else {
            System.out.println("Driver is null. Cannot open application.");
            // Thêm xử lý khác nếu cần thiết
        }
    }

    public void closeApplication() {
        if (driver != null) { //driver !=null để không bị lỗi NullPointerException
            driver.quit();
        }
    }

    public void maximizeWindow() {
        if (driver != null) { //driver !=null để không bị lỗi NullPointerException
            driver.manage().window().maximize();
        }
    }

    public void clickElement(By locator) {
        // Đợi cho đến khi element có thể nhìn thấy trên trang
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        // Thực hiện click sau khi element đã được tìm thấy và nhìn thấy trên trang
        element.click();
    }

    public void enterText(By locator, String text) {
        // Đợi cho đến khi element có thể nhìn thấy trên trang
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        // Thực hiện nhập text sau khi element đã được tìm thấy và nhìn thấy trên trang
        element.sendKeys(text);
    }

    //method xoá nội dung trong ô nhập liệu
    public void clearInputField(By locator) {
        // Đợi cho đến khi element có thể nhìn thấy trên trang
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        // Thực hiện clear sau khi element đã được tìm thấy và nhìn thấy trên trang
        element.clear();
    }


    //method dropdownlist
    public void selectDropdownByValue(By locator, String value) { //dropdown binh thuong chi chon duy nhat 1 option
        // Đợi cho đến khi dropdown có thể được nhấp vào
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(locator));
        dropdown.click();
        Select select = new Select(dropdown);
        select.selectByValue(value);
    }

    //method dropdownlistLoop to Ward
    public void selectDropdownByValueAndLoopAddress(By locator) {
        // Đợi cho đến khi dropdown có thể được nhấp vào
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(locator));
        Select select = new Select(dropdown);

        // Get giá trị hiện tại được chọn
        String selectedValue = select.getFirstSelectedOption().getAttribute("value");

        // Get danh sách tất cả các option
        List<WebElement> options = select.getOptions();

        // Find vị trí của giá trị hiện tại trong danh sách
        int currentIndex = findIndexByValue(options, selectedValue);

        // Select next value and loop nếu đã ở cuối danh sách
        int nextIndex = currentIndex + 1;
        if ("9467".equals(selectedValue)) {
            nextIndex = findIndexByValue(options, "9470");
        }
        select.selectByValue(options.get(nextIndex).getAttribute("value"));
    }

    // sử dụng cho hàm selectDropdownByValueAndLoopAddress
    private int findIndexByValue(List<WebElement> options, String value) {
        for (int i = 0; i < options.size(); i++) {
            if (options.get(i).getAttribute("value").equals(value)) {
                return i;
            }
        }
        return -1;  // Trả về -1 nếu không tìm thấy giá trị
    }

    // Danh mục yêu thích
    public void activateCategories(String[] categoriesToActive) {
        for (int i = 0; i < categoriesToActive.length; i++) {
            String category = categoriesToActive[i];
            if (!isActive(category)) {
                // Đợi cho đến khi phần tử có thể được nhấp vào
                WebElement categoryElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='" + category + "']")));
                // Thực hiện click chỉ khi phần tử có thể được nhấp vào
                categoryElement.click();
                // Thực hiện click chỉ khi phần tử có thể được nhấp vào
                    categoryElement.click();
                } else if (isActive(category)) {
                    // Không thực hiện action gì cả trong trường hợp isActive(category).
                }
            }
        }

    public void deactivateCategories(String[] categoriesToDeactivate) {
        for (int i = 0; i < categoriesToDeactivate.length; i++) {
            String category = categoriesToDeactivate[i];
            if (isActive(category)) {
                // Đợi cho đến khi phần tử có thể được nhấp vào
                WebElement categoryElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='" + category + "']")));
                // Thực hiện click chỉ khi phần tử có thể được nhấp vào
                if (categoryElement != null) {
                    categoryElement.click();
                } else if (!isActive(category)) {
                    // Không thực hiện action gì cả trong trường hợp !isActive(category).
                }
            }
        }
    }

    private boolean isActive(String categoryText) {
        By locator = By.xpath("//a[text()='" + categoryText + "']");
        WebElement category = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return category.getAttribute("class").contains("active");
    }

    //method dropdownlistLoop to Month
    public void selectDropdownByValueAndLoopMonth(By locator) {
        // Đợi cho đến khi dropdown có thể được nhấp vào
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(locator));
        Select select = new Select(dropdown);

        // Get giá trị hiện tại được chọn
        String selectedValue = select.getFirstSelectedOption().getAttribute("value");

        // Get danh sách tất cả các option
        List<WebElement> options = select.getOptions();

        // Find vị trí của giá trị hiện tại trong danh sách
        int currentIndex = findIndexByValue(options, selectedValue);

        // Select next value and loop nếu đã ở cuối danh sách
        int nextIndex = currentIndex + 1;
        if ("11".equals(selectedValue)) {
            nextIndex = findIndexByValue(options, "0");
        }
        select.selectByValue(options.get(nextIndex).getAttribute("value"));
    }

    //method dropdownlistLoop to Year
    public void selectDropdownByValueAndLoopYearBirthday(By locator) {
        // Đợi cho đến khi dropdown có thể được nhấp vào
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(locator));
        Select select = new Select(dropdown);

        // Get giá trị hiện tại được chọn
        String selectedValue = select.getFirstSelectedOption().getAttribute("value");

        // Get danh sách tất cả các option
        List<WebElement> options = select.getOptions();

        // Find vị trí của giá trị hiện tại trong danh sách
        int currentIndex = findIndexByValue(options, selectedValue);

        // Select next value and loop nếu đã ở cuối danh sách
        int nextIndex = currentIndex + 1;
        if ("2005".equals(selectedValue)) {
            nextIndex = findIndexByValue(options, "1955");
        }
        select.selectByValue(options.get(nextIndex).getAttribute("value"));
    }

    public void selectDropdownByValueAndLoopYearID(By locator) {
        // Đợi cho đến khi dropdown có thể được nhấp vào
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(locator));
        Select select = new Select(dropdown);

        // Get giá trị hiện tại được chọn
        String selectedValue = select.getFirstSelectedOption().getAttribute("value");

        // Get danh sách tất cả các option
        List<WebElement> options = select.getOptions();

        // Find vị trí của giá trị hiện tại trong danh sách
        int currentIndex = findIndexByValue(options, selectedValue);

        // Chọn next value và loop nếu đã ở cuối danh sách và năm nằm trong khoảng valid
        int nextIndex = currentIndex + 1;
        while (nextIndex < options.size()) {
            String nextValue = options.get(nextIndex).getAttribute("value");
            int selectedYear = Integer.parseInt(nextValue);

            if (isValidYear(selectedYear)) {
                select.selectByValue(nextValue);
                break;
            }

            // Nếu năm không nằm trong khoảng hợp lệ, và đến năm 2023 thì quay lại năm 2000
            if (selectedYear > 2023) {
                select.selectByValue("2000");
                break;
            }

            // Nếu năm không nằm trong khoảng hợp lệ, tăng index để chọn giá trị tiếp theo
            nextIndex++;
        }
    }

    private boolean isValidYear(int year) {
        return year >= 2000 && year <= 2023;
    }


}





