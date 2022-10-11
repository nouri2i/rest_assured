import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Examples {
   // @Test
    public void test_get(){
        baseURI = "http://localhost:3000/";
        given()
                .param("name","Automation")
                .get("/subjects")
                .then()
                .statusCode(200)
                .log().all();


    }
   // @Test
    public void test_post(){
        JSONObject request = new JSONObject();

        request.put("firstName","Tom");
        request.put("surName","Cooper");
        request.put("subjectId",1);
        baseURI = "http://localhost:3000/";
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Content-Type","application/json")
                .body(request.toJSONString())
                .when()
                .post("/users")
                .then()
                .statusCode(201)
                .log().all();
    }
    //@Test
    public void test_patch(){
        JSONObject request = new JSONObject();

        request.put("firstName","Andy");
        request.put("surName","GHaling");

        baseURI = "http://localhost:3000/";
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Content-Type","application/json")
                .body(request.toJSONString())
                .when()
                .patch("/users/5")
                .then()
                .statusCode(200)
                .log().all();
    }

//    @Test
    public void test_put(){
        JSONObject request = new JSONObject();

        request.put("firstName","Mary");
        request.put("surName","Jane");
        request.put("subjectId",2);

        baseURI = "http://localhost:3000/";
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Content-Type","application/json")
                .body(request.toJSONString())
                .when()
                .put("/users/1")
                .then()
                .statusCode(200)
                .log().all();
    }
    @Test
    public void test_delete(){
        baseURI="http://localhost:3000";
        when()
                .delete("/users/5")
                .then()
                .statusCode(200);
    }
}
