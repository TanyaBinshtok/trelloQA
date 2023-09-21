package tests;

import dto.UserDtoLombok;
import dto.UserDtoWith;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTestsDTOLombok extends BaseTest {

    UserDtoLombok userDtoWith = UserDtoLombok.builder()
            .email("juliagordyin@gmail.com")
            .password("123456Aa$")
            .build();

    @BeforeMethod
    public void preconditions() {
        if(app.getLoginHelper().isElementWorkspaceExist()) {
            app.getLogoutHelper().logout();
        } else {
            app.toMainPage();
        }
    }

    @Test //(priority = 1)
    public void loginPositive() {
        app.getLoginHelper().loginLombok(userDtoWith);
        Assert.assertTrue(app.getLoginHelper().isTextWorkspaceDisplays());
    }

    @Test
    public void loginNegativePasswordErrorMessage() {
        UserDtoLombok userDtoWithNegative = UserDtoLombok.builder()
                .email("juliagordyin@gmail.com")
                .password("1256Aa$")
                .build();
        app.getLoginHelper().loginLombok(userDtoWithNegative);
        Assert.assertTrue(app.getLoginHelper().isWrongPasswordTextDisplays());
    }

}