package com.eggur.task.exception;

import java.io.IOException;

public class InvalidStringException extends RuntimeException {

    public InvalidStringException(String msg){
        super(msg);
    }

}
