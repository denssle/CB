package de.hhbk.de.cb.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dominik on 14.10.15.
 *
 * Das Schulfach. Hält alle bisher stattgefunden Schulstunden, die Lessons.
 */
public class SchoolSubject {
    private String subjectName;
    private SchoolClass schoolClass;
    private List<Lesson> lessons;

    public SchoolSubject(String name, SchoolClass schoolClass) {
        this.subjectName = name;
        this.lessons = new ArrayList<Lesson>();
        this.schoolClass = schoolClass;
    }

    public String getName() {
        return subjectName;
    }
}
