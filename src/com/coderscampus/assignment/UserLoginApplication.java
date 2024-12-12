package com.coderscampus.assignment;

import java.io.IOException;
import java.util.Scanner;

public class UserLoginApplication {

    public static void main(String[] args) throws IOException {
        User[] users;
        String[] userInput = new String[]{};
        int numberOfPrompts = 0;
        boolean validUser = false;
        String fileName = "./data.txt";
        users = UserService.getUsersInformation(fileName);

        while ((!validUser) && (numberOfPrompts < 5)) {
            userInput = getUsernamePassword();
            validUser = isUserValid(userInput, users);
            numberOfPrompts++;
            if ((!validUser) && (numberOfPrompts < 4)) {
                System.out.println("Invalid username/password.");
            }
        }
        if (validUser) {
            welcomeUser(userInput, users);
        } else {
            System.out.println("Too many failed login attempts, you are now locked out.");
        }

    }

    private static void welcomeUser(String[] userInput, User[] users) {
        System.out.println("Welcome!");
    }

    private static boolean isUserValid(String[] userInput, User[] users) {

        for (User user : users) {
            if (!(user == null)) {
                if ((userInput[0].equals(user.getUsername())) && (userInput[1].equals(user.getPassword()))) return true;
            }
        }
        return false;
        }

        private static String[] getUsernamePassword () {
            String[] userInput = new String[2];
            Scanner input = new Scanner(System.in);
            System.out.println("Enter your email:");
            userInput[0] = input.nextLine();
            System.out.println("Enter your password:");
            userInput[1] = input.nextLine();
            return userInput;
        }
    }
