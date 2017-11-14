package com.tddc73.lab1.projectcomponents;

/**
 * Created by Andreas on 2017-11-14.
 */

public interface SuccessfulRegistrationHandler {
    void onSuccessfulRegistration(String fullName, String username, String email, String password);
}
