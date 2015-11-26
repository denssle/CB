package de.hhbk.de.cb.model;

import java.util.Map;
import java.util.UUID;

/**
 * Created by admin on 28.09.15.
 */
public class Pupil {
    private UUID id;
    private String forname;
    private String lastname;
    private SchoolClass schoolClass;
    private Map<Lesson, Boolean> presenceList;

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

    public SchoolClass getSchoolClass() {
        return schoolClass;
    }

    public void setSchoolClass(SchoolClass schoolClass) {
        this.schoolClass = schoolClass;
    }

    public UUID getId() {
        return id;
    }
}
