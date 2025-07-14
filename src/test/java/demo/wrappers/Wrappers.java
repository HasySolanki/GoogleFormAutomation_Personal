package demo.wrappers;


import java.time.LocalDate;


import java.time.format.DateTimeFormatter;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class Wrappers {
 


 static WebDriverWait wait;




 public static void enterText(ChromeDriver driver, WebElement element, String value) {
   try {


     wait = new WebDriverWait(driver, Duration.ofMillis(20));
     wait.until(ExpectedConditions.visibilityOf(element));
     if (element != null) {
       element.click();
       element.clear();
       element.sendKeys(value);
     }


   } catch (Exception e) {


     System.out.println("Element is not visible:-" + e.getMessage());
   }


 }


 public static String getEpochTimeAsString() {
   long epochTime = System.currentTimeMillis() / 1000;
   String epochTimeString = String.valueOf(epochTime);
   return epochTimeString;
 }


 public static void radioButton(ChromeDriver driver, String radiobttonText) {


   try {
     wait = new WebDriverWait(driver, Duration.ofMillis(20));
     WebElement radioButtonElement = driver
         .findElement(By.xpath("//div[contains(@class, 'nWQGrd zwllIb')] //span[contains(normalize-space(text()), '"
             + radiobttonText + "')]"));
     wait.until(ExpectedConditions.visibilityOf(radioButtonElement));
     radioButtonElement.click();
   } catch (Exception e) {

     System.out.println("Radio button is not selected " + e.getMessage());
   
   }
 }


 public static void checkboxButton(ChromeDriver driver, String checkboxValue) {


   try {
     wait = new WebDriverWait(driver, Duration.ofMillis(20));
     WebElement checkboxElement = driver.findElement(By.xpath(
         "//div[contains(@class, 'Y6Myld')] //span[contains(normalize-space(text()), '" + checkboxValue + "')]"));
     wait.until(ExpectedConditions.visibilityOf(checkboxElement));
     checkboxElement.click();
   } catch (Exception e) {


     System.out.println("Checkbox does not clickabled" + e.getMessage());
   }
 }


 public static void clickOnElement(ChromeDriver driver, WebElement element) {


   try {


     JavascriptExecutor js = (JavascriptExecutor) driver;
     js.executeScript("arguments[0].click()", element);


   } catch (Exception e) {


     System.out.println("Element is not Enabled" + e.getMessage());
   }


 }


 public static void dropDownlistSelected(ChromeDriver driver, List<WebElement> elements, String value) {


   try {


     for (int i = 0; i < elements.size(); i++) {
       if (elements.get(i).getText().equals(value)) {
         wait = new WebDriverWait(driver, Duration.ofMillis(20));


         System.out.println(elements.get(i).getText());
         clickOnElement(driver, elements.get(i));
         break;
       }
     }


   } catch (Exception e) {


     System.out.println("Dropdown Value does not selected " + e.getMessage());
   }


 }


 public static String getDateSevenDayPrevious(int days) {
   String FormatedDate = "";
   try {
     LocalDate currentDate = LocalDate.now();


     LocalDate minusSevenDate = currentDate.minusDays(days);
     DateTimeFormatter datatimeformate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
     FormatedDate = minusSevenDate.format(datatimeformate);


   } catch (Exception e) {


     System.out.println("Data is not pick up " + e.getMessage());
   }
   return FormatedDate;
 }


 public static void setDate(WebElement element, String Datevalue) {


   wait.until(ExpectedConditions.visibilityOf(element));


   element.sendKeys(Datevalue);


 }


}
