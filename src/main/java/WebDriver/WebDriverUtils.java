package WebDriver;

import io.cucumber.java.en_old.Ac;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class WebDriverUtils {
    private WebDriver driver;
    private JavascriptExecutor javascriptExecutor = null;

    public WebDriverUtils(WebDriver webDriver) {
        this.driver = webDriver;
        javascriptExecutor = (JavascriptExecutor) driver;
    }

    public void AcceptAlert() {
        driver.switchTo().alert().accept();
    }

    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    public boolean checkIfAlertContainsText(String text) {
        return driver.switchTo().alert().getText().contains(text);
    }

    public boolean checkIfAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException ex) {
            return false;
        }
    }

    public boolean checkIfElementIsInsideFrame(String path) {
        try {
            driver.findElement(By.xpath(path.concat("//ancestor:iframe")));
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public WebElement moveToElement(String path) {
        try {
                   return  driver.findElement(By.xpath(path));
            }


finally {
           return driver.findElement(By.xpath(path));
        }
        }

        private boolean ifElementPresentOnPage(String path){
        try{
            driver.findElement(By.xpath(path));
            return  true;
        }
        catch(NoSuchElementException ex){
            ex.printStackTrace();
            return false;
        }
        }

        public void clickOnElement(String path){
        WebElement element=null;
       if(this.ifElementPresentOnPage(path)) {
           element=driver.findElement(By.xpath(path));
       }
       try{
            if (element.isEnabled() && element.isDisplayed()) {
                System.out.println("Clicking on element with using java script click");
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
            } else {
                System.out.println("Unable to click on element");
            }
        }  catch (Exception e) {
        System.out.println("Unable to click on element "+ e.getStackTrace());
    }
}

public boolean dragAndDropElement(String sourceXpath,String targetXpath){
        if(this.ifElementPresentOnPage(sourceXpath)&&this.ifElementPresentOnPage(targetXpath)){
         Actions actions=new Actions(driver);
         try {
             actions.dragAndDrop(driver.findElement(By.xpath(sourceXpath)), driver.findElement(By.xpath(targetXpath))).build().perform();
         }
         catch (Exception e){
             return false;
         }
           }
        return false;
}


}
