
create TABLE course
(
    id   BIGINT AUTO_INCREMENT      NOT NULL,
    name VARCHAR(255) NULL,
    CONSTRAINT pk_course PRIMARY KEY (id)
);

create TABLE registration
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    student_id BIGINT                NOT NULL,
    course_id  BIGINT                NULL,
    CONSTRAINT pk_registration PRIMARY KEY (id)
);

create TABLE student
(
    id     BIGINT  AUTO_INCREMENT     NOT NULL,
    name   VARCHAR(255) NULL,
    gender VARCHAR(1) NULL,
    CONSTRAINT pk_student PRIMARY KEY (id)
);

ALTER TABLE registration
    ADD CONSTRAINT FK_REGISTRATION_ON_COURSEID FOREIGN KEY (course_id) REFERENCES course (id);

ALTER TABLE registration
    ADD CONSTRAINT FK_REGISTRATION_ON_STUDENTID FOREIGN KEY (student_id) REFERENCES student (id);

insert into student
values (1,'m','James'),
       (2,'m','Ethan'),
       (3,'m','Jacob'),
       (4,'m','William'),
       (5,'f','Noah'),
       (6,'f','Wyatt'),
       (7,'f','Mason'),
       (8,'o','Samuel'),
       (9,'o','Joshua'),
       (10,'m','Benjamin');

insert into course
values (1,'maths'),
       (2,'music'),
       (3,'English'),
       (4,'geography'),
       (5,'history'),
       (6,'science');

insert into registration
values (1,1,1),
       (2,1,2),
       (3,2,3),
       (4,4,5),
       (5,3,7),
       (6,6,10);
