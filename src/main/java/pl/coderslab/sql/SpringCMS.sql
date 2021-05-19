CREATE DATABASE IF NOT EXISTS spring_cms CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
SHOW DATABASES;
USE spring_cms;
DROP TABLE test;
CREATE TABLE test
(
    id INT AUTO_INCREMENT,
    title VARCHAR(100),
    author VARCHAR(100),
    rating int,
    description VARCHAR(255),
    PRIMARY KEY(id)
);

DROP DATABASE test_spring_hibernate;

SHOW TABLES;
