package com.yourcompany.Tests;

import com.yourcompany.Pages.GuineaPigPage;
import org.junit.Test;
import org.openqa.selenium.InvalidElementStateException;

import static org.junit.Assert.*;

/**
 * Created by mehmetgerceker on 12/22/15.
 */

public class SampleSauceSwitchTest extends SampleSauceTestBase {

    public SampleSauceSwitchTest(String os,
                                   String version, String browser, String deviceName, String deviceOrientation) {
        super(os, version, browser, deviceName, deviceOrientation);
    }

    /**
     * Runs a simple test verifying the checked checkbox state
     *
     * @throws InvalidElementStateException
     */
    @Test
    public void verifyUncheckedSwitchInputTest() throws InvalidElementStateException {

        // get page object
        GuineaPigPage page = GuineaPigPage.getPage(driver);

        /*
         checkUncheckedSwitch is an exposed "service",
             which interacts with the email input field element by sending text to it.
        */
        page.checkUncheckedSwitch();

        /*
         Assertions should be part of test and not part of Page object.
         Each test should be verifying one piece of functionality (atomic testing)
        */
        assertEquals(page.getUncheckedSwitchState(), true);

    }

    /**
     * Runs a simple test verifying the checked checkbox state
     *
     * @throws InvalidElementStateException
     */
    @Test
    public void verifyCheckedSwitchInputTest() throws InvalidElementStateException {

        //get the page object
        GuineaPigPage page = GuineaPigPage.getPage(driver);

        /*
         checkUncheckedSwitch is an exposed "service",
             which interacts with the email input field element by sending text to it.
        */
        page.uncheckCheckedSwitch();

        /*
         Assertions should be part of test and not part of Page object.
         Each test should be verifying one piece of functionality (atomic testing)
        */
        assertEquals(page.getCheckedSwitchState(), false);

    }
}