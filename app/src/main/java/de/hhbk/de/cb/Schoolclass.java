package de.hhbk.de.cb;

import java.util.List;
import java.util.UUID;

/**
 * Created by admin on 29.09.15.
 */
public class Schoolclass {
    private UUID id;
    private String classname;
    private List pupils;

    public Schoolclass(String classname) {
        this.id = UUID.randomUUID();
        this.classname = classname;
    }
}
