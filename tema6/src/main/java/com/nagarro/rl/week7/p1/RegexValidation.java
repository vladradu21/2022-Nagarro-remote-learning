package com.nagarro.rl.week7.p1;

public class RegexValidation {

    private static final String EMAIL_REGEX = "^[^@]+@[^@.]+\\.[a-zA-Z]{2,3}$";
    private static final String PASSWORD_REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[!\"#$%&'()*+,-./:;<=>?@[\\\\]^_`{|}~])[a-zA-Z0-9!\"#$%&'()*+,-./:;<=>?@[\\\\]^_`{|}~]{10,}$";
    private static final String PHONENUMBER_REGEX = "^(\\+|00)?\\d{1,3}\\d{9}$";

    public static boolean validateEmail(String email) {
        return email.matches(EMAIL_REGEX);
    }

    public static boolean validatePassword(String password) {
        return password.matches(PASSWORD_REGEX);
    }

    public static boolean validatePhoneNumber(String phoneNumber) {
        return phoneNumber.matches(PHONENUMBER_REGEX);
    }



}
