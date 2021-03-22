package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertEquals;

public class StepDefinitions {
    ChromeDriver driver;

    @Given("I have opened the web-application")
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
    public void the_result_should_be_on_the_screen(Integer expected) throws InterruptedException {
        String actual;
        WebElement calculationResult = driver.findElement(By.name("answer"));
        actual = calculationResult.getAttribute("value");
        assertEquals(String.valueOf(expected),actual);
        Thread.sleep(4000);
        driver.quit();
        // Write code here that turns the phrase above into concrete actions

    }


    @When("I press Find Addition")
    public void iPressFindAddition() {
        WebElement findAddition = driver.findElement(By.cssSelector("input[type=button"));
        findAddition.click();
    }

// ******************** GROLLS ******************************
    @Given("I have opened grolls")
    public void iHaveOpenedGrolls() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.grolls.se/helags-t-shirt--svart1100099.html");
        driver.manage().window().maximize();
        Thread.sleep(4000);  // Let the user actually see something!
    }

    @And("I have chosen the <size> i want")
    public void iHaveChosenTheSizeIWant() throws InterruptedException {

        Select chooseSize = new Select(driver.findElement(By.xpath("/html/body/div[4]/main/div[2]/div/div[1]/div[2]/div[5]/form/div[1]/div/div/div/select")));

        chooseSize.selectByValue("1426");
        Thread.sleep(2000);


    }

    @And("I have chosen the <quantity>")
    public void iHaveChosenTheQuantity() throws InterruptedException {
        WebElement addQuantity = driver.findElement(By.xpath("/html/body/div[4]/main/div[2]/div/div[1]/div[2]/div[5]/form/div[2]/div/div/div[1]/div/div/span[2]"));
        addQuantity.click();
        Thread.sleep(2000);
    }

    @When("I press Lägg i varukorg")
    public void iPressLäggIVarukorg() throws InterruptedException {

        WebElement addToBasket = driver.findElement(By.id("product-addtocart-button"));
        addToBasket.click();
        Thread.sleep(2000);
    }

    @Then("there should be <amountOfItems> in the basket")
    public void thereShouldBeAmountOfItemsInTheBasket() {
        String expected = "2";
        WebElement actual = driver.findElement(By.xpath("/html/body/div[4]/header/div[3]/div[4]/a/span/span[1]"));


        assertEquals(expected, actual.getText());
    }
}
