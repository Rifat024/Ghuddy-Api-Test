package net.ghuddy.UserServiceTest.OpenAPis;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import net.ghuddy.UserServiceTest.BaseUserServiceTest;

public abstract class BaseOpenApiTest extends BaseUserServiceTest {

    public RequestSpecification requestSpecificationForJsonHeader() {
        return new RequestSpecBuilder()
                //.addHeader("X-AUTHORIZATION", accessToken)
                //.addHeader("Authorization", "Bearer " + getAccessToken())
                .addHeader("Content-Type", "application/json")
                .build();
    }
}
