INSERT INTO worker (name, birthday, level, salary) VALUES
       ('KIiashchenkl', '2000-01-05', 'Trainee', 350),
       ('Lapushenko', '1990-02-15', 'Trainee', 380),
       ('Milli', '2000-05-11', 'Trainee', 400),
       ('Holovan', '1999-02-07', 'Trainee', 350),
       ('Popov', '2002-10-06', 'Junior', 800),
       ('Kashkarova', '2001-01-10', 'Junior', 900),
       ('Vasiuk', '1985-03-14', 'Middle', 1500),
       ('Gaponov', '1980-05-12', 'Middle', 2000),
       ('Kniazchikov', '1980-03-12', 'Senior', 3300),
       ('Titova', '2005-02-10', 'Senior', 4000);


INSERT INTO client (name) VALUES ('EPAM'), ('UDEMY'), ('TESTIO'), ('CIKLUM'), ('GOOGLE');

INSERT INTO project (client_id, start_date, finish_date) VALUES
       (SELECT id FROM client WHERE name = 'EPAM', '2022-01-05', '2022-06-25'),
       (SELECT id FROM client WHERE name = 'EPAM', '2022-01-10', '2023-02-25'),
       (SELECT id FROM client WHERE name = 'UDEMY', '2023-02-03', '2023-03-31'),
       (SELECT id FROM client WHERE name = 'UDEMY', '2020-11-10', '2023-02-28'),
       (SELECT id FROM client WHERE name = 'UDEMY', '2020-11-12', '2022-01-20'),
       (SELECT id FROM client WHERE name = 'TESTIO', '2021-10-10', '2023-01-31'),
       (SELECT id FROM client WHERE name = 'TESTIO', '2022-11-11', '2023-10-10'),
       (SELECT id FROM client WHERE name = 'TESTIO', '2023-02-10', '2023-10-02'),
       (SELECT id FROM client WHERE name = 'TESTIO', '2020-01-10', '2022-11-10'),
       (SELECT id FROM client WHERE name = 'CIKLUM', '2020-07-20', '2021-02-10'),
       (SELECT id FROM client WHERE name = 'GOOGLE', '2022-04-11', '2023-05-20');


INSERT INTO project_worker SELECT (SELECT id FROM project LIMIT 1 OFFSET 0), id FROM worker ORDER BY RAND() LIMIT (2);

INSERT INTO project_worker SELECT (SELECT id FROM project LIMIT 1 OFFSET 1), id FROM worker ORDER BY RAND() LIMIT (3);

INSERT INTO project_worker SELECT (SELECT id FROM project LIMIT 1 OFFSET 2), id FROM worker ORDER BY RAND() LIMIT (1);

INSERT INTO project_worker SELECT (SELECT id FROM project LIMIT 1 OFFSET 3), id FROM worker ORDER BY RAND() LIMIT (5);

INSERT INTO project_worker SELECT (SELECT id FROM project LIMIT 1 OFFSET 4), id FROM worker ORDER BY RAND() LIMIT (4);

INSERT INTO project_worker SELECT (SELECT id FROM project LIMIT 1 OFFSET 5), id FROM worker ORDER BY RAND() LIMIT (1);

INSERT INTO project_worker SELECT (SELECT id FROM project LIMIT 1 OFFSET 6), id FROM worker ORDER BY RAND() LIMIT (2);

INSERT INTO project_worker SELECT (SELECT id FROM project LIMIT 1 OFFSET 7), id FROM worker ORDER BY RAND() LIMIT (3);

INSERT INTO project_worker SELECT (SELECT id FROM project LIMIT 1 OFFSET 8), id FROM worker ORDER BY RAND() LIMIT (4);

INSERT INTO project_worker SELECT (SELECT id FROM project LIMIT 1 OFFSET 9), id FROM worker ORDER BY RAND() LIMIT (5);
