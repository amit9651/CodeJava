package grouping;

import org.testng.annotations.Test;

public class SignUpTests {

    @Test(groups = {"regression"})
    public void signUpByEmail(){
        System.out.println("Sign up by email");
    }

    @Test(groups = {"regression"})
    public void signUpByID(){
        System.out.println("Sign up by id");
    }

    @Test(groups = {"regression"})
    public void signUpByUsername(){
        System.out.println("Sign up by username");
    }
}
