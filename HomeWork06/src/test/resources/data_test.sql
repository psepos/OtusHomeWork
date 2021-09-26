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

INSERT INTO comment (description) VALUES ('Comment1');
INSERT INTO comment (description) VALUES ('Comment2');
INSERT INTO comment (description) VALUES ('Comment3');
INSERT INTO comment (description) VALUES ('Comment4');
INSERT INTO comment (description) VALUES ('Comment5');
INSERT INTO comment (description) VALUES ('Comment6');
INSERT INTO comment (description) VALUES ('Comment7');
INSERT INTO comment (description) VALUES ('Comment8');
INSERT INTO comment (description) VALUES ('Comment9');
INSERT INTO comment (description) VALUES ('Comment10');

INSERT INTO book (name, author_id, genre_id) VALUES ('Book1', 1, 1);
INSERT INTO book (name, author_id, genre_id) VALUES ('Book2', 2, 2);
INSERT INTO book (name, author_id, genre_id) VALUES ('Book3', 3, 3);
INSERT INTO book (name, author_id, genre_id) VALUES ('Book4', 4, 4);

INSERT INTO book_comments (book_id, comment_id)
    VALUES (1, 1), (1, 2),
           (2, 3), (2, 4),
           (3, 5), (3, 6),
           (4, 7), (4, 8);