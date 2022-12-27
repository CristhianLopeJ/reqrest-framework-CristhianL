package clienteAPI.RequestPatch;

import clienteAPI.RequestPost.PostCreateUser;
import constants.EndPoints;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasKey;

public class UpdateUserPatch {
    Response response;
    public String updateName;
    public String updateJob;

    public Response verifyUpdateUserPatch(Integer id) {

        updateName = "Jose Luis";
        updateJob = "Developer";
        JSONObject updateUser = new JSONObject();

        updateUser.put("name", updateName);
        updateUser.put("job", updateJob);

        given()
                .contentType(ContentType.JSON)
                .pathParam("id", id)
                .body(updateUser.toString())
        .when()
                .patch(EndPoints.UPDATE_USER_PATCH)
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
