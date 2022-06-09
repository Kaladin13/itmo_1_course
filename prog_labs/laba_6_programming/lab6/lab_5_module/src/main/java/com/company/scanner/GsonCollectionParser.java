package com.company.scanner;

import com.company.collection.comparators.VehicleCapacityComparator;
import com.company.collection.comparators.VehicleNameComparator;
import com.company.controller.Validator;
import com.company.vehicle.Vehicle;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Class, controlling parsing
 */
public class GsonCollectionParser {
    private FileReader fileReader;
    private FileWriter fileWriter;
    private File file;
    private Gson gson;

    public GsonCollectionParser() {};

    public void initGsonParser(String fileName) throws Exception {
        File file = new File(fileName);
        try {

            if (!file.exists()) {
                throw new Exception("File doesn't exist!");
            }
            if (!file.canRead()) {
                throw new Exception("File doesn't provide reading writes!");
            }
            if (!file.canWrite()) {
                throw new Exception("File doesn't provide writing writes!");
            }
        }
        catch (Exception e) {
            System.out.println("Error in work with file");
            System.out.println(e.getMessage());
            System.exit(1);
        }
        this.file = file;
//        this.fileWriter = new FileWriter(file, false);
        this.fileReader = new FileReader(file);
        this.gson = new Gson();
    }

    public void storeCollection(SortedSet<Vehicle> treeSet) {
        try {
            this.fileWriter = new FileWriter(file, false);
            this.gson.toJson(treeSet, this.fileWriter);
            this.fileWriter.close();
        } catch (Exception e) {
            System.out.println("Error in saving files");
        }
    }

    public TreeSet<Vehicle> getCollection() {

        Comparator<Vehicle> comparator = new VehicleNameComparator().
                thenComparing(new VehicleCapacityComparator());
        TreeSet<Vehicle> treeSet = new TreeSet<>(comparator);

        try {
            JsonReader reader = new JsonReader(this.fileReader);
            if (!reader.hasNext()) {
                return treeSet;
            }
            Vehicle[] vehicles = this.gson.fromJson(reader, Vehicle[].class);
            if (vehicles == null || vehicles.length == 0) {
                return treeSet;
            }
            for (Vehicle vehicle1: vehicles) {
                if (!Validator.isValidVehicle(vehicle1)) {
                    System.out.println("Bad data in file");
                    throw new Exception("Bad data");
                }
            }
            treeSet.addAll(Arrays.asList(vehicles));
        } catch (Exception e) {
            System.out.println("Error in getting files");
        }
        return treeSet;
    }

}
