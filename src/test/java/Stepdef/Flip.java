package Stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;

public class Login {
    WebDriver driver;
    static WebDriverWait wait;
    private By webDriver;

    @Given("user Open browser")
    public void iOpenBrowser() {
        final String dir = System.getProperty("user.dir");
        System.out.println("current dir = " + dir);
        //System.setProperty("webdriver.chrome.driver", dir + "/driver/chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", dir + "/driver/geckodriver.exe");
        //driver = new ChromeDriver();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    //Switch Language
    @And("user go Flip website")
    public void goToFlipWebsite() throws  InterruptedException {
        driver.get("https://flip.id/landing");
        driver.findElement(By.xpath("//img[@alt='flip logo']")).isDisplayed();
    }

    @And("user switch language to English")
    public void switchLanguageToEnglish() throws InterruptedException{
        driver.findElement(By.xpath("//p[contains(text(),'EN')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//h3[contains(text(),'Free financial transactions, to anyone.')]")).isDisplayed();
    }

    @And("user switch back to Indonesia language")
    public void switchLanguageToIndonesia() throws InterruptedException{
        driver.findElement(By.xpath("//p[contains(text(),'ID')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//h3[contains(text(),'Bebas transaksi, ke siapa aja.')]")).isDisplayed();
    }

    //Verify cellular provider supported by Flip
    @And("user scroll to Pertanyaan Seputar Flip section")
    public void scrollToFAQ() throws InterruptedException{
        JavascriptExecutor scroll = (JavascriptExecutor) driver;
        WebElement faq = driver.findElement(By.xpath("//h2[.='Pertanyaan seputar Flip']"));
        scroll.executeScript("arguments[0].scrollIntoView();", faq);
    }

    @When("user click FAQ about virtual product in Flip")
    public void clickFaqVirtualProduct () throws InterruptedException{
        driver.findElement(By.xpath("//h3[.='Adakah layanan pembelian pulsa, paket data serta PPOB di Flip?']")).click();
    }

    @Then("user can see cellular providers supported by Flip")
    public void verifyInfoCellularProviders () throws InterruptedException{
        driver.findElement(By.xpath("//div[contains(text(),'Indosat Ooredoo, Smartfren, Telkomsel, Tri, XL')]")).isDisplayed();
    }

    //Flip-globe
    @And("user go Flip globe")
    public void goToFlipGlobe() throws  InterruptedException {
        driver.get("https://flip.id/flip-globe");
        driver.findElement(By.xpath("//img[@alt='flip logo']")).isDisplayed();
        driver.findElement(By.xpath("//a[contains(text(),'Globe')]")).isDisplayed();
    }

    @And("user choose Poundsterling Currency {string}")
    public void choosePoundsterlingCurrency(String currency) throws InterruptedException{
        driver.findElement(By.id("menu-button-5")).click();
        driver.findElement(By.xpath("//input[@class='chakra-input css-4gru8k']")).sendKeys(currency);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//p[contains(text(),'United Kingdom')]")).click();
    }

    @When("user fills amount {string} for IDR")
    public void fillsAmountMoney(String amount) throws InterruptedException{
        driver.findElement(By.cssSelector("[placeholder='Masukkan nominal dalam IDR']")).isDisplayed();
        driver.findElement(By.cssSelector("[placeholder='Masukkan nominal dalam IDR']")).sendKeys(amount);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@value='5,21']")).isDisplayed();
    }

    @Then("user can see exchange rate with fee")
    public void verifyExchangeRate() throws InterruptedException{
        driver.findElement(By.xpath("//p[contains(text(),'Kurs Saat Ini')]")).isDisplayed();
        driver.findElement(By.xpath("//p[.='1 GBP = 19.187,55 IDR']")).isDisplayed();
        driver.findElement(By.xpath("//p[contains(text(),'+ Biaya transfer via Flip')]")).isDisplayed();
        driver.findElement(By.xpath("//p[.='65.000 IDR']")).isDisplayed();
    }
}
