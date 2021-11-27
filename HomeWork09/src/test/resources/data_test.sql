INSERT INTO author (name) VALUES ('Author1');
INSERT INTO author (name) VALUES ('Author2');
INSERT INTO author (name) VALUES ('Author3');
INSERT INTO author (name) VALUES ('Author4');
INSERT INTO author (name) VALUES ('Author5');
INSERT INTO author (name) VALUES ('Author6');

INSERT INTO genre (name) VALUES ('Genre1');
INSERT INTO genre (name) VALUES ('Genre2');
INSERT INTO genre (name) VALUES ('Genre3');
INSERT INTO genre (name) VALUES ('Genre4');
INSERT INTO genre (name) VALUES ('Genre5');
INSERT INTO genre (name) VALUES ('Genre6');

INSERT INTO comment (description, book_id) VALUES ('Comment1', 1);
INSERT INTO comment (description, book_id) VALUES ('Comment2', 1);
INSERT INTO comment (description, book_id) VALUES ('Comment3', 2);
INSERT INTO comment (description, book_id) VALUES ('Comment4', 2);
INSERT INTO comment (description, book_id) VALUES ('Comment5', 3);
INSERT INTO comment (description, book_id) VALUES ('Comment6', 3);
INSERT INTO comment (description, book_id) VALUES ('Comment7', 3);
INSERT INTO comment (description, book_id) VALUES ('Comment8', 4);
INSERT INTO comment (description, book_id) VALUES ('Comment9', 4);
INSERT INTO comment (description, book_id) VALUES ('Comment10', 4);

INSERT INTO book (name, author_id, genre_id) VALUES ('Book1', 1, 1);
INSERT INTO book (name, author_id, genre_id) VALUES ('Book2', 2, 2);
INSERT INTO book (name, author_id, genre_id) VALUES ('Book3', 3, 3);
INSERT INTO book (name, author_id, genre_id) VALUES ('Book4', 4, 4);
