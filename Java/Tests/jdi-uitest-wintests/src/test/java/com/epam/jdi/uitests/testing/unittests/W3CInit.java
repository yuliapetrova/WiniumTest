package com.epam.jdi.uitests.testing.unittests;

import com.epam.jdi.uitests.core.settings.JDISettings;
import com.epam.jdi.uitests.testing.unittests.pageobjects.w3cSite.W3cSite;
import com.epam.jdi.uitests.win.winium.elements.composite.WebSite;
import com.epam.jdi.uitests.win.testng.testRunner.TestNGBase;
import com.epam.web.matcher.verify.Verify;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

import static com.epam.jdi.uitests.testing.unittests.pageobjects.w3cSite.W3cSite.framePage;


/**
 * Created by Roman_Iovlev on 7/13/2015.
 */
public class W3CInit extends TestNGBase {

    @BeforeSuite(alwaysRun = true)
    public static void setUp() throws Exception {
        WebSite.init(W3cSite.class);
        framePage.open();
        Verify.getFails();
        JDISettings.logger.info("Run Tests");
    }

    @AfterMethod
    public void tearDown() {
        Verify.getFails();
    }
}
