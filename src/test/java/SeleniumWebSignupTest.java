import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class SeleniumWebSignupTest {
    private WebDriver driver;

    //@BeforeClass
    @BeforeTest
    public void setUp() {
        // Using WebDriverManager to automatically manage the ChromeDriver version
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // Open your Selenium Demo page URL
        driver.get("https://selenium-blog.herokuapp.com");

        //Test 1.verify the user input the right URL and he is on the right webpage
        if (driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com"))
            //pass
            System.out.println("Correct Webpage");
        else
            //fail
            System.out.println("Wrong webpage");
    }

    // Method to click the signup button
    private void clickSignupButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/a[2]"))).click();
    }

    @Test(priority = 0)
    public void negativeSignUp() {

        // Wait for the signup button to be clickable and then click it
        clickSignupButton();
        // Input data into the signup form
        //Test 3.verify that user cannot signup with username less than 3 characters
        driver.findElement(By.id("user_username")).sendKeys("u1");
        //Test 4.verify user cannot signup with invalid email address
        driver.findElement(By.id("user_email")).sendKeys("ujunwa27@mailinator");
        //Test 5.verify user cannot login password less than or equal to one character
        driver.findElement(By.id("user_password")).sendKeys("a");
        // Submit the form
        driver.findElement(By.id("submit")).click();
    }

    @Test(priority = 1)
    public void blankStart() {
       //Open your Selenium Demo page URL
        driver.get("https://selenium-blog.herokuapp.com");
        //Test 1.verify the user input the right URL and he is on the right webpage
        if(driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com"))
        //pass
        System.out.println("Correct Webpage");
        else
        //fail
        System.out.println("Wrong webpage");


        // Wait for the signup button to be clickable and then click it
        clickSignupButton();
        // Input data into the signup form
        //Test 6a.verify that user cannot signup with blank username
        driver.findElement(By.id("user_username")).sendKeys("");
        //Test 6b.verify user cannot signup with blank email address
        driver.findElement(By.id("user_email")).sendKeys("");
        //Test 6c.verify user cannot login with blank password
        driver.findElement(By.id("user_password")).sendKeys("");
        // Submit the form
        driver.findElement(By.id("submit")).click();
    }

    @Test(priority = 2)
    public void positiveStart() {

        //Open your Selenium Demo page URL
        driver.get("https://selenium-blog.herokuapp.com");
        //Test 1.verify the user input the right URL and he is on the right webpage
        if(driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com"))
            //pass
            System.out.println("Correct Webpage");
        else
            //fail
            System.out.println("Wrong webpage");


        // Wait for the signup button to be clickable and then click it
        clickSignupButton();
        // Input data into the signup form
        //Test 7a.verify that user can signup with valid username
        driver.findElement(By.id("user_username")).sendKeys("uj9300");
        //Test 7b.verify user cannot signup with valid email address
        driver.findElement(By.id("user_email")).sendKeys("ujunwa9300@mailinator.com");
        //Test 7c verify user cannot signup with valid password
        driver.findElement(By.id("user_password")).sendKeys("admin980");
        // Submit the form
        driver.findElement(By.id("submit")).click();
    }

    @Test(priority = 3)
    public void clickMeaghanItem() {
        // Click on the meaghan item on the list page
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1]"))).click();

        // Test 2 verify that when the user clicks on the signup button, he is redirected to the signup page
        String expectedUrl = "https://selenium-blog.herokuapp.com/users/1";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrl))
            //pass
            System.out.println("Correct Webpage");
        else
            //fail
            System.out.println("Wrong webpage");
    }


    @Test(priority = 4)
    public void verifyItem() {
        // Confirm a specific element on the user page is present
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[1]/div/div/div[1]/a"))).click();

        //Test 8.Confirm that the page title is Alpha Blog
        String expectedUrl = "https://selenium-blog.herokuapp.com/signup";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrl))
            //pass
            System.out.println("Correct Title Page");
        else
            //fail
            System.out.println("Wrong Title Page");

    }

    @Test(priority = 5)
    public void logoutSuccessfully() {
        // Log out
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a"))).click();
        //Test 9. verify that when the user logout, he/she is directed back to the home page
        String expectedTitle = "AlphaBlog";
        String actualTitle = driver.getTitle();
        if (actualTitle.contains(expectedTitle))
            //pass
            System.out.println("Correct Webpage");
        else
            //fail
            System.out.println("Wrong webpage");
    }


    @AfterTest
    public void closeBrowser() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }

}