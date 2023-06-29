package ncs.codecamp.au;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Planet {
    public WebElement webElement;

    public Planet(WebElement currentElement) {
        webElement = currentElement;
    }

    public String getPlanetName(){
       return webElement.findElement(By.className("name")).getText();
    }
    public void clickExplore(){
         webElement.findElement(By.tagName("button")).click();
    }
}
