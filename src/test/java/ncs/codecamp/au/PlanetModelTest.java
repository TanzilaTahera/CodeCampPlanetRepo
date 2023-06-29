package ncs.codecamp.au;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class PlanetModelTest {
    private WebDriver driver;

    @BeforeEach
    public void setDriver() {
        driver = getWebDriver();
        driver.get("https://d18u5zoaatmpxx.cloudfront.net/#/");
        driver.manage().window().maximize();
    }
    @Test
    public void explorePlanets(){
        driver.findElement(By.cssSelector("[aria-label=planets]")).click();
        //PlanetPage planetPage = new PlanetPage(driver);
       // planetPage.getPlanet("earth").clickExplore();

        new PlanetPage(driver).getPlanet(planet -> planet.getPlanetName().equalsIgnoreCase("earth"));
    }


    @AfterEach
    public void cleanUp(){
        //driver.quit();
    }

    private WebDriver getWebDriver(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        return driver;
    }
}
