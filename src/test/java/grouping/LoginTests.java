package grouping;

import org.testng.annotations.Test;

public class LoginTests {

    @Test(groups = {"sanity"})
    public void loginByEmail(){
        System.out.println("Login by email");
    }

    @Test(groups = {"sanity"})
    public void loginByID(){
        System.out.println("Login by ID");
    }

    @Test(groups = {"sanity"})
    public void loginByUsername(){
        System.out.println("Login by username");
    }
}
