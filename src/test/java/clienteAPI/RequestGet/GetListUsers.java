package clienteAPI.RequestGet;

import constants.EndPoints;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import pojos.listUsers.DataItemListUser;
import pojos.listUsers.JsonToDataItemMapperListUser;

import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;

public class GetListUsers {
    private List<DataItemListUser> dataItems;
    private Response response;

    @Test
    public void verifyListUsers() {
        response = given()
                .log().all()
                .contentType(ContentType.JSON)
                .get(EndPoints.GET_LIST_USER);
        response.then()
                .assertThat()
                //.statusCode(HttpStatus.SC_OK)
                .body("$", hasKey("support"))
                .body("$", hasKey("page"))
                .body("$",hasKey("support"))
                .log()
                .all();

        validateResponseDataUser(dataItems);
    }

    /**
     * @param dataItems - Validate all the users are in the expected names
     */
    public void validateResponseDataUser(List<DataItemListUser> dataItems) {
        List<Map<String, String>> data = response.then().extract().body().jsonPath().getList("data");
        dataItems = JsonToDataItemMapperListUser.mapJsonDataToDataItem(data);

        List<String> expectedNames = List.of("George", "Janet", "Emma", "Eve", "Charles", "Tracey");
        for (DataItemListUser actualName : dataItems) {
            Assertions.assertTrue(expectedNames.contains(actualName.getFirstName()));
        }
    }
}
