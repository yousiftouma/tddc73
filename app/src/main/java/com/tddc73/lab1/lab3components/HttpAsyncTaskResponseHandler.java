package com.tddc73.lab1.lab3components;

public interface HttpAsyncTaskResponseHandler {
    /**
     * Handle string response from an async task
     * @param response string to handle
     */
    void handleResponse(String response);
}
