package ru.qa.scooters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    public static final String PAGE_URL = "https://qa-scooter.praktikum-services.ru/";
    public static final By ORDER_BUTTON_TOP = By.className("Button_Button__ra12g"); // Кнопка «Заказать» вверху страницы
    public static final By ORDER_BUTTON_BOTTOM = By.className("Button_Button__ra12g Button_Middle__1CSJM");// Кнопка «Заказать» внизу страницы
    public static final By ACCORDION_ITEM = By.className("accordion__item");// Выпадающий список в разделе «Вопросы о важном»
    public static final By ACCORDION_ITEM_TEXT = By.xpath("//div[@data-accordion-component='AccordionItemPanel']");// Ответы на вопросы из списка "Вопросы о важном"

    private WebDriver driver;


    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage openPage() {
        driver.get(PAGE_URL);
        return this;
    }

    // кликнуть по верхней кнопке Заказать
    public void clickOrderButtonTop() {
        driver.findElement(ORDER_BUTTON_TOP).click();
    }

    // кликнуть по нижней кнопке Заказать
    public void clickOrderButtonBottom() {
        driver.findElement(ORDER_BUTTON_BOTTOM).click();
    }

    // кликнуть по вопросам из списка "вопросы о важном"
    public void clickAccordionItem(int index) {
        driver.findElements(ACCORDION_ITEM).get(index).click();
    }

    // Получить текст ответа на вопрос из списка "Вопросы о важном"
    public String getAccordionItemText(int index) {
        return driver.findElements(ACCORDION_ITEM_TEXT).get(index).getText();
    }

}
