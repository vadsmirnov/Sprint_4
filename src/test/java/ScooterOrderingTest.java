import pageObject.Main;
import pageObject.Order;
import pageObject.Rent;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ScooterOrderingTest extends WorkingBrowserTest {

    /** Тест заказа через кнопку в хэдере*/
    @Test
    public void scooterOrderingByHeaderOrderButton() {
        new Main(driver)
                .openSite()
                .clickCookieButton()
                .clickHeaderOrderButton();

        new Order(driver)
                .sendFirstName("Тест")
                .sendLastName("Тест")
                .sendDeliveryAddress("Москва")
                .selectMetroStation("Черкизовская")
                .sendDeliveryPhoneNumber("89999999999")
                .clickNextButton();

        boolean isDisplayed = new Rent(driver)
                .sendRentalDate("25.10.2023")
                .setRentalTime()
                .clickCheckBoxColourBlackPearl()
                .sendComment("Комментарий")
                .clickOrderButton()
                .clickOrderButtonYes()
                .isModalOrderWindowDisplayed();
        assertTrue("Ошибка, окно заказа не появилось!", isDisplayed);
    }
    /** Тест заказа через кнопку в середине страницы */
    @Test
    public void scooterOrderingByMiddleOrderButton() {
        new Main(driver)
                .openSite()
                .clickCookieButton()
                .clickMiddleOrderButton();

        new Order(driver)
                .sendFirstName("Тест")
                .sendLastName("Тестов")
                .sendDeliveryAddress("Москва")
                .selectMetroStation("Сокольники")
                .sendDeliveryPhoneNumber("88888888888")
                .clickNextButton();

        boolean isDisplayed = new Rent(driver)
                .sendRentalDate("25.09.2023")
                .setRentalTime()
                .clickCheckBoxColourGreyDespair()
                .sendComment("Комментарий2!")
                .clickOrderButton()
                .clickOrderButtonYes()
                .isModalOrderWindowDisplayed();
        assertTrue("Ошибка, окно заказа не появилось!", isDisplayed);
    }
}
