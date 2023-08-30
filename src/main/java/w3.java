import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class w3 {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        WebDriverManager.firefoxdriver().setup();
        FirefoxDriver driver = new FirefoxDriver(firefoxOptions);
        driver.get("https://www.w3schools.com/css/css_table.asp");
    }

    @Test
    public void testCss() {
        // Table element
        WebElement table = driver.findElement(By.cssSelector("table"));

        // Amount of table rows
        int rowCount = table.findElements(By.cssSelector("tr")).size();
        System.out.println("Number of rows: " + rowCount);

        // Amount of table columns
        int colCount = table.findElements(By.cssSelector("th,td")).size();
        System.out.println("Number of columns: " + colCount);

        // Locator for the row3
        WebElement row3 = table.findElement(By.cssSelector("tr:nth-child(3)"));
        String row3Text = row3.getText();
        System.out.println("Row 3 content: " + row3Text);

        // Locator for the last column
        WebElement lastColumn = row3.findElement(By.cssSelector("td:last-child"));
        String lastColumnText = lastColumn.getText();
        System.out.println("Last column content: " + lastColumnText);
    }


    @AfterMethod
    public void tearDown() {
//        driver.quit();
    }
}
