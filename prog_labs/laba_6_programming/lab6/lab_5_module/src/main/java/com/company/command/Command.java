package com.company.command;

import com.company.vehicle.ParsedVehicle;

import java.io.Serializable;

public class Command implements Serializable {
    private CommandNames commandName;
    private String filename;
    private Long additionalParameter;
    private ParsedVehicle parsedVehicle;
    private UserDTO userDTO;

    public static UserDTO currentAuthorisedUser;

    public Command(CommandNames commandName, String filename) {
        this.commandName = commandName;
        this.filename = filename;
    }

    public Command(CommandNames commandName, UserDTO userDTO) {
        this.commandName = commandName;
        this.userDTO = userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public Command(CommandNames commandName, Long additionalParameter, ParsedVehicle parsedVehicle) {
        this.commandName = commandName;
        this.additionalParameter = additionalParameter;
        this.parsedVehicle = parsedVehicle;
    }

    public Command(CommandNames commandName, ParsedVehicle parsedVehicle) {
        this.commandName = commandName;
        this.parsedVehicle = parsedVehicle;
    }

    public Command(CommandNames commandName, Long additionalParameter) {
        this.commandName = commandName;
        this.additionalParameter = additionalParameter;
    }

    public Command(CommandNames commandName) {
        this.commandName = commandName;
    }

    public CommandNames getCommandName() {
        return commandName;
    }

    public String getFilename() {
        return filename;
    }

    public Long getAdditionalParameter() {
        return additionalParameter;
    }

    public ParsedVehicle getParsedVehicle() {
        return parsedVehicle;
    }
}
