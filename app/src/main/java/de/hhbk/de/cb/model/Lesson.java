package de.hhbk.de.cb.model;

/**
 * Created by dominik on 13.10.15.
 */
public class Lesson {
    private String date;
    private String lessonName;
    private SchoolClass schoolClass;

    public Lesson(String date, String lessonName, SchoolClass schoolClass) {
        this.date = date;
        this.lessonName = lessonName;
        this.schoolClass = schoolClass;
    }
}
