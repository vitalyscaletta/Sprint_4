package ru.qa.scooters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmationWindow {
    public static final By YES_BUTTON = By.xpath("//button[text()='Да']");
    public static final By CONFIRM_TITLE = By.xpath("//div[@class='Order_Modal__YZ-d3']/div[@class='Order_ModalHeader__3FDaJ']");

    private WebDriver driver;

    public ConfirmationWindow(WebDriver driver) {
         this.driver = driver;
    }
    // клик по кнопке "Да"
    public void clickYesConfirmButton() {
        driver.findElement(YES_BUTTON).click();
    }
    // вернуть текст заголовка окна подтверждения заказа
    public String getConfirmTitle() {
        return driver.findElement(CONFIRM_TITLE).getText();
    }
    }

