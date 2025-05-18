package may17_java;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.yaml.snakeyaml.Yaml;

public class LogIn {

    private static WebDriver driver;

    public static void main(String[] args) throws FileNotFoundException, InterruptedException {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.manage().deleteAllCookies();

        driver.get("https://demoqa.com/automation-practice-form");

        enterCredentials("login.yaml", "login");

        Thread.sleep(5000);

        driver.quit();

    }

    @SuppressWarnings("unchecked")
    private static void enterCredentials(String fileName, String section)
            throws FileNotFoundException, InterruptedException {

        Yaml yaml = new Yaml();
        String filePath = "learn\\src\\main\\java\\may17_java\\" + fileName;

        InputStream ip = new FileInputStream(filePath);

        Map<String, Object> data = yaml.load(ip);

        Map<String, Object> outertopOfData = (Map<String, Object>) data.get(section);

        for (Map.Entry<String, Object> individualFeild : outertopOfData.entrySet()) {

            System.out.println(individualFeild.getKey());
            Map<String, Object> parameterOfeachIndividalFeild = (Map<String, Object>) individualFeild.getValue();

            String type = (String) parameterOfeachIndividalFeild.get("type");
            String locator = (String) parameterOfeachIndividalFeild.get("locator");
            String locatorType = (String) parameterOfeachIndividalFeild.get("locatorType");
            String value = (String) parameterOfeachIndividalFeild.get("value");
            String optionsLocator = (String) parameterOfeachIndividalFeild.get("optionsLocator");

            // create locator now deonding upn type of locator

            By by = getBy(locatorType, locator);
            WebElement element = driver.findElement(by);

            switch (type.toLowerCase()) {
                case "textbox":
                    element.clear();
                    element.sendKeys(value, Keys.TAB);
                    System.out.println("successfully entered value in the textbox");

                    break;
                case "radiobutton":
                    element.click();
                    if (element.isSelected()) {
                        System.out.println("radio button is selected.");
                    }

                    break;
                case "file":
                    String fullPath = System.getProperty("user.dir") + "\\learn\\uploadfiles\\" + value;
                    System.out.println(fullPath);
                    element.sendKeys(fullPath);

                    break;
                case "checkbox":
                    element.click();
                    if (element.isSelected()) {
                        System.out.println("check box is selected.");
                    }

                    break;
                case "dropdown":

                    Actions actions = new Actions(driver);
                    JavascriptExecutor js = (JavascriptExecutor) driver;
                    js.executeScript("arguments[0].scrollIntoView(true);", element);
                    actions.moveToElement(element).clickAndHold().perform();

                    List<WebElement> options = driver
                            .findElements(By.cssSelector(optionsLocator));

                    for (WebElement option : options) {
                        if (option.getText().equals(value)) {
                            option.click();
                            break;
                        }
                    }
                    if(!driver.findElement(By.cssSelector(".css-1uccc91-singleValue")).getText().equals(value)){
                        throw new IllegalStateException("Dropdown value not selected correctly");
                    }

                    break;
                case "textarea":
                    element.sendKeys(value);

                    break;
                case "datepicker":
                    element.click(); // open the date picker

                    // Parse value from YAML
                    String[] dateParts = value.split(" ");
                    String day = dateParts[0]; // 18
                    String month = dateParts[1]; // May
                    String year = dateParts[2]; // 1986

                    // Select month
                    WebElement monthDropdown = driver.findElement(By.className("react-datepicker__month-select"));
                    new Select(monthDropdown).selectByVisibleText(month);

                    // Select year
                    WebElement yearDropdown = driver.findElement(By.className("react-datepicker__year-select"));
                    new Select(yearDropdown).selectByVisibleText(year);

                    // Select day
                    String dayFormatted = String.format("react-datepicker__day--%03d", Integer.parseInt(day));
                    WebElement dayElement = driver.findElement(By.xpath("//div[contains(@class, '" + dayFormatted
                            + "') and not(contains(@class, 'outside-month'))]"));
                    dayElement.click();

                    System.out.println("Date selected successfully: " + value);

                    break;

                default:
                    throw new UnsupportedOperationException("Unsupported type: " + type);
            }

        }

    }

    private static By getBy(String locatorType, String locator) {

        switch (locatorType.toLowerCase()) {
            case "css":

                return By.cssSelector(locator);

            case "xpath":
                return By.xpath(locator);

            case "id":
                return By.id(locator);

            default:
                throw new IllegalArgumentException("unsupported locator type" + locatorType);
        }

    }

}
