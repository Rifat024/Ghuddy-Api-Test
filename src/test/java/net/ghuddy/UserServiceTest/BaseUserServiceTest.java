package net.ghuddy.UserServiceTest;

import com.thedeanda.lorem.LoremIpsum;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;

public abstract class BaseUserServiceTest {
    @BeforeClass
    protected void setup() {
        RestAssured.baseURI = "https://ghuddy.link/api";
        RestAssured.basePath = "/v1";
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    public RequestSpecification requestHeaderSpecificationForUat() {
        return new RequestSpecBuilder()
                .addHeader("x-client-id", "Ieg1N5W2qh3hF0qS9Zh2wq6eex2DB935")
                .addHeader("x-client-secret", "4H2QJ89kYQBStaCuY73h")
                .addHeader("Content-Type", "application/json")
                .build();
    }
    protected String getImageUrl() {
        return "https://dummyimage.com/200x200&text=" + LoremIpsum.getInstance().getTitle(1);
    }
}
