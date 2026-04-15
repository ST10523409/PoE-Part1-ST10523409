

package com.mycompany.progpoe;
import java.util.*;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Part1Main {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        
        System.out.println("------REGISTRATION------");
        
        System.out.println("Enter first name: ");
        String firstName = scanner.nextLine();
        
        System.out.println("Enter last name: ");
        String lastName = scanner.nextLine();
        
        System.out.println("Enter username: ");
        String username = scanner.nextLine();
        
        System.out.println("Enter password: ");
        String password = scanner.nextLine();
        
        System.out.println("Enter cellphone number (e.g. +27831234567: ");
        String cellphonenum = scanner.nextLine();
        
        
        Part1Login user = new Part1Login(username, password, cellphonenum, firstName, lastName);
        
        String registrationMessage = user.registerUser();
        System.out.println(registrationMessage);
        
        System.out.println("\n------LOGIN------");
        
        System.out.println("Enter username: ");
        String loginUsername = scanner.nextLine();
        
        System.out.println("Enter password: ");
        String loginPassword = scanner.nextLine();
        
        boolean loginSuccess = user.loginUser(loginUsername, loginPassword);
        
        String loginMessage = user.returnLoginStatus(loginSuccess);
        System.out.println(loginMessage);
        
        scanner.close();
    }//end main
}//end class
