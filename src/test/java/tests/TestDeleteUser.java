package tests;

import clienteAPI.RequestDelete.DeleteUser;
import org.junit.jupiter.api.Test;
import org.testng.annotations.BeforeClass;

import static io.restassured.RestAssured.baseURI;

public class TestDeleteUser {
    DeleteUser deleteUser = new DeleteUser();

    @BeforeClass
    public void init() {
        baseURI = "https://reqres.in";
    }

    @Test
    public void executionDeleteUser() {
        deleteUser.verifyDeleteUser(850);
    }

}
