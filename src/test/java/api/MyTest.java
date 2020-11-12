package api;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MyTest extends BaseTest{

    SoftAssert softAssert = new SoftAssert();

    @Test(description = "Retrive Body yesno")
    public void retriveBody() throws InterruptedException {
        Response response = when().get("https://yesno.wtf/api").then().extract().response();
        String Answer = response.path("answer");
        System.out.println(Answer);
    }

    @Test(description = "Customer shortcuts")
    public void customerBubbles() throws InterruptedException {

        Response response = when()
             .get("https://www.harel-group.co.il/_vti_bin/webapi/GeneralAccessor?id=HomeShortcuts&cacheKey=HomeShortcuts")
             .then()
              .contentType(ContentType.JSON)
             .extract()
             .response();

        List<String> jsonResponse = response.jsonPath().getList("Title");
        int arraySize = jsonResponse.size();
        System.out.println(arraySize);
        softAssert.assertEquals(arraySize, 6, "Test Failed Array Size is: " + arraySize);
        String expextedTitle="שינוי מסלול השקעה";
        softAssert.assertEquals(expextedTitle,jsonResponse.get(0),"Title - Test Failed");
          for(int i=0;i<arraySize;i++) {
                   System.out.println(jsonResponse.get(i));
          }

        softAssert.assertAll();

       /*
        Response response = when()
               .get("https://www.harel-group.co.il/_vti_bin/webapi/GeneralAccessor?id=HomeShortcuts&cacheKey=HomeShortcuts")
               .then()
               .contentType(ContentType.XML)
               .extract()
               .response();
        // will run only if response type XML
        System.out.println(response.asString());
        */

    }

}
