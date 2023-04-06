package com.ethesis.studentService.domain.teacher;

/**
 * @author erfan
 * @since 4/2/23
 */
public enum Designation {
    PROFESSOR("Professor"),
    ASSISTANT_PROFESSOR("Assistant Professor"),
    LECTURER_I("Lecturer I"),
    LECTURER_II("Lecturer II"),
    LECTURER_III("Lecturer III");

    private String naturalName;

    Designation(String naturalName) {
        this.naturalName = naturalName;
    }

    public String getNaturalName() {
        return naturalName;
    }
}
