package de.hhbk.de.cb.model;

import java.util.Map;
import java.util.UUID;

/**
 * Created by dominik on 13.10.15.
 *
 * Lesson ist eine einzelne Unterrichtseinheit eines Faches, quasi die Schulstunde. Der Schultag setzt sich aus Lessons zusammen.
 */
public class Lesson {
    private UUID id;
    private String date;
    private SchoolSubject subject;
    private SchoolClass schoolClass;
    private Map<Pupil, Boolean> presenceMap;

    public Lesson(String date, SchoolSubject subject, SchoolClass schoolClass, Map<Pupil, Boolean> presenceMap) {
        this.id = UUID.randomUUID();
        this.date = date;
        this.subject = subject;
        this.schoolClass = schoolClass;
        this.presenceMap = presenceMap;
    }
    public UUID getID() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public SchoolSubject getSubject() {
        return subject;
    }

    public void setSubject(SchoolSubject subject) {
        this.subject = subject;
    }

    public SchoolClass getSchoolClass() {
        return schoolClass;
    }

    public void setSchoolClass(SchoolClass schoolClass) {
        this.schoolClass = schoolClass;
    }

    public Map<Pupil, Boolean> getPresenceMap() {
        return presenceMap;
    }

    public void setPresenceMap(Map<Pupil, Boolean> presenceMap) {
        this.presenceMap = presenceMap;
    }
}
