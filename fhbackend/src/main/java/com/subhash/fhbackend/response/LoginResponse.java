package com.subhash.fhbackend.response;

public class LoginResponse {

    private String jwtToken;

    private String email;

    public LoginResponse(String jwtToken, String email) {
        this.jwtToken = jwtToken;
        this.email = email;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
