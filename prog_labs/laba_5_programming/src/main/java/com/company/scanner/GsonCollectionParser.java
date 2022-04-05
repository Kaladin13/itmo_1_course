package com.company.scanner;

import com.company.collection.comparators.VehicleCapacityComparator;
import com.company.collection.comparators.VehicleNameComparator;
import com.company.vehicle.Vehicle;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

public class GsonCollectionParser {
    private FileReader fileReader;
    private FileWriter fileWriter;
    private Gson gson;

    public GsonCollectionParser() {};

    public void initGsonParser(String fileName) throws Exception {
        File file = new File(fileName);

        if (!file.exists()) {
            throw new Exception("File doesn't exist!");
        }
        if (!file.canRead()) {
            throw new Exception("File doesn't provide reading writes!");
        }

        this.fileWriter = new FileWriter(file);
        this.fileReader = new FileReader(file);
        this.gson = new Gson();
    }

    public void storeCollection(TreeSet<Vehicle> treeSet) {
        try {
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
            Vehicle[] vehicles = this.gson.fromJson(reader, Vehicle[].class);
            treeSet.addAll(Arrays.asList(vehicles));
        } catch (Exception e) {
            System.out.println("error:.., " + e);
            System.out.println("Error in getting files");
        }
        return treeSet;
    }

}
