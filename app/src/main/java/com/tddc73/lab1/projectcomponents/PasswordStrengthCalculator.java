package com.tddc73.lab1.projectcomponents;

/**
 * Interface for calculating strength of a password
 */
public interface PasswordStrengthCalculator {
    /**
     * Calculate strength of password
     * @param password password to calculate strength of
     * @return a {@link com.tddc73.lab1.projectcomponents.PasswordStrengthMeter.PasswordStrength} enum value indicating the strength of the password
     */
    PasswordStrengthMeter.PasswordStrength calculatePasswordStrength(String password);
}
