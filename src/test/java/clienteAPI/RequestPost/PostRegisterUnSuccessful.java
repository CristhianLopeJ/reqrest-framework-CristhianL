package clienteAPI.RequestPost;

import constants.EndPoints;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PostRegisterUnSuccessful {

    @Test
    public void verifyLoginUnsucessfully(){
        JSONObject dataToRegisterUnsuccessfully = new JSONObject();

        dataToRegisterUnsuccessfully.put("email","sydney@fife");

        given()
                .contentType(ContentType.JSON)
                .body(dataToRegisterUnsuccessfully.toString())
        .when()
                .post(EndPoints.REGISTER_UNSUCCESSFUL)
        .then()
                .assertThat()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .body("error",notNullValue())
                .body("error",equalTo("Missing password"))
                .log().all().toString();
    }
}
