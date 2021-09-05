import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

@Listeners (ITestListener.class)

public class OrangeHRM {


    public static WebDriver driver;
    static String BaseURL = "https://opensource-demo.orangehrmlive.com/";
    static JavascriptExecutor js;

    @BeforeTest
    public static void WebSetup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","E:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(BaseURL);
        Thread.sleep(3000);
        Assert.assertTrue((driver.getTitle().contains("OrangeHRM")));
    }

    @Test(priority = 0)
    public static void LandingPageVerification(){

        Assert.assertTrue((driver.getPageSource().contains("LOGIN Panel")));
        System.out.println("landing page Successful");

    }

    @Test(priority = 1)
    public static void UserLogin() throws Exception {
        MyScreenRecorder.startRecording("");
        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
        Thread.sleep(3000);
        //System.out.println("Login Succeed");
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MyScreenRecorder.stopRecording();

    }

    //@Test(priority = 2)
    public static void Admin_Add() throws Exception {
        MyScreenRecorder.startRecording("");
        driver.findElement(By.xpath("//b[contains(text(),'Admin')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='btnAdd']")).click();
        Thread.sleep(2000);
        Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='systemUser_userType']")));
        dropdown.selectByValue("1");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='systemUser_employeeName_empName']")).sendKeys("f");
        Thread.sleep(2000);
        Robot r = new Robot();
        int keyCode =  KeyEvent.VK_ENTER;
        r.keyPress(keyCode);
        r.keyRelease(keyCode);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='systemUser_userName']")).sendKeys("test.admin");
        Thread.sleep(1000);
        dropdown = new Select(driver.findElement(By.xpath("//select[@id='systemUser_status']")));
        dropdown.selectByValue("1");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='systemUser_password']")).sendKeys("admin123");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='systemUser_confirmPassword']")).sendKeys("ad,om123");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='btnSave']")).click();
        Thread.sleep(3000);
        MyScreenRecorder.stopRecording();




    }

    //@Test(priority = 3)
    public static void Admin_Search() throws InterruptedException, AWTException {
        driver.findElement(By.xpath("//b[contains(text(),'Admin')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='searchSystemUser_userName']")).sendKeys("Test Admin");
        Thread.sleep(1000);
        Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='searchSystemUser_userType']")));
        dropdown.selectByValue("2");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='searchSystemUser_employeeName_empName']")).sendKeys("f");
        Thread.sleep(2000);
        Robot r = new Robot();
        int keyCode =  KeyEvent.VK_ENTER;
        r.keyPress(keyCode);
        r.keyRelease(keyCode);
        Thread.sleep(2000);
        dropdown = new Select(driver.findElement(By.xpath("//select[@id='searchSystemUser_status']")));
        dropdown.selectByValue("1");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='searchBtn']")).click();
        Thread.sleep(3000);
        Assert.assertTrue(driver.getPageSource().contains("No Records Found"));





    }

    //@Test(priority = 4)
    public static void PIM() throws InterruptedException {
        driver.findElement(By.xpath("//b[contains(text(),'PIM')]")).click();
        Thread.sleep(2000);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,450)", "");
        Thread.sleep(2000);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(450,0)", "");
        Thread.sleep(2000);
    }

    @Test(priority = 4)
    public static void Leave() throws InterruptedException {
        driver.findElement(By.xpath("//b[contains(text(),'Leave')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='calFromDate']")).clear();
        WebElement dateBox = driver.findElement(By.xpath("//input[@id='calFromDate']"));
        dateBox.sendKeys("19880501");
        Thread.sleep(2000);

    }

    @AfterTest
    public static void TestClosure(){

        driver.quit();
    }






}
