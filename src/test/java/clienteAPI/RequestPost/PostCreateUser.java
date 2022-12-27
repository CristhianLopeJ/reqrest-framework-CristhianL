package clienteAPI.RequestPost;

import constants.EndPoints;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.json.JSONObject;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;

public class PostCreateUser {
    Response response;

    public void verifyCreateUser() {
        String nameUserCreated = "Ariel";
        String job = "Qa Automation Engineer";

        JSONObject bodyCreateUser = new JSONObject();

        bodyCreateUser.put("name", nameUserCreated);
        bodyCreateUser.put("job", job);

        response = given()
                .contentType(ContentType.JSON)
                .body(bodyCreateUser.toString())
                .when()
                .post(EndPoints.CREATE_USER);

        response.then()
                .statusCode(HttpStatus.SC_CREATED)
                .body("name", equalTo(nameUserCreated))
                .body("job", equalTo(job))
                .body("$", hasKey("id"))
                .body("$", hasKey("createdAt"))
                .log().all();

    }
}
