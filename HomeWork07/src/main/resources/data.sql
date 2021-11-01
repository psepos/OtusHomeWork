INSERT INTO author (name) VALUES ('Author1');
INSERT INTO author (name) VALUES ('Author2');
INSERT INTO author (name) VALUES ('Author3');
INSERT INTO author (name) VALUES ('Author4');

INSERT INTO genre (name) VALUES ('Genre1');
INSERT INTO genre (name) VALUES ('Genre2');
INSERT INTO genre (name) VALUES ('Genre3');

INSERT INTO book (name, author_id, genre_id) VALUES ('Book1', 1, 2);
INSERT INTO book (name, author_id, genre_id) VALUES ('Book2', 2, 2);

INSERT INTO comment (description, book_id) VALUES ('Description1', 1);
INSERT INTO comment (description, book_id) VALUES ('Description2', 1);
INSERT INTO comment (description, book_id) VALUES ('Description3', 1);
INSERT INTO comment (description, book_id) VALUES ('Description4', 2);
INSERT INTO comment (description, book_id) VALUES ('Description5', 2);


