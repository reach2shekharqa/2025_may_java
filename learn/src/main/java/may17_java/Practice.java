package may17_java;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.yaml.snakeyaml.Yaml;

public class Practice {

    private static WebDriver driver;

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws FileNotFoundException {

        

        String filePath = System.getProperty("user.dir") + "\\learn\\src\\main\\java\\may17_java\\" + "login.yaml";

        InputStream ip = new FileInputStream(filePath);

        Yaml yaml = new Yaml();

        Map<String, Object> fullData = yaml.load(ip);

        Map<String, Object> loginData = (Map<String, Object>) fullData.get("login");

        driver = new ChromeDriver();

        for (Map.Entry<String, Object> realdata : loginData.entrySet()) {

            System.out.println(realdata.getKey());
            Map<String, Object> data = (Map<String, Object>) realdata.getValue();

            String type = (String) data.get("type");
            String locator = (String) data.get("locator");
            String locatorType = (String) data.get("locatorType");
            String value = (String) data.get("value");
            String optionsLocator = (String) data.get("optionsLocator");

            By by = getBy(locatorType, locator);

            WebElement element = driver.findElement(by);

            switch (type.toLowerCase()) {
                case "textbox":

                    element.sendKeys(value);

                    break;

                default:
                    throw new UnsupportedOperationException("unsupported type" + type);
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
                throw new IllegalArgumentException("unsupported locator type " + locatorType);
        }

    }

}
