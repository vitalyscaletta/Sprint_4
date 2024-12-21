package ru.qa.scooters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage {
    public static final By NAME_INPUT = By.xpath(".//input[@placeholder='* Имя']");
    public static final By FAMILY_INPUT = By.xpath(".//input[@placeholder='* Фамилия']");
    public static final By ADDRESS_INPUT = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    public static final By METRO_INPUT = By.className("select-search__input");
    public static final By PHONE_NUMBER_INPUT = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    public static final By METRO_STATION = By.xpath("//li[@data-index='3']");
    public static final By NEXT_BUTTON = By.cssSelector("button.Button_Button__ra12g.Button_Middle__1CSJM");
    public static final By WHEN_DELIVERY_PICKER = By.cssSelector("button.Button_Button__ra12g Button_Middle__1CSJM.Button_Inverted__3IF-i");
    public static final By WHEN_DELIVERY_DAY = By.className("react-datepicker__day react-datepicker__day--026");
    public static final By RENT_PERIOD_PICKER = By.className("Dropdown-arrow");
    public static final By RENT_PERIOD_DAYS = By.xpath("//div[@class='Dropdown-menu']/div[text()='четверо суток']");
    public static final By COLOR_CHECKBOX = By.id("black");
    public static final By COMMENT_INPUT = By.cssSelector("input.Input_Input__1iN_Z.Input_Responsible__1jDKN");
    public static final By FINAL_ORDER_BUTTON = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    public static final By ORDER_WINDOW_TITLE = By.className("Order_Header__BZXOb");

    private WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

        // Получение заголовка окна заказа
        public String getOrderWindowTitle() {
            return driver.findElement(ORDER_WINDOW_TITLE).getText();
        }

        // Получение плейсхолдера поля имени
        public String getFirstNameFieldPlaceholder() {
            return driver.findElement(NAME_INPUT).getAttribute("placeholder");
        }

        // ввод в поле Имя
        public void enterFirstName(String firstName) {
            driver.findElement(NAME_INPUT).sendKeys(firstName);
        }

        // ввод в поле Фамилия
        public void enterLastName(String lastName) {
            driver.findElement(FAMILY_INPUT).sendKeys(lastName);
        }

        // ввод в поле Адрес
        public void enterAddress(String address) {
            driver.findElement(ADDRESS_INPUT).sendKeys(address);
        }

        // клик по полю Метро = открыть список
        public void clickMetroStationField() {
            driver.findElement(METRO_INPUT).click();
        }

        //выбор станции метро из списка
        public void chooseMetroStation() {
            driver.findElement(METRO_STATION).click();
        }

        // ввод в поле Телефон
        public void enterPhone(String phone) {
            driver.findElement(PHONE_NUMBER_INPUT).sendKeys(phone);
        }

        // клик по кнопке Далее
        public void clickNextButton() {
            driver.findElement(NEXT_BUTTON).click();
        }

        // клик по полю Когда привезти
        public void clickWhenField() {
            driver.findElement(WHEN_DELIVERY_PICKER).click();
        }

        // выбор даты из датапикера
        public void clickWhenDate() {
            driver.findElement(WHEN_DELIVERY_DAY).click();
        }

        // клик по полю Срок аренды
        public void clickRentalPeriodField() {
            driver.findElement(RENT_PERIOD_PICKER).click();
        }

        // выбор значения в dropdown-меню Срок аренды
        public void selectRentalPeriod() {
            clickRentalPeriodField();
            driver.findElement(RENT_PERIOD_DAYS).click();
        }

        // клик - включение необязательного чекбокса "черный жемчуг" поля Цвет самоката
        public void clickBlackPearlCheckbox() {
            driver.findElement(COLOR_CHECKBOX).click();
        }

        // ввод в поле Комментарий
        public void enterComment(String comment) {
            driver.findElement(COMMENT_INPUT).sendKeys(comment);
        }

        // клик по кнопке Заказать
        public void clickOrderButton() {
            driver.findElement(FINAL_ORDER_BUTTON).click();
        }
    }

