package de.hhbk.de.cb.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by admin on 29.09.15.
 *
 * Hält die Schüler und die Fächer (subjects) der Klasse.
 */
public class SchoolClass {
    private UUID id;
    private String classname;
    private List<Pupil> pupils;
    private List<SchoolSubject> subjects;

    public SchoolClass(String classname) {
        this.id = UUID.randomUUID();
        this.classname = classname;
        this.pupils = new ArrayList<Pupil>();
        this.subjects = new ArrayList<SchoolSubject>();
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

    public String[] getNameOfPupils() {
        String[] values = new String[this.getNumberOfPupils()];
        List<Pupil> pupils = this.getPupils();
        for(int i = 0; i<this.getNumberOfPupils(); i++) {
            values[i] = pupils.get(i).getForname() +" "+ pupils.get(i).getLastname();
        }
        return values;
    }

    public void addSchoolSubject(SchoolSubject subject) {
        this.subjects.add(subject);
    }

    public List<SchoolSubject> getSubjects() {
        return subjects;
    }
}
