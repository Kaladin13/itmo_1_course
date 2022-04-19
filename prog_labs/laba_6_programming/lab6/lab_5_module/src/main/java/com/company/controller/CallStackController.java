package com.company.controller;

import java.util.ArrayList;
import java.util.List;

/**
 * Call stack for rec control
 */
public class CallStackController {
    static private final List<String> arrayList = new ArrayList<>();


    static public boolean addCall(String st) {

        if (arrayList.contains(st)) {
            System.out.println("Recursion!");
            return false;
        }
        arrayList.add(st);
        return true;
    }
}
