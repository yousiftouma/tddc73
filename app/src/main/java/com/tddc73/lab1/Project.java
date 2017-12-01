package com.tddc73.lab1;

import android.accounts.Account;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.tddc73.lab1.projectcomponents.AccountRegistrationComponent;
import com.tddc73.lab1.projectcomponents.AccountRegistrationRow;
import com.tddc73.lab1.projectcomponents.AccountRegistrationRowValidator;
import com.tddc73.lab1.projectcomponents.MyAccountRow;
import com.tddc73.lab1.projectcomponents.PasswordStrengthMeter;
import com.tddc73.lab1.projectcomponents.SuccessfulRegistrationHandler;

import java.util.ArrayList;
import java.util.List;

public class Project extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        List<AccountRegistrationRow> arrList = new ArrayList<>();
        AccountRegistrationRow arr1 = new AccountRegistrationRow(this);
        arr1.setDescriptiveText("trololol");
        arr1.setAccountRegistrationValidator(new AccountRegistrationRowValidator() {
            @Override
            public boolean validate() {
                return false;
            }
        });
        arrList.add(arr1);
        AccountRegistrationRow arr2 = new AccountRegistrationRow(this);
        arr2.setDescriptiveText("trololol2");
        arr2.setAccountRegistrationValidator(new AccountRegistrationRowValidator() {
            @Override
            public boolean validate() {
                return false;
            }
        });
        arrList.add(arr2);
        AccountRegistrationRow arr3 = new AccountRegistrationRow(this);
        arr3.setDescriptiveText("trololol3");
        arr3.setAccountRegistrationValidator(new AccountRegistrationRowValidator() {
            @Override
            public boolean validate() {
                return false;
            }
        });
        arrList.add(arr3);
        AccountRegistrationRow arr4 = new MyAccountRow(this);
        arr4.setDescriptiveText("trololol3");
        arr4.setAccountRegistrationValidator(new AccountRegistrationRowValidator() {
            @Override
            public boolean validate() {
                return false;
            }
        });
        arrList.add(arr4);

        AccountRegistrationComponent arc = new AccountRegistrationComponent(this, arrList);
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
