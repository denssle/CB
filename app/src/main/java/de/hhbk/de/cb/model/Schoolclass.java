package de.hhbk.de.cb.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by admin on 29.09.15.
 */
public class Schoolclass {
    private UUID id;
    private String classname;
    private List<Pupil> pupils;

    public Schoolclass(String classname) {
        this.id = UUID.randomUUID();
        this.classname = classname;
        this.pupils = new ArrayList<Pupil>();
    }
    public UUID getID() {
        return id;
    }
    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public List<Pupil> getPupils() {
        return pupils;
    }

    public void addPupil(Pupil pupil) {
        this.pupils.add(pupil);
    }

    public int getNumberOfPupils() {
        return pupils.size();
    }
}
