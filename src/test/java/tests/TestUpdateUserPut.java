package tests;

import clienteAPI.RequestPut.UpdateUser;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;

public class TestUpdateUserPut {
    UpdateUser updateUserPut = new UpdateUser();

    @BeforeClass
    public void init() {
        baseURI = "https://reqres.in";
    }

    @Test
    public void executionUpdateUserMethodPut() {
        updateUserPut.verifyUpdateUser(2);
    }
}
