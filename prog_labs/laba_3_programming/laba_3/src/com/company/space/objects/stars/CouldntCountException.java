package com.company.space.objects.stars;

public class CouldntCountException extends Exception{

    public CouldntCountException(String message) {
        super(message);
    }

    public CouldntCountException(Throwable cause) {
        super(cause);
    }
}
