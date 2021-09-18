DROP TABLE IF EXISTS author;
CREATE TABLE author(id BIGSERIAL, name varchar(255), CONSTRAINT author_pk PRIMARY KEY (id));

DROP TABLE IF EXISTS genre;
CREATE TABLE genre(id BIGSERIAL, name VARCHAR(255), CONSTRAINT genre_pk PRIMARY KEY (id));

DROP TABLE IF EXISTS comment;
CREATE TABLE comment(id BIGSERIAL, description VARCHAR(255), CONSTRAINT comment_pk PRIMARY KEY (id));

DROP TABLE IF EXISTS book;
CREATE TABLE book(id BIGSERIAL, name VARCHAR(255), CONSTRAINT book_pk PRIMARY KEY (id));

DROP TABLE IF EXISTS book_genre;
CREATE TABLE book_genre(
    book_id BIGINT REFERENCES book(id) ON DELETE CASCADE,
    genre_id BIGINT REFERENCES genre(id),
    CONSTRAINT book_genre_pk PRIMARY KEY (book_id)
);

DROP TABLE IF EXISTS book_author;
CREATE TABLE book_author(
    book_id BIGINT REFERENCES book(id) ON DELETE CASCADE,
    author_id BIGINT REFERENCES author(id),
    CONSTRAINT book_author_pk PRIMARY KEY (book_id)
);

DROP TABLE IF EXISTS book_comments;
CREATE TABLE book_comments(
    book_id BIGINT REFERENCES book(id) ON DELETE CASCADE,
    comment_id BIGINT REFERENCES comment(id) ON DELETE CASCADE,
    CONSTRAINT book_comments_pk PRIMARY KEY (book_id, comment_id)
);