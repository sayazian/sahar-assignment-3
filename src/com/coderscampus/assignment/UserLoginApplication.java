package com.coderscampus.assignment;

import java.io.IOException;
import java.util.Scanner;

public class UserLoginApplication {

    public static void main(String[] args) throws IOException {
        String fileName = "./data.txt";
        UserService userService = new UserService();
        userService.loadUsersInformation(fileName);
        promptTheUser(userService);
    }

    private static void promptTheUser(UserService userService) {
        Scanner input = new Scanner(System.in);
        String[] userInput;
        int numberOfPrompts = 0;
        int validUserIndex = -1;

        while ((validUserIndex < 0) && (numberOfPrompts < 5)) {
            numberOfPrompts++;
            userInput = getUsernamePassword(input);
            validUserIndex = userService.isUserValid(userInput);
            if ((validUserIndex < 0) && (numberOfPrompts < 4)) {
                System.out.println("Invalid username/password.");
            }
        }
        if (validUserIndex > 0) {
            System.out.println("Welcome " + userService.getUserName(validUserIndex) + "!");
        } else {
            System.out.println("Too many failed login attempts, you are now locked out.");
        }
        input.close();
    }

    private static String[] getUsernamePassword(Scanner input) {
        String[] userInput = new String[2];
        System.out.println("Enter your email:");
        userInput[0] = input.nextLine();
        System.out.println("Enter your password:");
        userInput[1] = input.nextLine();
        return userInput;
    }

}
