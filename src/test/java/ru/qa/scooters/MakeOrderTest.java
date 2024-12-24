package ru.qa.scooters;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static ru.qa.scooters.EnvConfig.PAGE_URL;
import static ru.qa.scooters.MainPage.ORDER_BUTTON_BOTTOM;

// параметризация
@RunWith(Parameterized.class)
public class MakeOrderTest {
    private WebDriver driver;
    private final String firstName;
    private final String lastName;
    private final String address;
    private final String phone;
    private final String comment;
    private final String whatButtonToClick;

    public MakeOrderTest(String firstName, String lastName, String address, String phone, String comment, String whatButtonToClick) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.comment = comment;
        this.whatButtonToClick = whatButtonToClick;
    }

    @Parameterized.Parameters
    public static Object[][] getMultiplicationData() {
        return new Object[][] {
                {"Тестовоеимя", "Тестоваяфамилия", "Тестовый адрес", "79969300001", "комментарий", "topButtonToClick"},
                {"Иван", "Иванов", "Кострома Советская 61", "79059256404", "Самокат","bodyButtonToClick"}
        };
    }

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(PAGE_URL);
    }

    @Test
    public void testOrderFormFields() {
        MainPage mainPage = new MainPage(driver);
        if (whatButtonToClick.equals("topButtonToClick")) {
            mainPage.clickOrderButtonTop();
        } else if (whatButtonToClick.equals("bodyButtonToClick")){
            WebElement element = driver.findElement(ORDER_BUTTON_BOTTOM);
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            Assert.assertTrue(element.isDisplayed());
            element.click();
        }

        OrderPage orderPage = new OrderPage(driver);

        //Кликаем на кнопку принятие Cookie
        mainPage.clickCookieButton();

        // Вводим данные в поля формы 1
        orderPage.enterFirstName(firstName);
        orderPage.enterLastName(lastName);
        orderPage.enterAddress(address);
        orderPage.clickMetroStationField();
        orderPage.chooseMetroStation();
        orderPage.enterPhone(phone);

        // Переходим к следующему шагу
        orderPage.clickNextButton();

        // Вводим данные в поля формы 2
        orderPage.clickWhenField();
        orderPage.clickWhenDate();
        orderPage.selectRentalPeriod();
        orderPage.clickBlackPearlCheckbox();
        orderPage.enterComment(comment);

        //нажимаем Заказать
        orderPage.clickOrderButton();

        ConfirmationWindow confirmationWindow = new ConfirmationWindow(driver);

        // Проверяем, что заголовок окна подтверждения заказа равен "Хотите оформить заказ?"
        String expectedTitle = "Хотите оформить заказ?\n" + " ";
        String actualTitle = confirmationWindow.getConfirmTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        //нажимаем кнопку Да
        confirmationWindow.clickYesConfirmButton();

        SuccessfulOrder successfulOrder = new SuccessfulOrder(driver);

        // Проверяем, что отображается заголовок Заказ оформлен
        String expected = "Заказ оформлен";
        String actual = successfulOrder.getSuccessfulOrderTitle();
        Assert.assertTrue("Сообщение об успешном оформлении заказа не получено", actual.contains(expected));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
