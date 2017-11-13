package com.tddc73.lab1.projectcomponents;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
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



        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                updatePasswordStrength(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private void updatePasswordStrength(String userTypedPassword) {
        PasswordStrength ps = calculatePasswordStrength(userTypedPassword);
        switch(ps) {
            case INVALID:
                textView.setTextColor(Color.BLACK);
                textView.setText("INVALID");
                progressBar.setProgress(0);
                progressBar.getProgressDrawable().setColorFilter(Color.BLACK, PorterDuff.Mode.MULTIPLY);
                break;
            case WEAK:
                textView.setTextColor(Color.RED);
                textView.setText("WEAK");
                progressBar.setProgress(25);
                progressBar.getProgressDrawable().setColorFilter(Color.RED, PorterDuff.Mode.MULTIPLY);
                break;
            case MODERATE:
                textView.setTextColor(Color.parseColor("#F4C20D"));
                textView.setText("MODERATE");
                progressBar.setProgress(50);
                progressBar.getProgressDrawable().setColorFilter(Color.parseColor("#F4C20D"), PorterDuff.Mode.MULTIPLY);
                break;
            case STRONG:
                textView.setTextColor(Color.parseColor("#FFA500"));
                textView.setText("STRONG");
                progressBar.setProgress(75);
                progressBar.getProgressDrawable().setColorFilter(Color.parseColor("#FFA500"), PorterDuff.Mode.MULTIPLY);
                break;
            case VERY_STRONG:
                textView.setTextColor(Color.parseColor("#3CBA54"));
                textView.setText("VERY STRONG");
                progressBar.setProgress(100);
                progressBar.getProgressDrawable().setColorFilter(Color.parseColor("#3CBA54"), PorterDuff.Mode.MULTIPLY);
                break;
        }
    }

    public PasswordStrength calculatePasswordStrength(String userTypedPassword) {
        int passwordLength = userTypedPassword.length();
        if(passwordLength <= 8){
            return PasswordStrength.INVALID;
        }else if (passwordLength <= 10){
            return PasswordStrength.WEAK;
        }else if (passwordLength <= 12){
            return PasswordStrength.MODERATE;
        }else if (passwordLength <= 14){
            return PasswordStrength.STRONG;
        }else if (passwordLength >= 15){
            return PasswordStrength.VERY_STRONG;
        }
        return PasswordStrength.INVALID;
    }

    public enum PasswordStrength{
        INVALID,
        WEAK,
        MODERATE,
        STRONG,
        VERY_STRONG
    }
}
