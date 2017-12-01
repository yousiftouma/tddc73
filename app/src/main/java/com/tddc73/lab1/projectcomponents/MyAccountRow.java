package com.tddc73.lab1.projectcomponents;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.CheckBox;
import android.widget.TextView;

import com.tddc73.lab1.R;

/**
 * Created by Andreas on 2017-12-01.
 */

public class MyAccountRow extends AccountRegistrationRow {

    private CheckBox cb;
    private TextView tv;

    public MyAccountRow(Context context) {
        super(context);
    }

    public MyAccountRow(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyAccountRow(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyAccountRow(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void init() {
        inflate(this.getContext(), R.layout.my_account_registration_row, this);
        tv = findViewById(R.id.descriptiveText2);
        cb = findViewById(R.id.accountcheckbox);

        setAccountRegistrationValidator(new AccountRegistrationRowValidator() {
            @Override
            public boolean validate() {
                return false;
            }
        });
    }

    @Override
    public void setDescriptiveText(String descriptiveText) {
        super.setDescriptiveText(descriptiveText);
    }

    @Override
    public void setError(String errorMessage) {
        if(!isValid()){
            cb.setError(errorMessage);
        }
    }
}
