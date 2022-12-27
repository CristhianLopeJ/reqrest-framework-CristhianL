package tests;

import clienteAPI.RequestGet.GetListUsers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pojos.listUsers.DataItemListUser;

import java.util.List;

import static io.restassured.RestAssured.baseURI;

public class TestGetListUser {
    private List<DataItemListUser> dataItemListUsers;
    private GetListUsers getListUsers = new GetListUsers();

    @BeforeClass
    public void init() {
        baseURI = "https://reqres.in";
    }

    @Test
    public void executionGetListUsers() {
        getListUsers.verifyListUsers();
        getListUsers.validateResponseDataUser(dataItemListUsers);
    }
}
