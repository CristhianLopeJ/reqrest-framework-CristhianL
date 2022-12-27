package clienteAPI.RequestPut;

import clienteAPI.RequestPost.PostCreateUser;
import constants.EndPoints;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.json.JSONObject;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class UpdateUser {
    private Response response;
    private String updateName;
    private String updateJob;

    public Response verifyUpdateUser(Integer id) {
        updateName = "TestTest";
        updateJob = "Developer";

        JSONObject updateUser = new JSONObject();

        updateUser.put("name", updateName);
        updateUser.put("job", updateJob);

        given()
                .contentType(ContentType.JSON)
                .pathParam("id", id)
                .when()
                .body(updateUser.toString())
                .put(EndPoints.UPDATE_USER_PUT)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("name", equalTo(updateName))
                .body("job", equalTo(updateJob))
                .body("$", hasKey("updatedAt"))
                .log().all();
        return response;
    }
}
