package com.coderscampus.assignment;

import java.io.IOException;
import java.util.Scanner;

public class UserLoginApplication {

    public static void main(String[] args) throws IOException {
        User[] users;
        String[] userInput;
        int numberOfPrompts = 0;
        int validUserIndex = -1;
        String fileName = "./data.txt";
        users = UserService.getUsersInformation(fileName);

        while ((validUserIndex < 0) && (numberOfPrompts < 5)) {
            userInput = getUsernamePassword();
            validUserIndex = isUserValid(userInput, users);
            numberOfPrompts++;
            if ((validUserIndex < 0) && (numberOfPrompts < 4)) {
                System.out.println("Invalid username/password.");
            }
        }
        if (validUserIndex > 0) {
            System.out.println("Welcome "+ users[validUserIndex].getName() + "!");
        } else {
            System.out.println("Too many failed login attempts, you are now locked out.");
        }

    }

    private static int isUserValid(String[] userInput, User[] users) {

        for (int i = 0; i < users.length; i++) {
            if (!(users[i] == null)) {
                if ((userInput[0].equals(users[i].getUsername())) && (userInput[1].equals(users[i].getPassword()))) return i;
            }
        }
        return -1;
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
