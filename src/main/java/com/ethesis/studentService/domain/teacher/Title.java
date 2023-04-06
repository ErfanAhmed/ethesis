package com.ethesis.studentService.domain.teacher;

/**
 * @author erfan
 * @since 4/2/23
 */
public enum Title {

    SUPERVISOR("Supervisor"),
    CO_SUPERVISOR("Co-Supervisor");

    private String naturalName;

    Title(String naturalName) {
        this.naturalName = naturalName;
    }

    public String getNaturalName() {
        return naturalName;
    }
}
