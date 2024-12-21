import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.qa.scooters.MainPage;
import ru.qa.scooters.OrderPage;

import java.sql.Driver;

import static ru.qa.scooters.EnvConfig.PAGE_URL;

public class OrderTest {

    private WebDriver driver;

    @Before
    public void before(){
        driver = new ChromeDriver();
    }
    @Test
    // когда нажимаешь на верхнюю кнопку "Заказать", открывается окно заказа
    public void testTopButtonOpensOrderWindow() {
        MainPage mainPage = new MainPage(driver);
        driver.get(PAGE_URL);

        mainPage.clickOrderButtonTop();

        OrderPage orderWindow = new OrderPage(driver);

        // Проверяем, что заголовок окна заказа равен "Для кого самокат"
        String expectedTitle = "Для кого самокат";
        String actualTitle = orderWindow.getOrderWindowTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        // Проверяем, что плейсхолдер firstNameField равен "* Имя"
        String expectedPlaceholder = "* Имя";
        String actualPlaceholder = orderWindow.getFirstNameFieldPlaceholder();
        Assert.assertEquals(expectedPlaceholder, actualPlaceholder);
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
