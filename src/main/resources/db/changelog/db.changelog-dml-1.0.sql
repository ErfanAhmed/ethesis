-- liquibase formatted sql

-- changeset erfan:1
-- comment: insert into university table
INSERT INTO university (id, name, created, updated, version)
values
    (1, 'BRAC University', '2023-01-20 00:00:00', '2023-01-20 00:00:00', 0),
    (2, 'NSU', '2023-01-20 00:00:00', '2023-01-20 00:00:00', 0),
    (3, 'AIUB', '2023-01-20 00:00:00', '2023-01-20 00:00:00', 0);

SELECT setval('university_seq', 3, TRUE);

-- changeset erfan:2
-- comment: insert into department table
INSERT INTO department (id, name, code, university_id, created, updated, version)
values
    (1, 'Computer Science and Engineering', 'CSE', 1, '2023-01-20 00:00:00', '2023-01-20 00:00:00', 0),
    (2, 'Electrical and Electronics Engineering','EEE', 3, '2023-01-20 00:00:00', '2023-01-20 00:00:00', 0),
    (3, 'Computer Science and Engineering','CSE', 1, '2023-01-20 00:00:00', '2023-01-20 00:00:00', 0),
    (4, 'Electrical and Electronics Engineering' ,'EEE', 3, '2023-01-20 00:00:00', '2023-01-20 00:00:00', 0),
    (5, 'Computer Science and Engineering', 'CSE', 1, '2023-01-20 00:00:00', '2023-01-20 00:00:00', 0),
    (6, 'Electrical and Electronics Engineering', 'EEE', 3, '2023-01-20 00:00:00', '2023-01-20 00:00:00', 0);

SELECT setval('department_seq', 9, TRUE);

-- changeset erfan:3
-- comment: insert into thesis_topic table
INSERT INTO thesis_topic (id, name, university_id, department_id, created, updated, version)
values
    (1, 'ML', 1, 1, '2023-01-20 00:00:00', '2023-01-20 00:00:00', 0),
    (2, 'AI', 1, 1, '2023-01-20 00:00:00', '2023-01-20 00:00:00', 0),
    (3, 'Image Processing', 1, 1, '2023-01-20 00:00:00', '2023-01-20 00:00:00', 0),
    (4, 'Computer Vision', 1, 1, '2023-01-20 00:00:00', '2023-01-20 00:00:00', 0);

SELECT setval('thesis_topic_seq', 4, TRUE);

-- changeset erfan:4
-- comment: insert into faculty table
INSERT INTO faculty (id, first_name, last_name, initials, faculty_id, designation, title, department_id, university_id,
                     created, updated, version)
values
    (1, 'Saad', 'Kazi', 'SK', '23101139', 'PROFESSOR', 'SUPERVISOR', 1, 1, '2023-01-20 00:00:00', '2023-01-20 00:00:00', 0),
    (2, 'Rehan', 'Rasha', 'RR', '23121139', 'ASSISTANT_PROFESSOR', 'CO_SUPERVISOR', 1, 1, '2023-01-20 00:00:00', '2023-01-20 00:00:00', 0),
    (3, 'Ferdous', 'Hauq', 'FH', '13401139', 'ASSISTANT_PROFESSOR', 'SUPERVISOR', 1, 1, '2023-01-20 00:00:00', '2023-01-20 00:00:00', 0),
    (4, 'Erfan', 'Ahmed', 'EA', '13151139', 'LECTURER_I1', 'CO_SUPERVISOR', 1, 1, '2023-01-20 00:00:00', '2023-01-20 00:00:00', 0),
    (5, 'Pranjal', 'Rahman', 'PR', '14101639', 'LECTURER_III', 'CO_SUPERVISOR', 1, 1, '2023-01-20 00:00:00', '2023-01-20 00:00:00', 0),
    (6, 'Mostafiz', 'Sohan', 'MS', '23101155', 'LECTURER_II', 'CO_SUPERVISOR', 1, 1, '2023-01-20 00:00:00', '2023-01-20 00:00:00', 0);

SELECT setval('faculty_seq', 6, TRUE);

-- changeset erfan:5
-- comment: insert into thesis_group table
INSERT INTO thesis_group (id, name, thesis_title, status, thesis_topic_id, faculty_id, created, updated, version)
values
    (1, 'Team-X', 'Sentiment Analysis with ML', 'ACTIVE', 1, 1, '2023-01-20 00:00:00', '2023-01-20 00:00:00', 0),
    (2, 'Serious-A', 'Real time traffic image processing to detect possible road accident beforehand', 'ACTIVE', 1, 1, '2023-01-20 00:00:00', '2023-01-20 00:00:00', 0);

SELECT setval('thesis_group_seq', 2, TRUE);

-- changeset erfan:6
-- comment: insert into student table
INSERT INTO student (id, first_name, last_name, student_id, department_id, university_id, thesis_group_id, created, updated, version)
values
    (1, 'Farhan', 'Ahmed', '13101139', 1, 1, 1, '2023-01-20 00:00:00', '2023-01-20 00:00:00', 0),
    (2, 'Jubair', 'Hussain', '13101149', 1, 1, 1, '2023-01-20 00:00:00', '2023-01-20 00:00:00', 0),
    (3, 'Asad', 'Sazzad', '13103339', 1, 1, 2, '2023-01-20 00:00:00', '2023-01-20 00:00:00', 0),
    (4, 'Raiyan', 'Israq', '21101139', 1, 1, 2, '2023-01-20 00:00:00', '2023-01-20 00:00:00', 0),
    (5, 'Taief', 'Imam', '22101139', 1, 1, null, '2023-01-20 00:00:00', '2023-01-20 00:00:00', 0),
    (6, 'Riahm', 'Chowdhuri', '23101139', 1, 1, null, '2023-01-20 00:00:00', '2023-01-20 00:00:00', 0);

SELECT setval('student_seq', 6, TRUE);

-- changeset erfan:7
-- comment: insert into thesis_request table
INSERT INTO thesis_request (id, thesis_status, thesis_group_id, faculty_id, created, updated, version)
values
    (1, 'SENT', 1, 1, '2023-01-20 00:00:00', '2023-01-20 00:00:00', 0),
    (2, 'SENT', 2, 1, '2023-01-20 00:00:00', '2023-01-20 00:00:00', 0);

SELECT setval('thesis_request_seq', 2, TRUE);