import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Leumi {
    public static void main(String[] args) {
//        ChromeOptions chromeOptions = new ChromeOptions();
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver(chromeOptions);
//        driver.get("https://www.leumi.co.il/");


        FirefoxOptions firefoxOptions = new FirefoxOptions();
        WebDriverManager.firefoxdriver().setup();
        FirefoxDriver driver = new FirefoxDriver(firefoxOptions);


        driver.get("https://www.leumi.co.il/");
        driver.manage().window().maximize();



        WebElement element = driver.findElement(By.xpath("/html/body/header/nav/nav/ul/li[1]/a/span"));


        String elementText = element.getText();
        System.out.println("Element content: " + elementText);


    }
}
