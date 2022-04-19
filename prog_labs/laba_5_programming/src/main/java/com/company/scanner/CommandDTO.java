package com.company.scanner;

public class CommandDTO {
    private String commandName;
    private Object commandArgument;

    public String getCommandName() {
        return commandName;
    }

    public Object getCommandArgument() {
        return commandArgument;
    }

    public CommandDTO(String commandName, Object commandArgument) {
        this.commandName = commandName;
        this.commandArgument = commandArgument;
    }
}
