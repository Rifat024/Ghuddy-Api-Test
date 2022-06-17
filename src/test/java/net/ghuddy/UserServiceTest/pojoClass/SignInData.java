package net.ghuddy.UserServiceTest.pojoClass;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class SignInData {
    @JsonProperty("password")
    private String password;

    @JsonProperty("phoneCode")
    private String phoneCode;

    @JsonProperty("phoneNumber")
    private String phoneNumber;

    @JsonProperty("requestId")
    private String requestId;

    public SignInData(String password, String phoneCode, String phoneNumber, String requestId) {
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.phoneCode = phoneCode;
        this.requestId = requestId;
    }

    public SignInData() {

    }
}
