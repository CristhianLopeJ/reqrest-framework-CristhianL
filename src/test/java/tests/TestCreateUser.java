package tests;

import clienteAPI.RequestPost.PostCreateUser;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;

public class TestCreateUser {
    PostCreateUser postCreateUser = new PostCreateUser();

    @BeforeClass
    public static void init() {
        baseURI = "https://reqres.in";
    }

    @Test
    public void executionCreateUser() {
        postCreateUser.verifyCreateUser();
    }
}
