package screenshot;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class CaptureScreenshot {

    WebDriver driver;
    @Test
    void takeScreenshot() throws IOException {

        //Full page
        TakesScreenshot ts=(TakesScreenshot)driver;
        File test=ts.getScreenshotAs(OutputType.FILE);
        File target=new File("screenshots/fullpage.png");
        FileUtils.copyFile(test, target);

        //Some portion of the page
        /*WebElement portion=driver.findElement(By.id("navFooter"));
        File test=portion.getScreenshotAs(OutputType.FILE);
        File target=new File("screenshots/footer.png");
        FileUtils.copyFile(test, target);*/

        //Specific element of the page
        /*WebElement ele=driver.findElement(By.id("nav-logo"));
        File test=ele.getScreenshotAs(OutputType.FILE);
        File target=new File("screenshots/logo.png");
        FileUtils.copyFile(test, target);*/


    }


    @BeforeTest
    void openurl(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in/?&ext_vrnc=hi&tag=googhydrabk1-21&ref=pd_sl_7hz2t19t5c_e&adgrpid=58355126069&hvpone=&hvptwo=&hvadid=486458755421&hvpos=&hvnetw=g&hvrand=14851241775934695075&hvqmt=e&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=1007799&hvtargid=kwd-10573980&hydadcr=14453_2154373&gclid=Cj0KCQiAweaNBhDEARIsAJ5hwbfQwmYVR7jcoQqfPFA3aa2QQtmJYPDXm4dv9h33XD3yydNdpPNcp8caArq1EALw_wcB");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterTest
    void closeBrowser() {
        driver.close();
        System.out.println("Successfully Captured");
    }
}
