package de.hhbk.de.cb;

import java.util.UUID;

/**
 * Created by admin on 28.09.15.
 */
public class Pupil {
    UUID id;
    private String forname;
    private String lastname;
    private Schoolclass schoolclass;

    public Pupil() {
        this.id = UUID.randomUUID();
    }

    public String getForname() {
        return forname;
    }

    public void setForname(String forname) {
        this.forname = forname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Schoolclass getSchoolclass() {
        return schoolclass;
    }

    public void setSchoolclass(Schoolclass schoolclass) {
        this.schoolclass = schoolclass;
    }

    public UUID getId() {
        return id;
    }
}
