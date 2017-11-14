package com.tddc73.lab1;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.tddc73.lab1.projectcomponents.AccountRegistrationComponent;
import com.tddc73.lab1.projectcomponents.PasswordStrengthMeter;
import com.tddc73.lab1.projectcomponents.SuccessfulRegistrationHandler;

public class Project extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AccountRegistrationComponent arc = new AccountRegistrationComponent(this);
        arc.setRegistrationHandler(new SuccessfulRegistrationHandler() {
            @Override
            public void onSuccessfulRegistration(String fullName, String username, String email, String password) {
                test();
            }
        });
        setContentView(arc);
    }

    public void test(){
        Toast.makeText(this, "Successful Account Registration!", Toast.LENGTH_LONG).show();
    }
}
