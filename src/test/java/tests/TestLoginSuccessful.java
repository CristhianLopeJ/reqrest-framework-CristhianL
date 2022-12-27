package tests;

import clienteAPI.RequestPost.PostLoginSuccessful;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;

public class TestLoginSuccessful {
    PostLoginSuccessful postLoginSuccessful = new PostLoginSuccessful();

    @BeforeClass
    public void init() {
        baseURI = "https://reqres.in";
    }

    @Test
    public void executionLoginSuccessful() {
        postLoginSuccessful.verifyLoginSuccessfully();
    }
}
