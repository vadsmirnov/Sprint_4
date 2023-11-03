import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pageObject.MainPage;
import pageObject.OrderPage;
import pageObject.RentPage;




@RunWith(Parameterized.class)
public class ScooterOrderingTest extends WorkingBrowserTest {
    private final String name;
    private final String surname;
    private final String address;
    private final String metro;
    private final String number;
    private final String date;
    private final String comment;


    public ScooterOrderingTest(String name, String surname, String address, String metro, String number, String date, String comment) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metro = metro;
        this.number = number;
        this.date = date;
        this.comment = comment;
    }
    @Parameterized.Parameters
    public static Object[][] getInput(){
        return new Object[][]{
                {"Тест","Тестов","Москва","Черкизовская", "89999999999","25.10.2023", "Комментарий"},
                {"Тест","Тестов","Москва","Сокольники", "88888888888","25.09.2023","Комментарий2!"}
        };
    }


    @Test
    public void scooterOrderingByHeaderOrderButton() {

        MainPage page = new MainPage(driver);
        page.openSite();
        page.clickCookieButton();
        page.clickHeaderOrderButton();

        OrderPage pageOrder = new OrderPage(driver);
        pageOrder.sendFirstName(name);
        pageOrder.sendLastName(surname);
        pageOrder.sendDeliveryAddress(address);
        pageOrder.selectMetroStation(metro);
        pageOrder.sendDeliveryPhoneNumber(number);
        pageOrder.clickNextButton();

        RentPage pageRent = new RentPage(driver);
        pageRent.sendRentalDate(date);
        pageRent.setRentalTime();
        pageRent.clickCheckBoxColourBlackPearl();
        pageRent.sendComment(comment);
        pageRent.clickOrderButton();
        pageRent.clickOrderButtonYes();
        pageRent.isModalOrderWindowDisplayed();
        Assert.assertFalse("Ошибка, окно заказа не появилось!", pageRent.isModalOrderWindowDisplayed());

    }

    @Test
    public void scooterOrderingByMiddleOrderButton() {
        MainPage page = new MainPage(driver);
        page.openSite();
        page.clickCookieButton();
        page.clickHeaderOrderButton();

        OrderPage pageOrder = new OrderPage(driver);
        pageOrder.sendFirstName(name);
        pageOrder.sendLastName(surname);
        pageOrder.sendDeliveryAddress(address);
        pageOrder.selectMetroStation(metro);
        pageOrder.sendDeliveryPhoneNumber(number);
        pageOrder.clickNextButton();

        RentPage pageRent = new RentPage(driver);
        pageRent.sendRentalDate(date);
        pageRent.setRentalTime();
        pageRent.clickCheckBoxColourBlackPearl();
        pageRent.sendComment(comment);
        pageRent.clickOrderButton();
        pageRent.clickOrderButtonYes();
        pageRent.isModalOrderWindowDisplayed();
        Assert.assertFalse("Ошибка, окно заказа не появилось!", pageRent.isModalOrderWindowDisplayed());


    }
}

