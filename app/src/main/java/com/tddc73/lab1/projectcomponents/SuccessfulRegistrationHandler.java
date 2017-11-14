package com.tddc73.lab1.projectcomponents;


/**
 * Handles the result of a successful registration
 */
public interface SuccessfulRegistrationHandler {
    /**
     * Handles result of a successful registration
     * @param fullName full name
     * @param username username
     * @param email email
     * @param password password
     */
    void onSuccessfulRegistration(String fullName, String username, String email, String password);
}
