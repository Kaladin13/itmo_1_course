package com.company.collection;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class HistoryStack {
    private ArrayDeque<String> arrayList;

    public HistoryStack() {
        this.arrayList = new ArrayDeque<>();
    }

    public void add(String s) {
        if (arrayList.size() >=12) {
            arrayList.removeFirst();
        }
        arrayList.add(s);
    }

    public void show() {
        System.out.println(this.arrayList);
    }

}
