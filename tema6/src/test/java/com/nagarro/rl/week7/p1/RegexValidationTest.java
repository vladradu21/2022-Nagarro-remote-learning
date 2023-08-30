package com.nagarro.rl.week7.p1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

class RegexValidationTest {

    @ParameterizedTest
    @ValueSource(strings = {"vlad@mail.com", "vlad.ionescu@mail.com"})
    void testValidateEmailValidEmail(String email) {
        assertTrue(RegexValidation.validateEmail(email));
    }

    @ParameterizedTest
    @ValueSource(strings = {"vlad@", "vlad.com", "vlad@radu"})
    void testValidateEmailInvalidEmail(String email) {
        Assertions.assertFalse(RegexValidation.validateEmail(email));
    }

    @Test
    void testValidatePasswordValidPassword() {
        assertTrue(RegexValidation.validatePassword("P@ssword123"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"password", "P@ssword"})
    void testValidatePasswordInvalidPassword(String password) {
        assertFalse(RegexValidation.validatePassword(password));
    }

    @ParameterizedTest
    @ValueSource(strings = {"+40722123456", "0040722123456", "0722123456"})
    void testValidatePhoneNumberValidPhoneNumber(String phoneNumber) {
        assertTrue(RegexValidation.validatePhoneNumber(phoneNumber));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1234", "+1555555123456", "+123", "0040722123456789"})
    void testValidatePhoneNumberInvalidPhoneNumber(String phoneNumber) {
        assertFalse(RegexValidation.validatePhoneNumber(phoneNumber));
    }
}
