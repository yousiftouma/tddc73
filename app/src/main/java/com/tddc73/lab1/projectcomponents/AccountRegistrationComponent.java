package com.tddc73.lab1.projectcomponents;

import android.content.Context;
import android.icu.util.VersionInfo;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.tddc73.lab1.R;

import java.util.List;

/**
 * Component that handles account registration. Visualises if any field has incorrect entries. Can override bool functions to define
 * custom validations for fields. Set a SuccesfulRegistrationHandler to handle successful registration.
 */
public class AccountRegistrationComponent extends LinearLayout{


    private EditText fullName;
    private EditText username;
    private EditText email;
    private PasswordStrengthMeter password;
    private Button accountCreation;
    private SuccessfulRegistrationHandler registrationHandler;

    private List<AccountRegistrationRow> arrList;
    private LinearLayout ll;

    public AccountRegistrationComponent(Context context) {
        super(context);
        init();
    }

    public AccountRegistrationComponent(Context context, List<AccountRegistrationRow> arrList){
        super(context);
        this.setOrientation(VERTICAL);
        ll = new LinearLayout(this.getContext());
        ll.setOrientation(VERTICAL);
        this.arrList = arrList;
        for (AccountRegistrationRow arr : arrList) {
            addAccountRegistrationRow(arr);
        }
        addView(ll);
        Button button = new Button(this.getContext());
        button.setText("Submit");
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        addView(button);
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

    /***
     * Initializes all subcomponents for this component. Creates an on-click listener for the account registration button.
     */
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

    public final void addAccountRegistrationRow(AccountRegistrationRow arr){
        ll.addView(arr);
    }

    /***
     * Takes entries of all fields and checks if they are valid. Runs the callback method for the successfulRegistrationHandler if all
     * fields are correct. Never runs the callback method if no handler is set by the user, result is ignored.
     */
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

    /***
     * Defines if a Full Name entry is valid.
     * @param currentEntry
     * @return true if full name entry is valid
     */
    public boolean isFullNameCorrect(String currentEntry){

        return true;
    }

    /***
     * Defines if a Username entry is valid.
     * @param currentEntry
     * @return true if username entry is valid
     */
    public boolean isUsernameCorrect(String currentEntry){

        return true;
    }

    /***
     * Defines if a email entry is valid.
     * @param currentEntry
     * @return true if email entry is valid
     */
    public boolean isEmailCorrect(String currentEntry){

        return currentEntry.equals("a");
    }

    /***
     * Sets the algorithm used for calculating password strength.
     * @param psc
     */
    public void setPasswordStrengthCalculator(PasswordStrengthCalculator psc) {
        password.setPasswordStrengthCalculator(psc);
    }

    /***
     * Defines if a password entry is valid, differs from calculating password strength
     * @param currentEntry
     * @return true if a password entry is valid
     */
    public boolean isPasswordOk(String currentEntry) {
        return password.getStrength() != PasswordStrengthMeter.PasswordStrength.INVALID;
    }

    /***
     * Sets a handler for this component, allows user to handle results for a successful registration.
     * @param registrationHandler
     */
    public void setRegistrationHandler(SuccessfulRegistrationHandler registrationHandler) {
        this.registrationHandler = registrationHandler;
    }
}
