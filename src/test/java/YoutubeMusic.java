import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;


public class YoutubeMusic {
    WebDriver driver;
    static WebDriverWait wait;
    @Given("user Open browser")
    public void iOpenBrowser() {
        final String dir = System.getProperty("user.dir");
        System.out.println("current dir = " + dir);
        System.setProperty("webdriver.chrome.driver", dir+"/driver/chromedriver 2");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @And("user go Youtube Music")
    public void openYoutubeMusic() throws InterruptedException {
        driver.get("https://music.youtube.com/");
        Thread.sleep(1000);
    }

    @And("user go to Explore menu")
    public void exploreMusic() {
        driver.findElement(By.cssSelector("[tab-id='FEmusic_explore'] > .tab-title")).isDisplayed();
        driver.findElement(By.cssSelector("[tab-id='FEmusic_explore'] > .tab-title")).click();
    }

    @And("user choose 1 playlist")
    public void choosePlaylist() {
        driver.findElement(By.xpath("//a[.='Dalan Liyane']")).isDisplayed();
        driver.findElement(By.xpath("//a[.='Dalan Liyane']")).click();
        driver.close();
        driver.quit();
    }

    @When("user click play button")
    public void clickPlayButton(){
        driver.findElement(By.xpath("//ytmusic-two-row-item-renderer[1]//yt-icon[@class='icon style-scope ytmusic-play-button-renderer']")).isDisplayed();
        driver.findElement(By.xpath("//ytmusic-two-row-item-renderer[1]//yt-icon[@class='icon style-scope ytmusic-play-button-renderer']")).click();
    }

    @Then("user success play the video")
    public void assertVideoPage(){
        driver.findElement(By.cssSelector("[for='automix']")).isDisplayed();
    }
}





