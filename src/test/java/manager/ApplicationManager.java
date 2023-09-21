package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

    WebDriver driver;
    LoginHelper loginHelper;
    LogoutHelper logoutHelper;
    CreateBoardHelper createBoardHelper;

    public void init() {
        driver = new ChromeDriver();
        logger.info("navigate to the page: " + "https://trello.com/");
        driver.navigate().to("https://trello.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginHelper = new LoginHelper(driver);
        logoutHelper = new LogoutHelper(driver);
        createBoardHelper = new CreateBoardHelper(driver);
    }

    public void tearDown() {
        logger.info("tear down");
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    } // better to comment - or to leave and to use only in the src/test/java/start/BaseTest.java


    public LoginHelper getLoginHelper() {
        return loginHelper;
    }

    public LogoutHelper getLogoutHelper() {
        return logoutHelper;
    }

    public CreateBoardHelper getCreateBoardHelper() {
        return createBoardHelper;
    }

    public void toMainPage() {
        logger.info("navigate to the page: " + "https://trello.com/");
        driver.navigate().to("https://trello.com/");
    }

    public void goToBoardPage(String emailBeforeDog) {
        // https://trello.com/u/juliagordyin/boards
        logger.info("navigate to the page: " + "https://trello.com/u/" + emailBeforeDog + "/boards");
        driver.navigate().to("https://trello.com/u/" + emailBeforeDog + "/boards");
    }
}
