package com.company;

import com.company.scanner.InputParser;
import com.company.scanner.InputSource;

public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("vehicle collection");
//        InputParser inputParser = new InputParser(InputSource.FILE, "test.txt");
        InputParser inputParser = new InputParser(InputSource.CONSOLE);
        System.out.println(inputParser.getScanner().nextLong());
        System.out.println(inputParser.getScanner().nextLong());
        String[] a = "aa".split(" ");
        System.out.println(a[0]);
    }
}
