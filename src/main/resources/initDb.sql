DROP TABLE IF EXISTS students;
DROP TABLE IF EXISTS books;

DROP SEQUENCE IF EXISTS global_seq_stud;
DROP SEQUENCE IF EXISTS global_seq_book;

CREATE SEQUENCE global_seq_stud START 100;
CREATE SEQUENCE global_seq_book START 1000;

CREATE TABLE students(
  id INTEGER PRIMARY KEY DEFAULT nextval('global_seq_stud'),
  firstname VARCHAR(255) NOt NULL,
  lastname VARCHAR(255) NOt NULL,
  tel VARCHAR(255) NOt NULL,
  dob DATE
);

CREATE TABLE books(
  id INTEGER PRIMARY KEY DEFAULT nextval('global_seq_book'),
  userid INTEGER NOT NULL,
  author VARCHAR(255) NOT NULL,
  title VARCHAR(255) NOT NULL,
  FOREIGN KEY (userid) REFERENCES students(id) ON DELETE CASCADE
);

