package tests;

import clienteAPI.RequestPost.PostRegisterSuccessful;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;

public class TestRegisterSuccessful {
    PostRegisterSuccessful postRegisterSucessful = new PostRegisterSuccessful();

    @BeforeClass
    public void init() {
        baseURI = "https://reqres.in";
    }

    @Test
    public void executionRegisterSuccessful() {
        postRegisterSucessful.verifyLoginSuccessfully();
    }
}
