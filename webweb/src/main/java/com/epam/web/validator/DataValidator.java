package com.epam.web.validator;

public class DataValidator {
    private static final String EMAIL_REGEX = "([A-Za-z0-9_-]+\\.)*[A-Za-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}";
    private static final String PASSWORD_REGEX = "(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9@#$%]).{8,40}";
    public boolean isEmailValid(String email){
        if(email.matches(EMAIL_REGEX)){
            return true;
        }else {
            return false;
        }
    }
    public boolean isPasswordValid(String password){
        if(password.matches(PASSWORD_REGEX)){
            return true;
        }else {
            return false;
        }
    }

}
