package com.mycompany.mavenproject2;

import java.util.regex.Pattern;

public class Login {

    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String cellPhoneNumber;

    public Login(String firstName, String lastName, String username,
                 String password, String cellPhoneNumber) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.cellPhoneNumber = cellPhoneNumber;
    }

    public Boolean checkUserName() {
        return username != null
                && username.contains("_")
                && username.length() <= 5;
    }

    public Boolean checkPasswordComplexity() {

        if (password == null || password.length() < 8) {
            return false;
        }

        boolean hasCapital =
                Pattern.compile("[A-Z]").matcher(password).find();

        boolean hasNumber =
                Pattern.compile("[0-9]").matcher(password).find();

        boolean hasSpecial =
                Pattern.compile("[^a-zA-Z0-9]").matcher(password).find();

        return hasCapital && hasNumber && hasSpecial;
    }

    public Boolean checkCellPhoneNumber() {

        if (cellPhoneNumber == null) {
            return false;
        }

        return Pattern.matches(
                "^\\+27[0-9]{9}$",
                cellPhoneNumber
        );
    }

    public String registerUser() {

        if (!checkUserName()) {
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        }

        if (!checkPasswordComplexity()) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }

        if (!checkCellPhoneNumber()) {
            return "Cell phone number incorrectly formatted or does not contain international code.";
        }

        return "User registered successfully.";
    }

    public Boolean loginUser(String enteredUsername,
                              String enteredPassword) {

        return username != null
                && password != null
                && username.equals(enteredUsername)
                && password.equals(enteredPassword);
    }

    public String returnLoginStatus(String enteredUsername,
                                     String enteredPassword) {

        if (loginUser(enteredUsername, enteredPassword)) {
            return "Welcome " + firstName + ", " + lastName
                    + " it is great to see you again.";
        }

        return "Username or password incorrect, please try again.";
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getCellPhoneNumber() {
        return cellPhoneNumber;
    }
}
