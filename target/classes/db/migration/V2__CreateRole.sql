create TABLE student_role(
 id   BIGINT AUTO_INCREMENT  PRIMARY KEY    NOT NULL,
 student_id BIGINT,
 role VARCHAR(1),
 foreign key (student_id) references student (id)
);

insert into student_role(student_id, role)
values  (1, 'w'),
        (1, 'e'),
        (1, 'r'),
        (2, 'r'),
        (3, 'e'),
        (4, 'r'),
        (5, 'r'),
        (6, 'w'),
        (2, 'w');
