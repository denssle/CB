package de.hhbk.de.cb.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by dominik on 14.10.15.
 *
 * Das Schulfach. Hält alle bisher stattgefunden Schulstunden, die Lessons.
 */
public class SchoolSubject {
    private UUID id;
    private String subjectName;
    private SchoolClass schoolClass;
    private List<Lesson> lessons;

    public SchoolSubject(String name, SchoolClass schoolClass) {
        this.id = UUID.randomUUID();
        this.subjectName = name;
        this.lessons = new ArrayList<Lesson>();
        this.schoolClass = schoolClass;
    }

    public UUID getID() {
        return id;
    }

    public String getName() {
        return subjectName;
    }
}
