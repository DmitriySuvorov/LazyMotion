package initwebdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.awt.*;
import java.security.Key;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;

//Открытие браузера
public class StartFFBrowser {
    public String UrlAddr;
    public String sApp;
    public String sLogin;
    public String sPassword;
    public WebDriver driver;

    //конструктор класса, задается URL, приложение и логин/пароль пользователя
    public StartFFBrowser(String UrlAddr, String sApp, String sLogin, String sPassword) {
        this.UrlAddr = UrlAddr;
        this.sApp = sApp;
        this.sLogin = sLogin;
        this.sPassword = sPassword;
    }
    public void LoginToURLApp() {
        //задается профиль для ФФ
        System.setProperty("webdriver.gecko.driver", "C:\\dsuvorov\\projects\\geckodriver.exe");
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", "true");
        this.driver = new FirefoxDriver();
        this.driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        //идем по переданной ссылке
        this.driver.get(this.UrlAddr);
        //на разводной странице кликаем по переданному приложению
        this.driver.findElement(By.ByPartialLinkText.linkText(this.sApp)).click();
        //логинимся по переданным логином/паролем
        this.driver.findElement(By.name("SWEUserName")).sendKeys(this.sLogin);
        this.driver.findElement(By.name("SWEPassword")).sendKeys(this.sPassword);
        this.driver.findElement(By.id("s_swepi_22")).click();
    }

    public void CreateNewAdmProject()  {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    this.driver.findElement(By.xpath("//span[contains(text(),'Перемещение')]")).click();
    this.driver.findElement(By.partialLinkText("Карта сайта          [Ctrl+Shift+A]")).click();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
     this.driver.quit();
    }
}
