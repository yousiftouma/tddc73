package com.tddc73.lab1;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.tddc73.lab1.projectcomponents.PasswordStrengthMeter;

public class Project extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_registration);
//        LinearLayout cl = new LinearLayout(this);
//        cl.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
//        cl.setOrientation(LinearLayout.VERTICAL);
//        PasswordStrengthMeter ll = new PasswordStrengthMeter(this);
//        cl.addView(ll);
//        setContentView(cl);
    }
}
