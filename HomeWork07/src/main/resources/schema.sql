DROP TABLE IF EXISTS author;
CREATE TABLE author(id BIGSERIAL, name varchar(255), CONSTRAINT author_pk PRIMARY KEY (id));

DROP TABLE IF EXISTS genre;
CREATE TABLE genre(id BIGSERIAL, name VARCHAR(255), CONSTRAINT genre_pk PRIMARY KEY (id));

DROP TABLE IF EXISTS comment;
CREATE TABLE comment(id BIGSERIAL, description VARCHAR(255), CONSTRAINT comment_pk PRIMARY KEY (id));

DROP TABLE IF EXISTS book;
CREATE TABLE book(id BIGSERIAL, name VARCHAR(255), author_id BIGINT, genre_id BIGINT, CONSTRAINT book_pk PRIMARY KEY (id));

DROP TABLE IF EXISTS book_comments;
CREATE TABLE book_comments(
    book_id BIGINT REFERENCES book(id) ON DELETE CASCADE,
    comment_id BIGINT REFERENCES comment(id) ON DELETE CASCADE,
    CONSTRAINT book_comments_pk PRIMARY KEY (book_id, comment_id)
);