package tests;

import clienteAPI.RequestPatch.UpdateUserPatch;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;

public class TestUpdateUserPatch {
    UpdateUserPatch updateUserPatch = new UpdateUserPatch();

    @BeforeClass
    public void init() {
        baseURI = "https://reqres.in";
    }

    @Test
    public void executionUpdateUserMethodPatch() {
        updateUserPatch.verifyUpdateUserPatch(850);
    }
}
