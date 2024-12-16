package com.coderscampus.assignment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class UserService {

    final User[] users = new User[10];

    public User createUser(String[] stringInput) {
        User user = new User();
        user.setUsername(stringInput[0]);
        user.setPassword(stringInput[1]);
        user.setName(stringInput[2]);
        return user;
    }

    public void loadUsersInformation(String fileName) throws IOException {
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        int counter = 0;

        while ((line = bufferedReader.readLine()) != null) {
            String[] userInfo = parseText(line);
            users[counter] = createUser(userInfo);
            counter++;
        }
    }

    private static String[] parseText(String input) {
        return input.split(",");
    }

    public User isUserValid(String[] userInput) {

        for (User user : users) {
            if (!(user == null)) {
                if ((userInput[0].equalsIgnoreCase(user.getUsername())) && (userInput[1].equals(user.getPassword())))
                    return user;
            }
        }
        return null;
    }

    public void promptTheUser(UserService userService) {
        Scanner input = new Scanner(System.in);
        String[] userInput;
        int numberOfPrompts = 0;
        User validUser = null;

        while ((validUser == null) && (numberOfPrompts < 5)) {
            numberOfPrompts++;
            userInput = getUsernamePassword(input);
            validUser = userService.isUserValid(userInput);
            if ((validUser == null) && (numberOfPrompts < 4)) {
                System.out.println("Invalid username/password.");
            }
        }
        if (validUser != null) {
            System.out.println("Welcome " + validUser.getName() + "!");
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

