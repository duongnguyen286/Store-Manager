import DAO.ConnectDatabase;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SeleniumTest {
    private WebDriver driver;
    private Connection connection = null;
    Statement st = null;
    PreparedStatement preparedStatement = null;

    public SeleniumTest() throws InterruptedException, SQLException, ClassNotFoundException {
        System.setProperty("webdriver.chrome.driver", "../chromedriver-win64 (1)/chromedriver-win64/chromedriver.exe");
        driver = new ChromeDriver();
        if (connection == null) {
            connection = ConnectDatabase.getMySQLConnection();
            connection.setAutoCommit(false);
        } else {
            connection.setAutoCommit(false);
        }
    }

    public void login() throws InterruptedException {
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
        login();

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

        driver.quit();
    }

    @Test
    public void testAddEmployee() throws InterruptedException, SQLException {
        login();

        String eName = "Nguyễn Minh Tuânnnnnn";
        int ePosition = 1;
        String eContractStartAt = "01-13-2025";
        String eContractEndAt = "01-13-2027";

        WebElement addButton = driver.findElement(By.id("addButton"));
        addButton.click();
        Thread.sleep(1500);

        WebElement submitAddButton = driver.findElement(By.id("submit_add_button"));
        submitAddButton.click();
        Thread.sleep(1500);

        WebElement name = driver.findElement(By.id("name"));
        name.sendKeys(eName);
        Thread.sleep(1500);

        WebElement positionElement = driver.findElement(By.id("position"));
        Select position = new Select(positionElement);
        position.selectByIndex(ePosition);
        Thread.sleep(1500);

        WebElement contractStartAt = driver.findElement(By.id("contract_start_at"));
        contractStartAt.sendKeys(eContractStartAt);
        Thread.sleep(1500);

        WebElement contractEndAt = driver.findElement(By.id("contract_end_at"));
        contractEndAt.sendKeys(eContractEndAt);
        Thread.sleep(1500);

        submitAddButton.click();
        Thread.sleep(1500);

        WebElement backButton = driver.findElement(By.id("back_button"));
        backButton.click();
        Thread.sleep(1500);

        String sql = "SELECT * FROM employees WHERE id = (SELECT MAX(id) FROM employees)";
        PreparedStatement statement = (PreparedStatement) connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            Assert.assertEquals(eName, resultSet.getString("name"));
            Assert.assertEquals(ePosition, resultSet.getInt("position"));
            Assert.assertEquals(this.handleReverseDate(eContractStartAt), resultSet.getString("contract_start_at"));
            Assert.assertEquals(this.handleReverseDate(eContractEndAt), resultSet.getString("contract_end_at"));
        } else {
            Assert.fail("No employee found in the database.");
        }

        driver.quit();
    }

    @Test
    public void testUpdateEmployee() throws InterruptedException, SQLException {
        login();

        WebElement newSearchText = driver.findElement(By.id("searchText"));
        newSearchText.sendKeys("tuân");
        Thread.sleep(1500);

        WebElement newSearchButton = driver.findElement(By.id("searchButton"));
        newSearchButton.click();
        Thread.sleep(1500);

        WebElement updateButton = driver.findElement(By.id("update_button"));
        updateButton.click();
        Thread.sleep(1500);

        String title = driver.findElement(By.className("card-title")).getText();
        String[] parts = title.split(" - ");

        WebElement submitUpdateButton = driver.findElement(By.id("submit_update_button"));
        submitUpdateButton.click();
        Thread.sleep(1500);

        String eName = "Nguyễn Minh Tuân";
        int ePosition = 1;
        String eContractStartAt = "01-13-2026";
        String eContractEndAt = "01-13-2028";

        WebElement name = driver.findElement(By.id("name"));
        name.clear();
        name.sendKeys(eName);
        Thread.sleep(1500);

        WebElement positionElement = driver.findElement(By.id("position"));
        Select position = new Select(positionElement);
        position.selectByIndex(ePosition);
        Thread.sleep(1500);

        WebElement contractStartAt = driver.findElement(By.id("contract_start_at"));
        contractStartAt.sendKeys(eContractStartAt);
        Thread.sleep(1500);

        WebElement contractEndAt = driver.findElement(By.id("contract_end_at"));
        contractEndAt.sendKeys(eContractEndAt);
        Thread.sleep(1500);

        WebElement newSubmitUpdateButton = driver.findElement(By.id("submit_update_button"));
        newSubmitUpdateButton.click();
        Thread.sleep(1500);

        if (parts.length > 1) {
            String code = parts[1];
            String sql = "SELECT * FROM employees WHERE code = ?";
            PreparedStatement statement = (PreparedStatement) connection.prepareStatement(sql);
            statement.setString(1, code);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Assert.assertEquals(eName, resultSet.getString("name"));
                Assert.assertEquals(ePosition, resultSet.getInt("position"));
                Assert.assertEquals(this.handleReverseDate(eContractStartAt), resultSet.getString("contract_start_at"));
                Assert.assertEquals(this.handleReverseDate(eContractEndAt), resultSet.getString("contract_end_at"));
            } else {
                Assert.fail("No employee found in the database.");
            }
        }

        WebElement backButton = driver.findElement(By.id("update_back_button"));
        backButton.click();
        Thread.sleep(1500);

        driver.quit();
    }

    @Test
    public void testDeleteEmployee() throws InterruptedException, SQLException {
        login();

        WebElement newSearchText = driver.findElement(By.id("searchText"));
        newSearchText.sendKeys("khải");
        Thread.sleep(1500);

        WebElement newSearchButton = driver.findElement(By.id("searchButton"));
        newSearchButton.click();
        Thread.sleep(1500);

        WebElement deleteButton = driver.findElement(By.id("delete_button"));
        deleteButton.click();
        Thread.sleep(1500);

        String url = driver.findElement(By.id("delete-form")).getAttribute("action");
        String idRegex = "(?<=id=)\\d+";
        Pattern pattern = Pattern.compile(idRegex);
        Matcher matcher = pattern.matcher(url);

        WebElement submitDeleteButton = driver.findElement(By.id("submit_delete_button"));
        submitDeleteButton.click();
        Thread.sleep(1500);

        if (matcher.find()) {
            String id = matcher.group(0);
            String sql = "SELECT * FROM employees WHERE id = ?";
            PreparedStatement statement = (PreparedStatement) connection.prepareStatement(sql);
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                if (resultSet.getString("deleted_at") != "") {
                    System.out.println("Pass");
                } else {
                    Assert.fail("Employee is not deleted yet.");
                }
            } else {
                Assert.fail("No employee found.");
            }
        } else {
            Assert.fail("No employee id found.");
        }

        driver.quit();
    }

    public String handleReverseDate(String date) {
        if (date != "") {
            String[] dateParts = date.split("-");
            String day = dateParts[1];
            String month = dateParts[0];
            String year = dateParts[2];

            return year + "-" + month + "-" + day;
        }

        return "";
    }
}
