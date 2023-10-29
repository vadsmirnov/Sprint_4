package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

/** Элементы главной страницы сайта: */
public class Main {
    public Main(WebDriver driver) {
        Main.driver = driver;
    }

    private static WebDriver driver;

    /** Кнопка "да все привыкли" сообщение о куки */
    private final By cookieButton = By.id("rcc-confirm-button");

    /** Локатор кнопки "Заказать" в шапке сайта */
    private By headerOrderButton = By.className("Button_Button__ra12g");

    /** Локатор кнопки "Заказать" в середине сайта */
    private By middleOrderButton = By.className("Button_Middle__1CSJM");

    /** Массив локаторов кнопок для "Вопросы о важном" */
    private static final String[] dropDownQuestionsArray = new String[]{
            "accordion__heading-0",
            "accordion__heading-1",
            "accordion__heading-2",
            "accordion__heading-3",
            "accordion__heading-4",
            "accordion__heading-5",
            "accordion__heading-6",
            "accordion__heading-7"};

    /** Массив локаторов панелей с ответом */
    private static final String[] dropDownAnswersArray = new String[]{
            "accordion__panel-0",
            "accordion__panel-1",
            "accordion__panel-2",
            "accordion__panel-3",
            "accordion__panel-4",
            "accordion__panel-5",
            "accordion__panel-6",
            "accordion__panel-7"};

    /** Методы для работы с элементами главной страницы.*/


    /** Открыть сайт */
    public final Main openSite() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        return this;
    }

    /** Нажать на кнопку "да все привыкли" */
    public Main clickCookieButton() {
        driver.findElement(cookieButton).click();
        return this;
    }

    /** Нажать на кнопку "Заказать" в шапке сайта */
    public Main clickHeaderOrderButton() {
        driver.findElement(headerOrderButton).click();
        return this;
    }

    /** Нажать на кнопку "Заказать" в середине сайта */
    public Main clickMiddleOrderButton() {
        driver.findElement(middleOrderButton).click();
        return this;
    }

    /** Прокрутка главной страницы до последнего элемента списка */
    public Main scrollPageToEndOfList() {
        WebElement lastQuestionArrow = driver.findElement(By.id(dropDownQuestionsArray[7]));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", lastQuestionArrow);
        return this;
    }

    /** Нажать на стрелку выпадающего списка */
    public static void clickQuestionArrow(int questionNumber) {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(By.id(dropDownQuestionsArray[questionNumber])));
        driver.findElement(By.id(dropDownQuestionsArray[questionNumber])).click();
    }

    /** Проверка текста в открытой панели */
    public static void checkTextInOpenPanel(String expectedText, int answerNumber) {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id(dropDownAnswersArray[answerNumber])));
        String answerText = driver.findElement(By.id(dropDownAnswersArray[answerNumber])).getText();
        assertEquals(expectedText, answerText);
    }

    /** Нажать на кнопку вопроса */
    public Main clickQuestionButton(String questionButtonLocator) {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(By.id(questionButtonLocator)));
        driver.findElement(By.id(questionButtonLocator)).click();
        return this;
    }
}

