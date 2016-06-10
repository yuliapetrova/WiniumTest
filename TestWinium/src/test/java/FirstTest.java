import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.os.CommandLine;
import org.openqa.selenium.os.WindowsUtils;
import org.openqa.selenium.winium.WiniumDriver;
import org.openqa.selenium.winium.DesktopOptions;
import org.testng.annotations.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;




/**
 * Created by Iuliia_Petrova on 5/30/2016.
 */

public class FirstTest {

    WebDriver driver;
    DesktopOptions options;

    @BeforeSuite
    public void SetUpEnvironment() throws IOException {
        new ProcessBuilder("C:\\Selenium\\Winium.Desktop.Driver.exe").start();

            this.options = new DesktopOptions();
            this.options.setApplicationPath("C:\\Windows\\System32\\notepad.exe");
            try {
                this.driver = new WiniumDriver(new URL("http://localhost:9999"), options);
            } catch (MalformedURLException e) {
                e.fillInStackTrace();
        }
    }

    @Test
    public void testNotepad() throws InterruptedException, IOException {
        WebElement window = driver.findElement(new By.ByClassName("Notepad"));
        window.findElement(By.className("Edit")).sendKeys("This is test");
        Thread.sleep(2000);
    }

    @Test
    public void testNotepad2() throws InterruptedException, IOException {
        WebElement window = driver.findElement(new By.ByClassName("Notepad"));
        window.findElement(By.className("Edit")).sendKeys("This is another test");
        Thread.sleep(2000);
        //   window.findElement(By.name("Don't Save")).click();
    }

    @Test
    public void testNotepad3() throws InterruptedException, IOException {
        WebElement window = driver.findElement(new By.ByClassName("Notepad"));
        window.findElement(By.name("File")).click();
        window.findElement(By.name("Save As...")).click();
        Thread.sleep(2000);
        WebElement window2 = driver.findElement(new By.ByClassName("#32770"));
        window2.click();
    //    window2.findElement(new By.ByClassName("Edit")).sendKeys("kdlfklsd");
        //   window.findElement(By.name("Don't Save")).click();
    }

    @AfterSuite
    public void TearDown() throws IOException {
          driver.close();
    }
}