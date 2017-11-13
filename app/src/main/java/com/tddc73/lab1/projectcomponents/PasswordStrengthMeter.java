package com.tddc73.lab1.projectcomponents;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.tddc73.lab1.R;

/**
 * Created by Yousif Touma on 2017-11-13.
 */

public class PasswordStrengthMeter extends LinearLayout {

    private EditText editText;
    private ProgressBar progressBar;
    private TextView textView;


    public PasswordStrengthMeter(Context context) {
        super(context);
        init();
    }

    public PasswordStrengthMeter(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PasswordStrengthMeter(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public PasswordStrengthMeter(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.account_registration_password_strength, this);
        this.editText = findViewById(R.id.editTextPassword);
        this.progressBar = findViewById(R.id.passwordStrength);
        this.textView = findViewById(R.id.passwordStrengthText);
    }
}
