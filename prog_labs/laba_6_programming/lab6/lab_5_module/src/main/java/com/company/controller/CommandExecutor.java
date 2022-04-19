package com.company.controller;

public interface CommandExecutor {
    void helpCommand();
    void infoCommand();
    void showCommand();
    void addCommand(Object obj);
    void updateCommand(Object obj);
    void removeCommand(Object obj);
    void clearCommand();
    void removeGreaterCommand(Object obj);
    void removeLowerCommand(Object obj);
    void greaterPowerCommand(Object obj);
    void greaterCapacityCommand(Object obj);
    void wheelsOrderCommand();
    void historyCommand();
    void executeCommand(Object obj);
    void exitCommand();

}
