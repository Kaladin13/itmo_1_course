package com.company.controller;

import com.company.command.UserDTO;
import com.company.scanner.InputParser;
import com.company.scanner.InputSource;

public class UserParser {
    private InputParser inputParser;

    public UserParser() throws Exception {
        this.inputParser = new InputParser(InputSource.CONSOLE);
    }

    public UserDTO getUserData() {
        try {
            String login = this.parseLogin();
            String password = this.parsePassword();
            return new UserDTO(login, password);
        }
        catch (Exception e) {
            System.out.println("Critical Error in user input!");
            System.exit(1);
            return null;
        }
    }


    public String parseLogin() {
        String login;
        while (true) {
            try {
                System.out.println("Enter your login");
                login = this.inputParser.getScanner().nextLine();
                if (login.isEmpty() || login.trim().isEmpty()) {
                    System.out.println("Incorrect");
                    continue;
                }
                if (login.length() < 5 || login.length()>255) {
                    System.out.println("Incorrect, login should be >= 5 symbols");
                    continue;
                }
            }
            catch (Exception e) {
                System.out.println("Incorrect");
                this.inputParser.getScanner().nextLine();
                continue;
            }
            return login;
        }
    }

    public String parsePassword() {
        String password;
        while (true) {
            try {
                System.out.println("Enter your password");
                password = this.inputParser.getScanner().nextLine();
                if (password.isEmpty() || password.trim().isEmpty()) {
                    System.out.println("Incorrect");
                    continue;
                }
                if (password.length() < 7 || password.length()>255) {
                    System.out.println("Incorrect, password should be >= 7 symbols");
                    continue;
                }
            }
            catch (Exception e) {
                System.out.println("Incorrect");
                this.inputParser.getScanner().nextLine();
                continue;
            }
            return password;
        }
    }
}
