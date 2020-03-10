package testcase;

import org.junit.jupiter.api.*;
import page.LoginPage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LoginTest {

    private LoginPage loginPage = new LoginPage();

    @BeforeAll
    static void openUrl(){
        new LoginPage().openUrl();
    }

    @Test
    @DisplayName("密码错误登录")
    @Order(1)
    public void loginWithErrPassword(){
        String username = "1360881239";
        String password = "3333";
        String expectedErrM = "你输入的帐号或密码不正确，请重新输入。";

        String errM = loginPage.loginWithErrPassword(username, password);
        assertThat(errM, equalTo(expectedErrM));
    }

    @Test
    @DisplayName("账号错误登录")
    @Order(2)
    public void loginWithoutUsername(){
        String username = "123";
        String password = "2344";
        String expectedErrM = "请输入正确的帐号！";

        String errM = loginPage.loginWithErrUsername(username, password);
        assertThat(errM, equalTo(expectedErrM));
    }

    @Test
    @DisplayName("密码为空登录")
    @Order(3)
    public void loginWithoutPassword(){
        String username = "1360881239";
        String password = "";
        String expectedErrM = "你还没有输入密码！";

        String errM = loginPage.loginWithoutPassword(username, password);
        assertThat(errM, equalTo(expectedErrM));
    }

    @Test
    @DisplayName("正确登录")
    @Order(4)
    public void loginSuccess(){
        String username = "";
        String password = "";

        loginPage.loginSuccess(username, password);
    }
}

