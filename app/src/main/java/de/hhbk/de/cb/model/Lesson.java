package de.hhbk.de.cb.model;

/**
 * Created by dominik on 13.10.15.
 *
 * Lesson ist eine einzelne Unterrichtseinheit eines Faches, quasi die Schulstunde. Der Schultag setzt sich aus Lessons zusammen.
 */
public class Lesson {
    private String date;
    private Lesson lesson;
    private SchoolClass schoolClass;

    public Lesson(String date, Lesson lesson, SchoolClass schoolClass) {
        this.date = date;
        this.lesson = lesson;
        this.schoolClass = schoolClass;
    }
}
