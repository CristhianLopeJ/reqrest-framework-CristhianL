package tests;


import clienteAPI.RequestPost.PostRegisterUnSuccessful;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;

public class TestRegisterUnsuccessful {
    PostRegisterUnSuccessful postRegisterUnSuccessful = new PostRegisterUnSuccessful();

    @BeforeClass
    public void init() {
        baseURI = "https://reqres.in";
    }

    @Test
    public void executionRegisterUnsuccessful() {
        postRegisterUnSuccessful.verifyLoginUnsucessfully();
    }

}
