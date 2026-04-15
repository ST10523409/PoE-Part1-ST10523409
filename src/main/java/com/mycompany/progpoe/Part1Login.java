


package com.mycompany.progpoe;

import java.util.*;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Part1Login {
    private String username;
    private String password;
    private String cellnumber;
    private String firstName;
    private String lastName;

    public Part1Login(String usern, String pswd, String cellnum, String fName, String lName) {
        username = usern;
        password = pswd;
        cellnumber = cellnum;
        firstName = fName;
        lastName = lName;
    }//end constructor
    
    public boolean checkUserName() {
        return username.contains("_") && username.length() <= 5;
    }//end checkUserName
    
    public boolean checkPasswordComplexity() {
        String regex = "^(?=.*[A-Z])(?=.*\\d)(?=.*[^A-Za-z0-9]).{8,}$";
        return Pattern.matches(regex, password);
    }//end checkPasswordComplexity
    
    public boolean checkCellNumber() {
        String regex = "^\\+27\\d{9}$";
        return Pattern.matches(regex, cellnumber);
        //Regex adapted from: https://stackoverflow.com/
    }//end checkCellNumber
    
    
    public String registerUser() {

    if (!checkUserName()) {
        return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
    }

    if (!checkPasswordComplexity()) {
        return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
    }

    if (!checkCellNumber()) {
        return "Cell phone number incorrectly formatted or does not contain international code.";
    }

    return "Registration successful.";
}//end register User
    
    public boolean loginUser(String inputUsername, String inputPassword) {
        return this.username.trim().equals(inputUsername.trim()) && this .password.trim().equals(inputPassword.trim());
    }//end loginUser
    
    
    public String returnLoginStatus(boolean loginSuccess) {
        if (loginSuccess) {
            return "Welcome " + firstName + " , " + lastName + " it is great to see you again. ";
        }//end if4 else 
        else {
            return "Username or password incorrect, please try again.";
        }//end else1
    }//end loginStatus
    
    
    
}//end class
