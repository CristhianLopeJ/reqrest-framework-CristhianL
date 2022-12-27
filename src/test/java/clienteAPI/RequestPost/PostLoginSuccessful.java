package clienteAPI.RequestPost;

import constants.EndPoints;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PostLoginSuccessful {

    public void verifyLoginSuccessfully() {
        JSONObject dataToLoginSuccessfully = new JSONObject();

        dataToLoginSuccessfully.put("email", "eve.holt@reqres.in");
        dataToLoginSuccessfully.put("password", "pistol");

        given()
                .contentType(ContentType.JSON)
                .body(dataToLoginSuccessfully.toString())
        .when()
                .post(EndPoints.LOGIN_SUCCESSFUL)
        .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("$", hasKey("token"))
                .body("token", notNullValue())
                .log().all();
    }
}
