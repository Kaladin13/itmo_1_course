package com.company.scanner;

public class GsonParserSingleton {
    static private GsonCollectionParser gsonCollectionParser;

    static public GsonCollectionParser getGsonCollectionParser() {
        if (gsonCollectionParser == null) {
            gsonCollectionParser = new GsonCollectionParser();
        }
        return gsonCollectionParser;
    }

    private GsonParserSingleton(){};
}
