package com.teenthofabud.dsa.datastructures;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DataStructureException extends Exception {

    private String message;

    public DataStructureException(String message) {
        super(message);
        this.message = message;
    }

}
