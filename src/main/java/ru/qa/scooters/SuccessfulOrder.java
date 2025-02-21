package ru.qa.scooters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SuccessfulOrder {
    public static final By SUCCESSFUL_ORDER_TITLE = By.xpath("//div[contains(@class, 'Order_ModalHeader__3FDaJ') and text()='Заказ оформлен']");//заголовок 'Заказ оформлен'
    private WebDriver driver;



    public SuccessfulOrder (WebDriver driver) {
        this.driver = driver;
    }

    // получить заголовок
    public String getSuccessfulOrderTitle() {
        return driver.findElement(SUCCESSFUL_ORDER_TITLE).getText();
    }
}
