package com.coderscampus.assignment;

import java.io.IOException;

public class UserLoginApplication {

    public static void main(String[] args) throws IOException {
        String fileName = "./data.txt";
        UserService userService = new UserService();
        userService.loadUsersInformation(fileName);
        userService.promptTheUser(userService);
    }

}
