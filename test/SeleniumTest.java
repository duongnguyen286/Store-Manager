import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class SeleniumTest {
    public WebDriver driver;

    public SeleniumTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "../chromedriver-win64 (1)/chromedriver-win64/chromedriver.exe");
        driver = new ChromeDriver();
    }

    public void testLogin() throws InterruptedException {
        driver.get("http://localhost:8080/store/Login");

        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.sendKeys("duongnguyen286@gmail.com");
        Thread.sleep(1500);

        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("duongnguyen286");
        Thread.sleep(1500);

        WebElement loginButton = driver.findElement(By.id("login_button"));
        loginButton.click();

        WebElement employeeTab = driver.findElement(By.id("employee_tab"));
        employeeTab.click();
        Thread.sleep(1500);
    }

    @Test
    public void testSearchEmployees() throws InterruptedException {
        testLogin();

        WebElement searchText = driver.findElement(By.id("searchText"));
        searchText.sendKeys("qqqqqqqq");
        Thread.sleep(1500);

        WebElement searchButton = driver.findElement(By.id("searchButton"));
        searchButton.click();
        Thread.sleep(1500);

        WebElement newSearchText = driver.findElement(By.id("searchText"));
        newSearchText.sendKeys("tuân");
        Thread.sleep(1500);

        WebElement newSearchButton = driver.findElement(By.id("searchButton"));
        newSearchButton.click();
        Thread.sleep(1500);
    }

    @Test
    public void testAddEmployee() throws InterruptedException {
        testLogin();

        WebElement addButton = driver.findElement(By.id("addButton"));
        addButton.click();
        Thread.sleep(1500);

        WebElement submitAddButton = driver.findElement(By.id("submit_add_button"));
        submitAddButton.click();
        Thread.sleep(1500);

        WebElement name = driver.findElement(By.id("name"));
        name.sendKeys("Nguyễn Minh Tuân");
        Thread.sleep(1500);

        WebElement positionElement = driver.findElement(By.id("position"));
        Select position = new Select(positionElement);
        position.selectByIndex(1);
        Thread.sleep(1500);

        WebElement contractStartAt = driver.findElement(By.id("contract_start_at"));
        contractStartAt.sendKeys("01-13-2025");
        Thread.sleep(1500);

        WebElement contractEndAt = driver.findElement(By.id("contract_end_at"));
        contractEndAt.sendKeys("01-13-2027");
        Thread.sleep(1500);

        submitAddButton.click();
        Thread.sleep(1500);

        WebElement backButton = driver.findElement(By.id("back_button"));
        backButton.click();
        Thread.sleep(1500);
    }

    @Test
    public void testUpdateEmployee() throws InterruptedException {
        testLogin();

        WebElement newSearchText = driver.findElement(By.id("searchText"));
        newSearchText.sendKeys("tuân");
        Thread.sleep(1500);

        WebElement newSearchButton = driver.findElement(By.id("searchButton"));
        newSearchButton.click();
        Thread.sleep(1500);

        WebElement updateButton = driver.findElement(By.id("update_button"));
        updateButton.click();
        Thread.sleep(1500);

        WebElement submitUpdateButton = driver.findElement(By.id("submit_update_button"));
        submitUpdateButton.click();
        Thread.sleep(1500);

        WebElement name = driver.findElement(By.id("name"));
        name.clear();
        name.sendKeys("Nguyễn Minh Tuân");
        Thread.sleep(1500);

        WebElement positionElement = driver.findElement(By.id("position"));
        Select position = new Select(positionElement);
        position.selectByIndex(1);
        Thread.sleep(1500);

        WebElement contractStartAt = driver.findElement(By.id("contract_start_at"));
        contractStartAt.sendKeys("01-13-2025");
        Thread.sleep(1500);

        WebElement contractEndAt = driver.findElement(By.id("contract_end_at"));
        contractEndAt.sendKeys("01-13-2027");
        Thread.sleep(1500);

        WebElement newSubmitUpdateButton = driver.findElement(By.id("submit_update_button"));
        newSubmitUpdateButton.click();
        Thread.sleep(1500);

        WebElement backButton = driver.findElement(By.id("update_back_button"));
        backButton.click();
        Thread.sleep(1500);
    }

    @Test
    public void testDeleteEmployee() throws InterruptedException {
        testLogin();

        WebElement newSearchText = driver.findElement(By.id("searchText"));
        newSearchText.sendKeys("khải");
        Thread.sleep(1500);

        WebElement newSearchButton = driver.findElement(By.id("searchButton"));
        newSearchButton.click();
        Thread.sleep(1500);

        WebElement deleteButton = driver.findElement(By.id("delete_button"));
        deleteButton.click();
        Thread.sleep(1500);

        WebElement submitDeleteButton = driver.findElement(By.id("submit_delete_button"));
        submitDeleteButton.click();
        Thread.sleep(1500);
    }
}
