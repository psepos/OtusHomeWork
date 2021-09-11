INSERT INTO author (name) VALUES ('Ivanov');
INSERT INTO author (name) VALUES ('Petrov');
INSERT INTO author (name) VALUES ('Sidorov');
INSERT INTO author (name) VALUES ('Pastuhov');

INSERT INTO genre (name) VALUES ('Comedy');
INSERT INTO genre (name) VALUES ('Drama');
INSERT INTO genre (name) VALUES ('Scientific');

INSERT INTO book (name, genre_id, author_id) VALUES ('Titanic on Space', 2, 1);
INSERT INTO book (name, genre_id, author_id) VALUES ('Space from outside', 3, 2);
