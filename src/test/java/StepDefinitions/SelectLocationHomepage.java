package StepDefinitions;

import Swiggy_PO.AhmadabadLocation_PO;
import Swiggy_PO.Cart_PO;
import Swiggy_PO.PizzaHut_PO;
import Swiggy_PO.VittleBox_PO;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class SelectLocationHomepage{
    WebDriver driver;
    String appURL;

@Before
    public void browserSetup(){
        System.out.println("I am in the browser Setup");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\mabassra.SCT\\Downloads\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();


        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();


//New way of driver setup
//        WebDriverManager.chromedriver().setup();
//        driver=new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
//-----------------------------------------------------------------------
// Selenium grid setup
//        EdgeOptions op = new EdgeOptions();
//        WebDriver driver =new RemoteWebDriver(new URL("http://localhost:4444"),op);
//        ChromeOptions opt = new ChromeOptions();
//        WebDriver driver =new RemoteWebDriver(new URL("http://localhost:4444"),opt);
//        ----------------------------------------------------------------------------
    }
    @After
    public void tearDown() {
        AhmadabadLocation_PO teardowndriver = new AhmadabadLocation_PO(driver);
        teardowndriver.cleanupDriver();

    }
    @Given("User navigate to  Swiggy web application {string}")
    public void user_navigate_to_Swiggy_web_application(String string) throws MalformedURLException {
            System.out.println("I am in first test class Given");

        appURL = "https://www.swiggy.com/";
        driver.get(appURL);

        driver.getTitle();
        String SwiggyTitle = driver.getTitle();
        System.out.println(SwiggyTitle);
    }
    @When("As a Swiggy application user I click on to AhmadAbad")
    public void as_a_Swiggy_application_user_I_click_on_to_AhmadAbad() {
        // Write code here that turns the phrase above into concrete actions
        AhmadabadLocation_PO AhmadabadLocation = new AhmadabadLocation_PO(driver);
        AhmadabadLocation.Select_Ahmadabad();


    }

    @And("User lands onto  I click onto Swiggy Ahmadabad Homepage")
    public void user_lands_onto_I_click_onto_Swiggy_Ahmadabad_Homepage() {
        // Write code here that turns the phrase above into concrete actions
        AhmadabadLocation_PO AhmadabadLocation = new AhmadabadLocation_PO(driver);
        AhmadabadLocation.AhmadabadOnlineFoodTitle();
    }

    @And("User clicks onto Pizza Hut")
    public void user_clicks_onto_Pizza_Hut() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        PizzaHut_PO PizzaHut = new PizzaHut_PO(driver);
        PizzaHut.setSelectPizza();
        Thread.sleep(3000);
    }

    @Then("User sets the location as Ahmadabad")
    public void user_sets_the_location_as_Ahmadabad() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        PizzaHut_PO PizzaHut = new PizzaHut_PO(driver);
        PizzaHut.ClickLocationField();
        Thread.sleep(3000);
        PizzaHut.SearchforAhmadabad();
        Thread.sleep(3000);
        PizzaHut.AhmadabadLocationSelect();
        Thread.sleep(3000);
//        String ActalalTitle = driver.getTitle();
//
//        //SoftAssert softAssert = new SoftAssert();
//        String ExpectedTitle = "Pizza Hut | Home delivery | Order online | Kudasan Road Gandhinagar Ahmedabad";
//        Assert.assertEquals(ExpectedTitle, ActalalTitle);
        System.out.println(driver.getTitle());

    }

    @When("user search {string} in search box and click enter")
    public void user_search_in_search_box_and_click_enter(String string) throws InterruptedException {

        VittleBox_PO VittleBox = new VittleBox_PO(driver);
        VittleBox.SearchButton();


        VittleBox.searchParameters();


        Thread.sleep(3000);


    }

    @And("user can see Vitalbox in options and clicks onto it")
    public void user_can_see_Vitalbox_in_options_and_clicks_onto_it() throws InterruptedException {
        VittleBox_PO VittleBox = new VittleBox_PO(driver);

        VittleBox.selctVittleBox();


        Thread.sleep(2000);
    }

    @And("User lands onto VittleBox Foods and clicks onto {string} to add it to the cart")
    public void user_lands_onto_VittleBox_Foods_and_clicks_onto_to_add_it_to_the_cart(String string) throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        VittleBox_PO VittleBox = new VittleBox_PO(driver);
        System.out.println("select Maxican Hot Pot");
        VittleBox.selectMaxicanHotPot();

        System.out.println("select first Contirue for Regular on jain");
        VittleBox.conontinueWithRegular();

        Thread.sleep(2000);


        System.out.println("select first Add item");
        VittleBox.AddtoTheCart();
        Thread.sleep(2000);

    }

    @Then("the user can see {string} in the cart")
    public void then_the_user_can_see_in_the_cart(String string) {

        System.out.println("select the cart");
        Cart_PO CartVerification = new Cart_PO(driver);
        CartVerification.checktheCart();



        System.out.println("Maxican Hot Pot present");
        CartVerification.MaxicanHotPotPresent();

    }

}
