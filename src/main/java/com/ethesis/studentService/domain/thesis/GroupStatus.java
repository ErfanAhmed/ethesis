package com.ethesis.studentService.domain.thesis;

/**
 * @author erfan
 * @since 4/2/23
 */
public enum GroupStatus {
    PENDING("Pending"),
    ACTIVE("Active"),
    PROPOSAL_SENT("Proposal Sent"),
    PROPOSAL_ACCEPTED("Proposal Accepted"),
    IN_PROGRESS("In progress"),
    THESIS_COMPLETED("Thesis Completed"),
    CLOSED("Closed"), // advisor can close a group for various valid/legal reason
    DELETED("Deleted"); // delete a mistakenly created group

    public String naturalName;

    GroupStatus(String naturalName) {
        this.naturalName = naturalName;
    }

    public String getNaturalName() {
        return naturalName;
    }
}
