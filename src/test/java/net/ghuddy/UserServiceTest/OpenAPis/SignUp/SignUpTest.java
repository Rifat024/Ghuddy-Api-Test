package net.ghuddy.UserServiceTest.OpenAPis.SignUp;

import com.thedeanda.lorem.LoremIpsum;
import net.ghuddy.UserServiceTest.BaseUserServiceTest;
import net.ghuddy.UserServiceTest.pojoClass.SignInData;
import net.ghuddy.UserServiceTest.pojoClass.SignUpData;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SignUpTest extends BaseUserServiceTest {
    @Test(enabled = true, description = "Sign in test using valid data")
    void signInTestWithExistingValue() {
        given()
                .spec(requestSpecificationForJsonHeader())
                .body(SignUpRequestData())
                .log().uri()
                .log().body()
                .when()
                .post("open/firebase/signup")
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

    public SignUpData SignUpRequestData(){
        return new SignUpData(LoremIpsum.getInstance().getEmail(),"sQWSmdqSg0OfGCNgUAALs0FW0WZ2",LoremIpsum.getInstance().getFirstName(),LoremIpsum.getInstance().getLastName(),"12345","+880","1521300458","qwert","Mr.",10);
    }
}
