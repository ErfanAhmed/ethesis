package com.ethesis.studentService.domain.thesis;

/**
 * @author erfan
 * @since 4/3/23
 */
public enum ThesisRequestStatus {
    SENT("Sent"),
    ACCEPTED("Accepted"),
    REJECTED("Rejected"),
    DELETED("Deleted");

    private String naturalName;

    ThesisRequestStatus(String naturalName) {
        this.naturalName = naturalName;
    }

    public String getNaturalName() {
        return naturalName;
    }
}
