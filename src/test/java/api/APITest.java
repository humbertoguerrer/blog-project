package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.json.simple.JSONObject;

public class APITest {

    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = "http://localhost:8080/";

    }

    @Test
    public void listarTodosPosts() {
        RestAssured.given()
                .when()
                .get("/posts")
                .then()
                .statusCode(200);
    }

    @Test
    public void buscarPostPorId() {
        RestAssured.given()
                .when()
                .get("/posts/2")
                .then()
                .statusCode(200);
    }

    @Test
    public void salvarPost() {

        RequestSpecification request = RestAssured.given();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("titulo", "A maluca vida de Israel Lima");
        jsonObject.put("autor", "Israel Lima");
        jsonObject.put("data", "05/07/2020");
        jsonObject.put("conteudo", "Lorem Ipsun dolo sit amet");

        request.header("Content-Type", "application/json");
        request.body(jsonObject.toJSONString());
        Response response = request.post("/posts");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 201);
    }

    @Test
    public void deletarPostPorId() {
        RestAssured.given()
                .when()
                .delete("/posts/2")
                .then()
                .statusCode(204);
    }
}