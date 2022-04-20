package com.company.collection;

import java.util.ArrayDeque;
import java.util.Iterator;

public class HistoryStack implements Iterable<String> {
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

    public static void main(String[] args) {
        for (String s : new HistoryStack()) {

        }
    }

    @Override
    public Iterator iterator() {
        return arrayList.iterator();
    }
}
