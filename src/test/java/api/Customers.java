package api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class Customers extends BaseTest{

    SoftAssert softAssert = new SoftAssert();

    @Test(description = "Customer shortcuts", enabled = false)
    public void customerBubbles() throws InterruptedException {

        Response response = when()
             .get("https://www.harel-group.co.il/_vti_bin/webapi/GeneralAccessor?id=HomeShortcuts&cacheKey=HomeShortcuts")
             .then().contentType(ContentType.JSON).extract().response();

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
    }

    @Test(description = "Typing Suggestions", enabled = false)
    public void typingSuggestions() throws InterruptedException {

        Response response = when()
                .get("http://www.harel-group.co.il/_vti_bin/webapi/GeneralAccessor?id=SearchTypingSuggestions&cacheKey=SearchTypingSuggestions")
                .then().contentType(ContentType.JSON).extract().response();

        List<String> jsonResponse = response.jsonPath().getList("Title");
        String firstTitle="איך משנים מסלול השקעה?";
        softAssert.assertEquals(firstTitle,jsonResponse.get(0),"Title - Test Failed");
        for(int i=0;i<jsonResponse.size();i++) {
            System.out.println(jsonResponse.get(i));
        }
        softAssert.assertAll();
    }

    @Test(description = "Print customer shortcuts", enabled = true)
    public void PrintCustomerBubbles() throws InterruptedException {

        Response response = when()
                .get("https://www.harel-group.co.il/_vti_bin/webapi/GeneralAccessor?id=HomeShortcuts&cacheKey=HomeShortcuts")
                .then().contentType(ContentType.JSON).extract().response();
        ArrayList<String> titleList = new ArrayList<>(response.path("Title"));
        titleList.forEach(Title -> {
            System.out.println(Title);
        });
        /*
        List<String> jsonResponse = response.jsonPath().getList("Title");
        int arraySize = jsonResponse.size();
        System.out.println(arraySize);
        softAssert.assertEquals(arraySize, 6, "Test Failed Array Size is: " + arraySize);
        String expextedTitle="שינוי מסלול השקעה";
        softAssert.assertEquals(expextedTitle,jsonResponse.get(0),"Title - Test Failed");
        for(int i=0;i<arraySize;i++) {
            System.out.println(jsonResponse.get(i));
        }

         */
        //softAssert.assertAll();
    }



}
