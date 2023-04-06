-- liquibase formatted sql

-- changeset erfan:1
-- comment: create university table
CREATE TABLE university (
    id          INT NOT NULL,
    name        VARCHAR(200) NOT NULL,
    created     TIMESTAMP,
    updated     TIMESTAMP,
    version     INT,
    CONSTRAINT pk_university PRIMARY KEY (id)
);

CREATE SEQUENCE university_seq START WITH 1 INCREMENT BY 1;
-- rollback DROP TABLE university;
-- rollback DROP SEQUENCE university_seq;

-- changeset erfan:2
-- comment: create department table
CREATE TABLE department (
    id              INT NOT NULL,
    name            VARCHAR(200) NOT NULL,
    code            VARCHAR(10) NOT NULL,
    university_id   INT,
    created         TIMESTAMP,
    updated         TIMESTAMP,
    version         INT,
    CONSTRAINT pk_department PRIMARY KEY (id),
    CONSTRAINT fk_d_university_id FOREIGN KEY (university_id) REFERENCES university(id)
);

CREATE SEQUENCE department_seq START WITH 1 INCREMENT BY 1;
-- rollback DROP TABLE department;
-- rollback DROP SEQUENCE department_seq;

-- changeset erfan:3
-- comment: create thesis_topic table
CREATE TABLE thesis_topic (
    id              BIGINT       NOT NULL ,
    name            VARCHAR(500) NOT NULL,
    university_id   INT,
    department_id   INT,
    created         TIMESTAMP,
    updated         TIMESTAMP,
    version         INT,
    CONSTRAINT pk_thesis_topic PRIMARY KEY (id),
    CONSTRAINT fk_tt_university_id FOREIGN KEY (university_id) REFERENCES university(id),
    CONSTRAINT fk_tt_department_id FOREIGN KEY (department_id) REFERENCES department(id)
);

CREATE SEQUENCE thesis_topic_seq START WITH 1 INCREMENT BY 1;
-- rollback DROP TABLE thesis_topic;
-- rollback DROP SEQUENCE thesis_topic_seq;

-- changeset erfan:4
-- comment: create faculty table
CREATE TABLE faculty (
     id                BIGINT      NOT NULL,
     first_name        VARCHAR(50) NOT NULL,
     last_name         VARCHAR(50),
     middle_name       VARCHAR(50),
     initials          VARCHAR(50) NOT NULL,
     faculty_id        VARCHAR(20) UNIQUE,
     designation       VARCHAR(20),
     title             VARCHAR(20),
     university_id     INT,
     department_id     INT,
     created           TIMESTAMP,
     updated           TIMESTAMP,
     version           INT,
     CONSTRAINT pk_faculty PRIMARY KEY (id),
     CONSTRAINT uk_faculty_id UNIQUE (faculty_id),
     CONSTRAINT fk_f_university_id FOREIGN KEY (university_id) REFERENCES university (id),
     CONSTRAINT fk_f_department_id FOREIGN KEY (department_id) REFERENCES department (id)
);

CREATE SEQUENCE faculty_seq START WITH 1 INCREMENT BY 1;
-- rollback DROP TABLE faculty;
-- rollback DROP SEQUENCE faculty_seq;


-- changeset erfan:5
-- comment: create thesis_group table
CREATE TABLE thesis_group (
    id              BIGINT NOT NULL,
    name            VARCHAR(20),
    thesis_title    VARCHAR(500),
    thesis_summary  TEXT,
    status          VARCHAR(20),
    thesis_topic_id BIGINT,
    faculty_id      BIGINT,
    created         TIMESTAMP,
    updated         TIMESTAMP,
    version         INT,
    CONSTRAINT pk_thesis_group PRIMARY KEY (id),
    CONSTRAINT fk_tg_thesis_topic_id FOREIGN KEY (thesis_topic_id) REFERENCES thesis_topic (id),
    CONSTRAINT fk_tg_faculty_id FOREIGN KEY (faculty_id) REFERENCES faculty (id)
);
CREATE SEQUENCE thesis_group_seq START WITH 1 INCREMENT BY 1;
-- rollback DROP TABLE thesis_group;
-- rollback DROP SEQUENCE thesis_group_seq;


-- changeset erfan:6
-- comment: create student table
CREATE TABLE student (
    id                BIGINT      NOT NULL,
    first_name        VARCHAR(50) NOT NULL,
    last_name         VARCHAR(50),
    middle_name       VARCHAR(50),
    student_id        VARCHAR(20),
    department_id     INT,
    university_id     INT,
    thesis_group_id   BIGINT,
    created           TIMESTAMP,
    updated           TIMESTAMP,
    version           INT,
    CONSTRAINT pk_product PRIMARY KEY (id),
    CONSTRAINT fk_p_university_id FOREIGN KEY (university_id) REFERENCES university (id),
    CONSTRAINT fk_p_department_id FOREIGN KEY (department_id) REFERENCES department (id),
    CONSTRAINT fk_p_thesis_group_id FOREIGN KEY (thesis_group_id) REFERENCES thesis_group (id)
);

CREATE SEQUENCE student_seq START WITH 1 INCREMENT BY 1;
-- rollback DROP TABLE student;
-- rollback DROP SEQUENCE student_seq;

-- changeset erfan:7
-- comment: create thesis_request table
CREATE TABLE thesis_request (
    id              BIGINT      NOT NULL,
    thesis_status   VARCHAR(15) NOT NULL,
    thesis_group_id BIGINT,
    faculty_id      BIGINT,
    created         TIMESTAMP,
    updated         TIMESTAMP,
    version         INT,
    CONSTRAINT pk_thesis_request PRIMARY KEY (id),
    CONSTRAINT fk_tr_thesis_group_id FOREIGN KEY (id) REFERENCES thesis_group (id),
    CONSTRAINT fk_tr_faculty_id FOREIGN KEY (id) REFERENCES faculty (id)
);

CREATE SEQUENCE thesis_request_seq START WITH 1 INCREMENT BY 1;
-- rollback DROP TABLE thesis_request;
-- rollback DROP SEQUENCE thesis_request_seq;


/* doesn't work upto liquibase core v 4.18.0]
    rollback none
    rollback empty

   the following doesn't cause error but deletes corresponding entry from the
   databasechangelog table that in turns causes error while running update
   command afterwards.

   rollback SELECT 'N/A';

   From 4.19.0 `rollback empty` gives no error,
   the command executes but also deletes corresponding row from databasechangelog table
 */
