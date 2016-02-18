package com.yourcompany.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;

/**
 * Created by mehmetgerceker on 12/21/15.
 */

public class GuineaPigPage extends PageBase {


    @FindBy(id = "h1Text")
    private WebElement h1Text;

    @FindBy(id = "unchecked_checkbox")
    private WebElement uncheckedCheckbox;

    @FindBy(id = "checked_checkbox")
    private WebElement checkedCheckbox;

    @FindBy(id = "i_am_a_link")
    private WebElement theActiveLink;

    @FindBy(id = "i_am_a_textbox")
    private WebElement textInput;

    @FindBy(id = "your_comments")
    private WebElement yourCommentsSpan;

    @FindBy(id = "fbemail")
    private WebElement emailTextInput;

    @FindBy(id = "comments")
    private WebElement commentsTextInput;

    @FindBy(id = "submit")
    private WebElement submitButton;

    public static GuineaPigPage getPage(WebDriver driver) {
        return PageFactory.initElements(driver, GuineaPigPage.class);
    }

    public void checkUncheckedSwitch() {
        setCheckSwitchState(this.uncheckedCheckbox, true);
    }

    public boolean getUncheckedSwitchState() {
        return getSwitchState(this.checkedCheckbox);
    }

    public void uncheckCheckedSwitch() {
        setCheckSwitchState(this.checkedCheckbox, false);
    }

    public boolean getCheckedSwitchState() {
        return getSwitchState(this.checkedCheckbox);
    }

    public void enterCommentText(String text) {
        this.commentsTextInput.click();
        setTextInputValue(this.commentsTextInput, text);
    }
    public void clickCommentText() {
        this.commentsTextInput.click();
    }
    public void clearCommentText() {
        this.commentsTextInput.clear();
    }
    public String getCommentText() {
        return this.commentsTextInput.getAttribute("value");
    }
    public void submitForm() {
        clickButton(this.submitButton);
    }
    public String getSubmittedCommentText() {
        return this.yourCommentsSpan.getText();
    }

    public void enterEmailText(String email) {
        setTextInputValue(this.emailTextInput, email);
    }
    public void clickEmailText() {
        this.emailTextInput.click();
    }
    public void clearEmailText() {
        this.emailTextInput.clear();
    }
    public String getEmailText() {
        return this.emailTextInput.getText();
    }

    /**
     * This method only work for this page and assumes the app supports keyboard hide on click-away.
     * In appium there's no way of doing this with a generalized method for iOS as of yet.
     */
    public void hideKeyboard(){
        this.h1Text.click();
    }

}

