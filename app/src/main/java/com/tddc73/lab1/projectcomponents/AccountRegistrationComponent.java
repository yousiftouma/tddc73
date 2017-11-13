package com.tddc73.lab1.projectcomponents;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.tddc73.lab1.R;

/**
 * Created by Andreas on 2017-11-13.
 */
public class AccountRegistrationComponent extends LinearLayout{


    private EditText fullName;
    private EditText userName;
    private EditText email;
    private PasswordStrengthMeter password;
    private Button accountCreation;

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
        fullName = findViewById(R.id.fullnameET);
        userName = findViewById(R.id.usernameET);
        email = findViewById(R.id.emailET);
        password = findViewById(R.id.passwordStengthMeter);
        accountCreation = findViewById(R.id.createAccountButton);


    }

}
