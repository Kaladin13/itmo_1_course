package com.company.collection;

import java.util.ArrayDeque;

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

    public ArrayDeque<String> show() {
        return arrayList;
    }

}
