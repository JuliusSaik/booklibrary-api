CREATE TABLE books
(
    id             int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    title          varchar(255),
    author         varchar(255),
    average_rating double,
    user_rating    int,
    release_year           int
);
