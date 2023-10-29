package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Rent {
    WebDriver driver;

    /** Локаторы данных страницы "Про аренду" */

    /**Локатор поля "Когда привезти самокат"*/
    private final By rentalDateField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    /** Локатор поля "Срок аренды" */
    private final By rentalTimeField = By.className("Dropdown-placeholder");
    /** Локатор списка срока аренды */
    private final By rentalTime = By.xpath(".//*[(@role ='option' and text()='трое суток')]");
    /** Локатор цвета самоката "Черный жемчуг" */
    private final By checkBoxColourBlackPearl = By.xpath(".//input[@id='black']");
    /** Локатор цвета самоката "Серая безысходность"*/
    private final By checkBoxColourGreyDespair = By.xpath(".//input[@id='grey']");
    /** Локатор поля "Комментарий для курьера"*/
    private final By commentField = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    /** Локатор кнопки "Заказать"*/
    private final By orderButton = By.xpath(".//button[(@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать')]");
    /** Локатор кнопки "Да" оформления заказа*/
    private final By orderButtonYes = By.xpath(".//*[@id='root']/div/div[2]/div[5]/div[2]/button[2]");
    /** Локатор модального окна*/
    private final By modalOrderWindow = By.xpath(".//div[contains(@class, 'Order_ModalHeader')]");
    /** Модальное окно "Заказ Оформлен"*/
    public boolean isModalOrderWindowDisplayed() {
        return driver.findElement(modalOrderWindow).isDisplayed();
    }

    /** Конструктор класса */
    public Rent(WebDriver driver) {
        this.driver = driver;
    }

    /** Методы для работы с элементами страницы аренды */
    /** Ввод даты доставки*/
    public Rent sendRentalDate(String date) {
        driver.findElement(rentalDateField).sendKeys(date);
        driver.findElement(rentalDateField).sendKeys(Keys.ENTER);
        return this;
    }

    /** Ввод срока аренды*/
    public Rent setRentalTime() {
        driver.findElement(rentalTimeField).click();
        driver.findElement(rentalTime).click();
        return this;
    }

    /** Выбор цвета самоката "Черный жемчуг"*/
    public Rent clickCheckBoxColourBlackPearl() {
        driver.findElement(checkBoxColourBlackPearl).click();
        return this;
    }

    /** Выбор цвета самоката "Серая безысходность"*/
    public Rent clickCheckBoxColourGreyDespair() {
        driver.findElement(checkBoxColourGreyDespair).click();
        return this;
    }

    /** Ввод комментария для курьера*/
    public Rent sendComment(String userComment) {
        driver.findElement(commentField).sendKeys(userComment);
        return this;
    }

    /** Нажать на кнопку "Заказать"*/
    public Rent clickOrderButton() {
        driver.findElement(orderButton).click();
        return this;
    }

    /** Нажать на кнопку "Да" оформления заказа*/
    public Rent clickOrderButtonYes() {
        driver.findElement(orderButtonYes).click();
        return this;
    }
}
