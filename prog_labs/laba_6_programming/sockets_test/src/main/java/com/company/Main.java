package com.company;

import com.opencsv.bean.CsvToBeanBuilder;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import main.java.com.company.Country;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayDeque;
import java.util.List;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        String filename = "file.csv";

        List<Country> beans = new CsvToBeanBuilder(new FileReader(filename))
                .withType(Country.class)
                .build()
                .parse();

        beans.forEach(System.out::println);

//        c.forEach(System.out::println);
    }
}
