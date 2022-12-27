package tests;


import clienteAPI.RequestGet.GetListResources;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import pojos.listResources.DataItemListResources;
import java.util.List;

import static io.restassured.RestAssured.*;

public class TestGetListResources {
    private List<DataItemListResources> dataItemListResources;
    private GetListResources getListResources = new GetListResources();


    @BeforeClass
    public void init() {
        baseURI = "https://reqres.in";
    }

    @Test
    public void executionGetListResources() {
        getListResources.verifyListResources();
        getListResources.validateResponseResources(dataItemListResources);
    }
}
