package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class StepDefinitions {
    ChromeDriver driver;

    @Given("I have opend the web-application")
    public void iHaveOpendTheWebApplication() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.marshu.com/articles/calculate-addition-calculator-add-two-numbers.php");
        driver.manage().window().maximize();
        Thread.sleep(4000);  // Let the user actually see something!
    }
    @And("I have entered {int} into the calculator")
    public void iHaveEnteredFirstIntoTheCalculator(Integer first) {
        WebElement numberOneBox = driver.findElement(By.name("n01"));

        numberOneBox.sendKeys(String.valueOf(first));

    }

    @Given("I have also entered {int} into the calculator")
    public void i_have_also_entered_into_the_calculator(Integer second) {
        // Write code here that turns the phrase above into concrete actions
        WebElement numberOneBox = driver.findElement(By.name("n02"));

        numberOneBox.sendKeys(String.valueOf(second));

    }



    @Then("the result should be {int} on the screen")
    public void the_result_should_be_on_the_screen(Integer expected) {
        String actual;
        WebElement calculationResult = driver.findElement(By.name("answer"));
        actual = calculationResult.getAttribute("value");
        assertEquals(String.valueOf(expected),actual);
        driver.quit();
        // Write code here that turns the phrase above into concrete actions

    }


    @When("I press Find Addition")
    public void iPressFindAddition() {
        WebElement findAddition = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/table[2]/tbody/tr[1]/td[2]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td/form/p[4]/input"));
        findAddition.click();
    }



}
