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
 * Component that handles entering of passwords and visualizes password strength.
 * Override calculatePasswordStrength to change algorithm for calculating password strength.
 */
public class PasswordStrengthMeter extends LinearLayout {

    private EditText editText;
    private ProgressBar progressBar;
    private TextView textView;
    private PasswordStrengthCalculator passwordStrengthCalculator;
    private PasswordStrength strength;


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
        inflate(getContext(), R.layout.password_strength, this);
        this.editText = findViewById(R.id.editTextPassword);
        this.progressBar = findViewById(R.id.passwordStrength);
        this.textView = findViewById(R.id.passwordStrengthText);
        strength = PasswordStrength.INVALID;

        // Standard implementation
        this.passwordStrengthCalculator = new PasswordStrengthCalculator() {
            @Override
            public PasswordStrength calculatePasswordStrength(String password) {
                int passwordLength = password.length();
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
        };

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

    /**
     * Updates this components views given the currently entered password.
     * @param userTypedPassword the current password
     */
    private void updatePasswordStrength(String userTypedPassword) {
        PasswordStrength ps = this.passwordStrengthCalculator.calculatePasswordStrength(userTypedPassword);
        strength = ps;
        switch(ps) {
            case INVALID:
                setViews(Color.BLACK, "INVALID", 0);
                break;
            case WEAK:
                setViews(Color.RED, "WEAK", 25);
                break;
            case MODERATE:
                setViews(Color.parseColor("#F4C20D"), "MODERATE", 50);
                break;
            case STRONG:
                setViews(Color.parseColor("#FFA500"), "STRONG", 75);
                break;
            case VERY_STRONG:
                setViews(Color.parseColor("#3CBA54"), "VERY STRONG", 100);
                break;
        }
    }

    /**
     * Sets the visual attributes of the components views.
     * @param color Color to set progressbar and accompanying text to
     * @param text Text that describes password strength
     * @param progress Percentage of progress bar to fill with param color
     */
    private void setViews(int color, String text, int progress) {
        textView.setTextColor(color);
        textView.setText(text);
        progressBar.setProgress(progress);
        progressBar.getProgressDrawable().setColorFilter(color, PorterDuff.Mode.MULTIPLY);
    }

    /**
     * Gets the currently entered password
     * @return the currently entered password
     */
    public String getPasswordText(){
        return editText.getText().toString();
    }

    public void setPasswordStrengthCalculator(PasswordStrengthCalculator passwordStrengthCalculator) {
        this.passwordStrengthCalculator = passwordStrengthCalculator;
    }

    public PasswordStrength getStrength() {
        return strength;
    }

    public void setError (String errorMessage){
        editText.setError(errorMessage);
    }

    /**
     * Enum that represents how strong a password is
     */
    public enum PasswordStrength{
        /**
         * Does not meet the criteria to be a password
         */
        INVALID,
        /**
         * A weak but acceptable password
         */
        WEAK,
        /**
         * An above acceptable password
         */
        MODERATE,
        /**
         * A good but not optimal password
         */
        STRONG,
        /**
         * A very strong password, nearly optimal
         */
        VERY_STRONG
    }
}
