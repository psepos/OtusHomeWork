INSERT INTO author (id, name) VALUES (1, 'Ivanov');
INSERT INTO author (id, name) VALUES (2, 'Petrov');
INSERT INTO author (id, name) VALUES (3, 'Sidorov');
INSERT INTO author (id, name) VALUES (4, 'Pastuhov');

INSERT INTO genre (id, name) VALUES (1, 'Comedy');
INSERT INTO genre (id, name) VALUES (2, 'Drama');
INSERT INTO genre (id, name) VALUES (3, 'Scientific');

INSERT INTO book (id, name, genre_id, author_id) VALUES (1, 'Titanic on Space', 2, 1);
INSERT INTO book (id, name, genre_id, author_id) VALUES (2, 'Space from outside', 3, 2);
