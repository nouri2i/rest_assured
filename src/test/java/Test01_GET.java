import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.reporters.XMLConstants;

public class Test01_GET {
    @Test
    void test_01 (){
    Response response= get("https://reqres.in/api/users?page=2");
    System.out.println(response.getStatusCode());
        System.out.println(response);
        System.out.println(response.asString());
        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusLine());
        System.out.println(response.getTime());
        System.out.println(response.getHeader("content-type"));
        int statusCode = response.getStatusCode();
        Assert.assertEquals( statusCode,200);

    }
    @Test
    void test_02(){
       given().get("https://reqres.in/api/users?page=2")
               .then()
               .statusCode(200)
               .body("data.id[0]",equalTo(7));
    }
}
