import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest {

    WebDriver wd;

    @BeforeMethod
    public void init(){
        wd = new ChromeDriver();
        wd.navigate().to("https://telranedu.web.app/home");
        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test
    public void loginPositiveTest(){
        // open login form
        wd.findElement(By.xpath("//*[.='LOGIN']")).click();
        // fill login form
        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("abc@def.com");

        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
        passInput.click();
        passInput.clear();
        passInput.sendKeys("$Abcdef12345");

        // click on button login
        wd.findElement(By.xpath("//button[1]")).click();
        // assert
        pause(3000);
        Assert.assertTrue(wd.findElements(By.tagName("button")).size() > 0);

    }
    @Test
    public void loginNegativeTestWrongEmail(){
        // open login form
        wd.findElement(By.xpath("//*[.='LOGIN']")).click();
        // fill login form
        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("abcdef.com");

        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
        passInput.click();
        passInput.clear();
        passInput.sendKeys("$Abcdef12345");

        // click on button login
        wd.findElement(By.xpath("//button[1]")).click();
        // assert
        pause(3000);

    }

    public void loginNegativeTestWrongPassword(){
        // open login form
        wd.findElement(By.xpath("//*[.='LOGIN']")).click();
        // fill login form
        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("martin@mail.com");

        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
        passInput.click();
        passInput.clear();
        passInput.sendKeys("abc123456");

        // click on button login
        wd.findElement(By.xpath("//button[1]")).click();
        // assert
        pause(3000);

    }

    public void pause(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}