package net.ghuddy.UserServiceTest.pojoClass;


import com.fasterxml.jackson.annotation.JsonProperty;

public class SignUpData {
    @JsonProperty("email")
    private String email;
    @JsonProperty("firebaseToken")
    private String firebaseToken;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("password")
    private String password;
    @JsonProperty("phoneCode")
    private String phoneCode;
    @JsonProperty("phoneNumber")
    private String phoneName;
    @JsonProperty("requestId")
    private String requestId;
    @JsonProperty("title")
    private String title;
    @JsonProperty("tncVersion")
    private Integer tncVersion;

    public SignUpData(){}

    public SignUpData(String email, String firebaseToken, String firstName, String lastName, String password, String phoneCode, String phoneName, String requestId, String title, Integer tncVersion) {
        this.email = email;
        this.firebaseToken = firebaseToken;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.phoneCode = phoneCode;
        this.phoneName = phoneName;
        this.requestId = requestId;
        this.title = title;
        this.tncVersion = tncVersion;
    }
}
