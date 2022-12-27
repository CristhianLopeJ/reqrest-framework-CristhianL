package clienteAPI.RequestPost;

import constants.EndPoints;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.json.JSONObject;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;

public class PostLoginUnSuccessful {

    public void verifyLoginUnsuccessful() {
        JSONObject dataToLoginUnsuccessfully = new JSONObject();

        dataToLoginUnsuccessfully.put("email", "sydney@fife");

        given()
                .contentType(ContentType.JSON)
                .body(dataToLoginUnsuccessfully)
        .when()
                .post(EndPoints.LOGIN_UNSUCCESSFUL)
        .then()
                .assertThat()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .body("error", notNullValue())
                .body("error", equalTo("Missing password"))
                .log().all();
    }
}
