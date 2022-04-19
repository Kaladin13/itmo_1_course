package com.company.command;

import com.company.vehicle.Vehicle;

import java.io.Serializable;
import java.util.ArrayDeque;

public class ServerAnswerDTO implements Serializable {
    String answer;
    ArrayDeque<String> argument;
    ArrayDeque<Vehicle> vehicles;

    public ServerAnswerDTO(String answer, ArrayDeque<String> argument) {
        this.answer = answer;
        this.argument = argument;
    }

    public void setVehicles(ArrayDeque<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public ArrayDeque<Vehicle> getVehicles() {
        return vehicles;
    }

    public String getAnswer() {
        return answer;
    }

    public ArrayDeque<String> getArgument() {
        return argument;
    }

    public ServerAnswerDTO(String answer) {
        this.answer = answer;
    }
}
