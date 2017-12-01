package com.tddc73.lab1.projectcomponents;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tddc73.lab1.R;

public class AccountRegistrationRow extends LinearLayout{

    private TextView descriptiveText;
    private EditText field;

    private AccountRegistrationRowValidator validator;

    public AccountRegistrationRow(Context context) {
        super(context);
        init();
    }

    public AccountRegistrationRow(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public AccountRegistrationRow(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public AccountRegistrationRow(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    public void init(){
        inflate(this.getContext(), R.layout.account_registration_row, this);
        descriptiveText = findViewById(R.id.descriptiveText);
        field = findViewById(R.id.editField);

        validator = new AccountRegistrationRowValidator() {
            @Override
            public boolean validate() {
                String content = descriptiveText.getText().toString();
                return content.equals("test");
            }
        };

    }

    public final void setAccountRegistrationValidator(AccountRegistrationRowValidator validator){
        this.validator = validator;
    }

    public void setDescriptiveText(String descriptiveText) {
        if(this.descriptiveText != null) {
            this.descriptiveText.setText(descriptiveText);
        }
    }

    public final boolean isValid(){
        return validator.validate();
    }

    public void setError(String errorMessage){
        field.setError(errorMessage);
    }

}
