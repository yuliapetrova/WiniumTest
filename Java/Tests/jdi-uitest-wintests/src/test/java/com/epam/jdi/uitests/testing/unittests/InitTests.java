package com.epam.jdi.uitests.testing.unittests;

import com.epam.jdi.uitests.testing.unittests.User;
import com.epam.jdi.uitests.testing.unittests.pageobjects.EpamJDIApplication;
import com.epam.jdi.uitests.win.winium.elements.composite.WebSite;
import com.epam.jdi.uitests.win.testng.testRunner.TestNGBase;
import com.epam.web.matcher.verify.Verify;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static com.epam.jdi.uitests.core.settings.JDISettings.logger;
import static com.epam.jdi.uitests.testing.notepadtests.pageobjects.NotepadApplication.mainWindow;
import static com.epam.jdi.uitests.testing.notepadtests.pageobjects.NotepadApplication.saveAsWindow;
import static com.epam.jdi.uitests.testing.unittests.pageobjects.EpamJDIApplication.login;
//import static com.epam.jdi.uitests.web.settings.WebSettings.*;


/**
 * Created by Roman_Iovlev on 7/13/2015.
 */
public class InitTests extends TestNGBase {

    @BeforeSuite(alwaysRun = true)
    public static void setUp() throws Exception {
        WebSite.init(EpamJDIApplication.class);
      //  login.submit(User.DEFAULT);
      //  Verify.getFails();
        logger.info("Run Tests");
    }

    @Test
    public static void Test() throws InterruptedException {
        mainWindow.editText.sendKeys("This is a test");
        mainWindow.fileBtn.click();
        mainWindow.saveAsBtn.click();
        saveAsWindow.fileName.sendKeys("test.txt");
        saveAsWindow.saveBtn.click();
    }

    @AfterMethod
    public void tearDown() {
        Verify.getFails();
    }
}
