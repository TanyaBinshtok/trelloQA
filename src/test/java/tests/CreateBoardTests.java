package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateBoardTests extends BaseTest{

    @BeforeMethod
    public void preconditions() {
        //go to https://trello.com/u/juliagordyin/boards
        app.goToBoardPage((userDTO.getEmail().split("@"))[0]);
     //   System.out.println(((userDTO.getEmail().split("@"))[0]));
        if(!app.getLoginHelper().isElementWorkspaceExist()) {
            app.toMainPage();
            app.getLoginHelper().login(userDTO);
        }
    }

    @Test
    public void createBoardPositive() {
        String boardName = randomUtils.createString(5);
        app.getCreateBoardHelper().createNewBoard(boardName);
        Assert.assertTrue(app.getCreateBoardHelper().validateTitleBoardName(boardName));
    }
}