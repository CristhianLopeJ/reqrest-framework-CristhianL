package clienteAPI.RequestDelete;

import constants.EndPoints;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class DeleteUser {
    public Response response;

    @Test
    public Response verifyDeleteUser(Integer id) {

        response = given()
                .pathParam("id", id)
                .when()
                .delete(EndPoints.DELETE_USER);
        response.then()
                .assertThat()
                .statusCode(204)
                .body(blankString())
                .body(emptyOrNullString())
                .log().all();
        System.out.println("empty body");
        System.out.println(response.body());

        return response;
    }
}
