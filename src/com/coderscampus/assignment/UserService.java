package com.coderscampus.assignment;

public class UserService {
    public static void main(String[] args) {
        String[] stringInput = new String[]{"aUsername", "aPassword", "aName"};
        User user = createUser(stringInput);
        System.out.println("Username: " + user.getUsername());
        System.out.println("Password: " + user.getPassword());
        System.out.println("Name: " + user.getName());


    }

    public static User createUser(String[] stringInput) {
        User user = new User();
        user.setUsername(stringInput[0]);
        user.setPassword(stringInput[1]);
        user.setName(stringInput[2]);
        return user;
    }
}