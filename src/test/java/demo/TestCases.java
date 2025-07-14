package demo;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.util.List;
import java.util.logging.Level;


import demo.wrappers.Wrappers;
// this is TestCases file

public class TestCases extends Wrappers {
   ChromeDriver driver;
// this is beforeTest file
   @BeforeTest
   public void startBrowser() {

   

       System.setProperty("java.util.logging.config.file", "logging.properties");
       ChromeOptions options = new ChromeOptions();
       LoggingPreferences logs = new LoggingPreferences();


       logs.enable(LogType.BROWSER, Level.ALL);
       logs.enable(LogType.DRIVER, Level.ALL);
       options.setCapability("goog:loggingPrefs", logs);
       options.addArguments("--remote-allow-origins=*");


       System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "build/chromedriver.log");


       driver = new ChromeDriver(options);


       driver.manage().window().maximize();


   }
// this is TestCases  Test file git update 

   @Test
   public void testCase01() throws InterruptedException {

     

       driver.get(
               "https://docs.google.com/forms/d/e/1FAIpQLSep9LTMntH5YqIXa5nkiPKSs283kdwitBBhXWyZdAS-e4CxBQ/viewform?usp=send_form");


       WebElement nameTxt = driver.findElement(By.xpath("//div[contains(@class,'k3kHxc')]//input"));
       enterText(driver, nameTxt, "Crio Learner");
       System.out.println("Wait 1");
       Thread.sleep(3000);
       String practicingAutomationTxt = "I want to be the best QA Engineer";
       String getepochtimeString = getEpochTimeAsString();


       WebElement autmationTextArea = driver.findElement(By.xpath("//textarea[contains(@class,'KHxj8b tL9Q4c')]"));
       System.out.println("Wait 2");
       enterText(driver, autmationTextArea, practicingAutomationTxt + " " + getepochtimeString);
       System.out.println("Wait 3");


       radioButton(driver, "3 - 5");
       Thread.sleep(3000);
       System.out.println("Wait 4");

      

       checkboxButton(driver, "Java");
       checkboxButton(driver, "Selenium");
       checkboxButton(driver, "TestNG");
          

       System.out.println("wait 5");
       Thread.sleep(3000);
       WebElement dropElement = driver.findElement(By.xpath("(//div[contains(@class, 'DEh1R')])[1]"));
       clickOnElement(driver, dropElement);
       System.out.println("wait 6");
       Thread.sleep(3000);
       List<WebElement> chooseGenderElements = driver
               .findElements(By.xpath("//div[contains(@class,'OA0qNb')]//span[not(contains(text(),'Choose'))]"));


       dropDownlistSelected(driver, chooseGenderElements, "Mr");
       System.out.println("wait 6");
       Thread.sleep(3000);


       WebElement dateElement = driver.findElement(By.xpath("//input[contains(@type,'date')]"));


       String minusSevenDate = getDateSevenDayPrevious(7);
     
       setDate(dateElement, minusSevenDate);


       WebElement hourElement = driver.findElement(By.xpath("(//input[contains(@type,'number')])[1]"));
       WebElement minuteElement = driver.findElement(By.xpath("(//input[contains(@type,'number')])[2]"));


       WebElement SubmitElement = driver.findElement(By.xpath("//span[contains(text(),'Submit')]"));
       enterText(driver, hourElement, "7");
       enterText(driver, minuteElement, "30");
       clickOnElement(driver, SubmitElement);


       System.out.println("wait 7");
       Thread.sleep(3000);


       WebElement successMsgElement = driver.findElement(By.xpath("//div[@class='vHW8K']"));
       System.out.println(successMsgElement.getText());
      
      }


   @AfterTest
   public void endTest() {
       driver.close();
       driver.quit();


   }
}
