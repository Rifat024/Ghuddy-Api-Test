package net.ghuddy.UserServiceTest.OpenAPis.post;

import net.ghuddy.UserServiceTest.OpenAPis.BaseOpenApiTest;
import net.ghuddy.UserServiceTest.pojoClass.SignInData;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SignInTest extends BaseOpenApiTest {
    @Test(enabled = true, description = "Sign in test using valid data")
    void signInTest() {
        given()
                .spec(requestSpecificationForJsonHeader())
                .body(new SignInData("123456", "+880", "1725991536", "1234"))
                .log().uri()
                .log().body()
                .when()
                .post("/open/signin")
                .then()
                .log().body()
                .statusCode(200);
    }

    @Test(enabled = true, description = "Sign in test using Invalid data")
    void signInTestWithInvalidData() {
        given()
                .spec(requestSpecificationForJsonHeader())
                .body(new SignInData("123", "+880", "1725991536", "1234"))
                .log().uri()
                .log().body()
                .when()
                .post("/open/signin")
                .then()
                .log().body()
                .statusCode(400);

    }

    @Test(enabled = true, description = "Sign in test using null data")
    void signInTestWithNullData() {
        given()
                .spec(requestSpecificationForJsonHeader())
                .body(new SignInData(null, null, null, null))
                .log().uri()
                .log().body()
                .when()
                .post("/open/signin")
                .then()
                .log().body()
                .statusCode(400);

    }

    @Test(enabled = true, description = "Sign in test using Blank data")
    void signInTestWithBlankData() {
        given()
                .spec(requestSpecificationForJsonHeader())
                .body(new SignInData())
                .log().uri()
                .log().body()
                .when()
                .post("/open/signin")
                .then()
                .log().body()
                .statusCode(400);

    }
}
