package com.company;

import com.company.vechile.Vehicle;
import com.company.vechile.VehicleParser;
import com.company.vechile.comparators.VehicleNameComparator;
import com.company.vechile.comparators.VehicleNumberOfWheelsComparator;

import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public class VehicleService {
    private TreeSet<Vehicle> treeSet;
    private VehicleParser vehicleParser;

    public VehicleService() {
        Comparator<Vehicle> comparator = new VehicleNameComparator().
                thenComparing(new VehicleNumberOfWheelsComparator());
        this.treeSet = new TreeSet<>(comparator);
        this.vehicleParser = new VehicleParser();
    }

    public void startService() {
        Scanner scanner = new Scanner(System.in);

        String nextCommand;
        String lineCommand;
        while (true) {
            lineCommand = scanner.nextLine();
            int i = lineCommand.indexOf(' ');
            nextCommand = lineCommand.substring(0, i);
            switch (nextCommand) {
                case ("help"):
                    System.out.println("help for commands");
                    break;
                case ("info"):
                    System.out.println("aaa");
                    break;
                case ("show"):
                    this.treeSet.forEach(s -> System.out.println(s.toString()));
                    break;
                case ("add"):
                    this.treeSet.add(vehicleParser.parseVehicle());
                    break;
            }
        }
    }
}
