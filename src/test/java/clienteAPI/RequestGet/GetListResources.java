package clienteAPI.RequestGet;

import java.util.List;
import java.util.Map;

import constants.EndPoints;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import pojos.listResources.DataItemListResources;
import pojos.listResources.JsonToDataItemMapperListResources;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;

public class GetListResources {
    private List<DataItemListResources> dataItemListResources;
    private Response response;

    public void verifyListResources() {
        response = given()

                .contentType(ContentType.JSON)
                .get(EndPoints.GET_LIST_RESOURCES);

        response.then()
                .body("$", hasKey("page"))
                .body("$", hasKey("data"))
                .body("$",hasKey("support"))
                .log()
                .all()
                .statusCode(HttpStatus.SC_OK);
        validateResponseResources(dataItemListResources);
    }

    public void validateResponseResources(List<DataItemListResources> dataItemListResources) {
        List<Map<String, String>> dataResources = response.then().extract().body().jsonPath().getList("data");
        dataItemListResources = JsonToDataItemMapperListResources.mapJsonDataToDataItemListResources(dataResources);

        List<String> expectedPantoneValue = List.of("15-4020", "17-2031", "19-1664", "14-4811", "17-1456", "15-5217");
        for (DataItemListResources actualName : dataItemListResources) {
            Assertions.assertTrue(expectedPantoneValue.contains(actualName.getPantoneValue()));
        }
    }
}

