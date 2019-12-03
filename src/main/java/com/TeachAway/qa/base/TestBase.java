package com.TeachAway.qa.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import com.TeachAway.qa.util.TestUtil;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver driver;
    public static Properties prop;
    public TestBase(){
        try{
            prop = new Properties();
            FileInputStream ip = new FileInputStream("C:\\Users\\sarat\\Desktop\\TeachAway\\src\\main\\java\\com\\TeachAway\\qa\\config\\config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }

    }
    public static void initialization(){
        String browserName= prop.getProperty("browser");
        if(browserName.equals("chrome")){
            System.setProperty("webdriver.chrome.driver","C:\\Users\\sarat\\Desktop\\TeachAway\\Drivers\\Chrome\\chromedriver.exe");
            driver =new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
        driver.get(prop.getProperty("url"));
    }
    public static void SelectJobs() throws InterruptedException {

        WebElement e1 = driver.findElement(By.xpath("//*[@id=\"tb-megamenu-main\"]/div/ul/li[1]/span"));
        //MouseOver to Jobs
        Actions act =new Actions(driver);
        act.moveToElement(e1).perform();
        //Get sub menu list
        List<WebElement> elist=driver.findElements(By.xpath("//ul[@class='tb-megamenu-subnav mega-nav level-1 items-6']/li[@data-level='2']"));
        WebDriverWait wait= new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@class='tb-megamenu-subnav mega-nav level-1 items-6']/li[@data-level='2']")));
        System.out.println("Jobs sub-menu items are : ");
        //Print captured sub menu list.
        for(WebElement e:elist){
            System.out.println(e.getText());
        }
   }
        public static void SelectTEFL(){

        WebElement e1 = driver.findElement(By.xpath("//*[@id=\"tb-megamenu-main\"]/div/ul/li[2]"));
        //MouseOver to TEFL
        Actions act =new Actions(driver);
        act.moveToElement(e1).perform();
        // Get sub menu list
        List<WebElement> elist=driver.findElements(By.xpath("//ul[@class='tb-megamenu-subnav mega-nav level-1 items-3']/li[@data-level='2']"));
        WebDriverWait wait= new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@class='tb-megamenu-subnav mega-nav level-1 items-3']/li[@data-level='2']")));
        System.out.println("TEFL sub-menu items are : ");
        //Print captured sub menu list.
        for(WebElement e:elist){
            System.out.println(e.getText());
        }
    }

    public static void SelectTeacherCertification(){
        WebElement e1 = driver.findElement(By.xpath("//*[@id=\"tb-megamenu-main\"]/div/ul/li[3]/span"));
        //Mouse over to TeacherCertification menu
        Actions act =new Actions(driver);
        act.moveToElement(e1).perform();
        //Get sub menu items
        List<WebElement> elist=driver.findElements(By.xpath("//ul[@class='tb-megamenu-subnav mega-nav level-1 items-2']/li[@data-level='2']"));
        WebDriverWait wait= new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@class='tb-megamenu-subnav mega-nav level-1 items-2']/li[@data-level='2']")));
        System.out.println("Teacher Certification sub-menu items are : ");
        //Print captured sub menu list.
        for(WebElement e:elist){
            System.out.println(e.getText());
        }
    }
    public static void SelectCourses(){
        //Get text and print the menu item
        WebElement c1=driver.findElement(By.xpath("//*[@id=\"tb-megamenu-main\"]/div/ul/li[4]/a"));
        System.out.println("Menu Item is : "+c1.getText());
    }
    public static void SelectHireTeachers(){
        //Get text and print the menu item
        WebElement h1=driver.findElement(By.xpath("//*[@id=\"tb-megamenu-main\"]/div/ul/li[5]"));
        System.out.println("Menu Item is : "+h1.getText());
    }
}
