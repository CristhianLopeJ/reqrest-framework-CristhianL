package clienteAPI.RequestPost;

import constants.EndPoints;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasKey;

public class PostRegisterSuccessful {

    @Test
    public void verifyLoginSuccessfully(){
        JSONObject dataToRegisterSuccessful = new JSONObject();

        dataToRegisterSuccessful.put("email","eve.holt@reqres.in");
        dataToRegisterSuccessful.put("password","pistol");

        given()
                .contentType(ContentType.JSON)
                .body(dataToRegisterSuccessful.toString())
        .when()
                .post(EndPoints.REGISTER_SUCCESSFUL)
        .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("$",hasKey("id"))
                .body("$",hasKey("token"))
                .log().all();
    }
}
