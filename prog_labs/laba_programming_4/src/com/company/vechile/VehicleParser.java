package com.company.vechile;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Objects;
import java.util.Scanner;

public class VehicleParser {

    private Scanner scanner;


    private long getOptionalLong(String fieldName) {
        long field = 0;
        while (true) {
            System.out.println("Enter " + fieldName + "(nullable)");
            String line;
            line = scanner.nextLine();
            try {
                if (Objects.equals(line, "")) {
                    field = 0;
                    return field;
                }
                field = Long.parseLong(line);
            }
            catch (Exception e) {
                System.out.println("Enter correct data");
            }
            if (field > 0) {
                return field;
            }
        }
    }

    private String getOptionalString(String fieldName) {
        String field;
        System.out.println("Enter " + fieldName + "(nullable)");
        field = scanner.nextLine();
        return field;
    }

    private String getNotNullString(String fieldName) {
        String name;
        while (true) {
            System.out.println("Enter " + fieldName + "(not null)");
            name = scanner.nextLine();
            if (Objects.equals(name, "")) {
                System.out.println("Field is not null!");
            } else {
                return name;
            }
        }
    }

    private long getNotNullLong(String fieldName) {
        long field = 0;
        while (true) {
            System.out.println("Enter " + fieldName + "(nullable)");
            String line;
            line = scanner.nextLine();
            try {
                if (Objects.equals(line, "")) {
                    System.out.println("Field is not null!");
                    continue;
                }
                field = Long.parseLong(line);
            }
            catch (Exception e) {
                System.out.println("Enter correct data");
            }
            if (field > 0) {
                return field;
            }
        }
    }

    public Vehicle parseVehicle() {

        Vehicle vehicle = new Vehicle();
        String name;


        return vehicle;
    }
}
