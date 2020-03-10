package page;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginPage extends BasePage{

    //定位器
    private By usernameInput = By.name("u");//获取用户名输入框
    private By passwordInput = By.id("id");//获取密码输入框
    private By submitLogin = By.cssSelector("#login_button");//获取登录按钮
    private By ErrM = By.id("err_m");//获取错误信息

    /**
     * 打开页面并调整
     */
    public void openUrl(){
        String url = "https://mail.qq.com/";

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
        driver.manage().window().maximize();
        driver.switchTo().frame("login_frame");//进入iframe
    }

    private void sleepWait(){
        try{
            Thread.sleep(500);

        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    /**
     * 业务方法
     */
    private void login(String username, String password){
        findElement(usernameInput).clear();
        findElement(passwordInput).clear();
        sendKeys(usernameInput, username);
        sendKeys(passwordInput, password);
        click(submitLogin);
    }

    //成功登录
    public MainPage loginSuccess(String username, String password){
        login(username, password);
        return new MainPage();
    }

    //密码错误登录
    public String loginWithErrPassword(String username, String password){
        login(username, password);
        sleepWait();
        return getText(ErrM);
    }

    //账号错误登录
    public String loginWithErrUsername(String username, String password){
        login(username, password);
        sleepWait();
        return getText(ErrM);
    }

    //密码为空登录
    public String loginWithoutPassword(String username, String password){
        login(username, password);
        sleepWait();
        return getText(ErrM);
    }

}
