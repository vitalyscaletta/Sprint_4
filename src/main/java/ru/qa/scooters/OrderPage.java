package ru.qa.scooters;

import org.openqa.selenium.By;

public class OrderPage {
    public static final By NAME_INPUT = By.xpath(".//input[@placeholder='* Имя']");
    public static final By FAMILY_INPUT = By.xpath(".//input[@placeholder='* Фамилия']");
    public static final By ADDRESS_INPUT = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    public static final By METRO_INPUT = By.className("select-search__input");
    public static final By PHONE_NUMBER_INPUT = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    public static final By METRO_STATION = By.xpath("//li[@data-index='3']");
    public static final By NEXT_BUTTON = By.xpath("//button[@class=Button_Button__ra12g Button_Middle__1CSJM']");
}
