package com.tddc73.lab1.projectcomponents;


import java.util.List;

/**
 * Handles the result of a successful registration
 */
public interface SuccessfulRegistrationHandler {
    /**
     * Handles result of a successful registration
     * @param rows The rows used to register
     */
    void onSuccessfulRegistration(List<AccountRegistrationRow> rows);
}
