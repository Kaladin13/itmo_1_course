package com.company.controller.dao;

import com.company.command.UserDTO;

public class UserService {
    private final UserDAO userDAO = new UserDAO();

    public void saveUser(UserDTO userDTO) {
        userDAO.save(userDTO);
    }

    public boolean checkIfLoginExists(String login) {
        return userDAO.checkIfLoginExists(login);
    }

    public boolean checkIfCorrectUserData(UserDTO userDTO) {
        return userDAO.contains(userDTO);
    }

    public UserDTO getUser(UserDTO userDTO) {
        return userDAO.get(userDTO);
    }
}
