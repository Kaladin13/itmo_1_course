package com.company.scanner;

import java.io.File;
import java.util.Scanner;

public class InputParser {
    private final Scanner scanner;
    private final InputSource inputSource;

    public InputParser(InputSource inputSource) throws Exception {
        this.inputSource = inputSource;
        if (this.inputSource.equals(InputSource.CONSOLE)) {
            this.scanner = new Scanner(System.in);
        }
        else {
            throw new Exception("File reader without file name!");
        }
    }

    public InputParser(InputSource inputSource, String fileName) throws Exception {
        this.inputSource = inputSource;
        File file = new File(fileName);
        if (!this.inputSource.equals(InputSource.FILE) || fileName.equals("")) {
            throw new Exception("Scanner with file name can only be file-reader!");
        }
        if (!file.exists()) {
            throw new Exception("File doesn't exist!");
        }
        if (!file.canRead()) {
            throw new Exception("File doesn't provide reading writes!");
        }
        this.scanner = new Scanner(file);
    }

    public Scanner getScanner() {
        return scanner;
    }

    public InputSource getInputSource() {
        return inputSource;
    }
}
