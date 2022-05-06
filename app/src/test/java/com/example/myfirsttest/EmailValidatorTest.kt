package com.example.myfirsttest

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class EmailValidatorTest {

    @Test
    fun emailValidator_CorrectEmailSimple_ReturnsTrue() {
        assertTrue(EmailValidator.isValidEmail("name@email.com"))
    }

    @Test
    fun emailValidator_CorrectEmailSubDomain_ReturnsTrue() {
        assertTrue(EmailValidator.isValidEmail("name@email.co.uk"))
    }

    @Test
    fun emailValidator_InvalidEmailNoTld_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("name@email"))
    }

    @Test
    fun emailValidator_InvalidEmailDoubleDot_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("name@email..com"))
    }

    @Test
    fun emailValidator_InvalidEmailNoUsername_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("@email.com"))
    }

    @Test
    fun emailValidator_EmptyString_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail(""))
    }

    @Test
    fun emailValidator_NullEmail_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail(null))
    }

    @Test
    fun emailValidator_InvalidEmailNoDomain_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("name@"))
    }

    @Test
    fun emailValidator_InvalidEmailDoubleAtSign_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("name@@mail.com"))
    }

    @Test
    fun emailValidator_InvalidEmailNoAtSign_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("name.mail.com"))
    }

    @Test
    fun emailValidator_InvalidEmailStartingWithSpace_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail(" name@mail.com"))
    }

    @Test
    fun emailValidator_InvalidEmailIncorrectUsername_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("user*name@mail.com"))
    }

    @Test
    fun emailValidator_InvalidEmailTooLongUsername_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("username_username_username_username_username_" +
                "username_username_username_username_username_username_username_username_username_" +
                "username_username_username_username_username_username_username_username_username_" +
                "username_username_username_username_username_username_username_username_username_" +
                "username_username_username_username_username_username_username_username_username_" +
                "username_username_username_username_username_username_username_username_username_" +
                "username_username_username_username_username_username_username_username_@mail.com"))
    }
}
