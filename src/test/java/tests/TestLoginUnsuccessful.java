package tests;

import clienteAPI.RequestPost.PostLoginUnSuccessful;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;

public class TestLoginUnsuccessful {
    PostLoginUnSuccessful postLoginUnSuccessful = new PostLoginUnSuccessful();

    @BeforeClass
    public void init() {
        baseURI = "https://reqres.in";
    }

    @Test
    public void executionLoginUnsuccessful() {
        postLoginUnSuccessful.verifyLoginUnsuccessful();
    }
}
