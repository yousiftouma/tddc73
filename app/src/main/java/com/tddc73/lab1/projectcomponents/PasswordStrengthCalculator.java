package com.tddc73.lab1.projectcomponents;

public interface PasswordStrengthCalculator {
    public PasswordStrengthMeter.PasswordStrength calculatePasswordStrength(String password);
}
