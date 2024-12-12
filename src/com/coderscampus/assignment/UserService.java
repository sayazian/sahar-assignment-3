package com.coderscampus.assignment;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class UserService {

    public static User createUser(String[] stringInput) {
        User user = new User();
        user.setUsername(stringInput[0]);
        user.setPassword(stringInput[1]);
        user.setName(stringInput[2]);
        return user;
    }

    public static String[] parseText(String input) {
        return input.split(",");
    }

    public static User[] getUsersInformation(String fileName) throws IOException {
        User[] users = new User[10];
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        int counter = 0;

        while ((line = bufferedReader.readLine()) != null) {
            String[] userInfo = parseText(line);
            users[counter] = createUser(userInfo);
            System.out.println(users[counter].toString());
            counter++;
        }
        return users;
    }

}

