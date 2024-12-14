package com.coderscampus.assignment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class UserService {

    final User[] users = new User[10];

    public String getUserName(int index) {
        return users[index].getName();
    }

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

    public int isUserValid(String[] userInput) {

        for (int i = 0; i < users.length; i++) {
            if (!(users[i] == null)) {
                if ((userInput[0].equals(users[i].getUsername())) && (userInput[1].equals(users[i].getPassword())))
                    return i;
            }
        }
        return -1;
    }

}

