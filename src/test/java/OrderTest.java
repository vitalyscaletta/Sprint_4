import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.qa.scooters.MainPage;

import java.sql.Driver;

public class OrderTest {

    @Before
    public void before(){
        driver = new ChromeDriver();
        MainPage = new MainPage(Driver);
    }
}
