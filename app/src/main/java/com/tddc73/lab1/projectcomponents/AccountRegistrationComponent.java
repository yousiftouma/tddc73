package com.tddc73.lab1.projectcomponents;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.tddc73.lab1.R;

/**
 * Created by Andreas on 2017-11-13.
 */
public class AccountRegistrationComponent extends LinearLayout{


    private EditText fullName;
    private EditText username;
    private EditText email;
    private PasswordStrengthMeter password;
    private Button accountCreation;
    private SuccessfulRegistrationHandler registrationHandler;

    public AccountRegistrationComponent(Context context) {
        super(context);
        init();
    }

    public AccountRegistrationComponent(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public AccountRegistrationComponent(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public AccountRegistrationComponent(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.account_registration, this);
        fullName = (EditText) findViewById(R.id.fullnameET);
        username = (EditText) findViewById(R.id.usernameET);
        email = (EditText) findViewById(R.id.emailET);
        password = (PasswordStrengthMeter) findViewById(R.id.passwordStengthMeter);
        accountCreation = (Button) findViewById(R.id.createAccountButton);
        accountCreation.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                validateRegistration();
            }
        });
    }

    private void validateRegistration(){
        boolean successful = true;
        String fullNameText = fullName.getText().toString();
        String usernameText = username.getText().toString();
        String emailText = email.getText().toString();
        String passwordText = email.getText().toString();


        if(!isFullNameCorrect(fullNameText)){
            fullName.setError("Incorrect name!");
            successful = false;
        }

        if(!isUsernameCorrect(usernameText)){
            username.setError("Incorrect username!");
            successful = false;
        }

        if(!isEmailCorrect(emailText)){
            email.setError("Incorrect email!");
            successful = false;
        }

        if(!isPasswordOk(passwordText)){
            password.setError("Invalid password!");
            successful = false;
        }

        if(successful && registrationHandler != null)
            registrationHandler.onSuccessfulRegistration(fullNameText, usernameText, emailText, passwordText);
    }

    public boolean isFullNameCorrect(String currentEntry){

        return true;
    }

    public boolean isUsernameCorrect(String currentEntry){

        return true;
    }

    public boolean isEmailCorrect(String currentEntry){

        return currentEntry.equals("a");
    }

    public void setPasswordStrengthCalculator(PasswordStrengthCalculator psc) {
        password.setPasswordStrengthCalculator(psc);
    }

    public boolean isPasswordOk(String currentEntry) {
        return password.getStrength() != PasswordStrengthMeter.PasswordStrength.INVALID;
    }


    public void setRegistrationHandler(SuccessfulRegistrationHandler registrationHandler) {
        this.registrationHandler = registrationHandler;
    }
}
