package ncs.codecamp.au;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PlanetPage {

   public WebDriver driver;
   public PlanetPage (WebDriver driver){
      this.driver = driver;
   }
   public Planet getPlanet(Predicate<Planet> strategy){
      for (WebElement planetElmnt : getPlanets()){
         Planet planetObj = new Planet(planetElmnt);
         if(strategy.test(planetObj)){
            return planetObj;
         }

      }
      throw new RuntimeException("Not found");
   }

   public List<WebElement> getPlanets() {
      List<WebElement> planetList = new ArrayList<>();

      for (WebElement planetDiv : driver.findElements(By.cssSelector(".planet"))) {
         planetList.add(planetDiv);
      }

      return planetList;
   }


}
