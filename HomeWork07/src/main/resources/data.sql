INSERT INTO author (name) VALUES ('Author1');
INSERT INTO author (name) VALUES ('Author2');
INSERT INTO author (name) VALUES ('Author3');
INSERT INTO author (name) VALUES ('Author4');

INSERT INTO genre (name) VALUES ('Genre1');
INSERT INTO genre (name) VALUES ('Genre2');
INSERT INTO genre (name) VALUES ('Genre3');

INSERT INTO book (name, author_id, genre_id) VALUES ('Book1', 1, 2);
INSERT INTO book (name, author_id, genre_id) VALUES ('Book2', 2, 2);

INSERT INTO comment (description) VALUES ('Description1');
INSERT INTO comment (description) VALUES ('Description2');
INSERT INTO comment (description) VALUES ('Description3');
INSERT INTO comment (description) VALUES ('Description4');
INSERT INTO comment (description) VALUES ('Description5');

INSERT INTO book_comments (book_id, comment_id)
    VALUES (1, 1), (1, 2), (1, 3),
           (2, 4), (2, 5);


