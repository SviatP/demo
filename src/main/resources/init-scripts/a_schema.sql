DROP SCHEMA IF EXISTS ciklum_test ;
DROP SCHEMA IF EXISTS aaaaaaaaaa ;
CREATE SCHEMA ciklum_test;
CREATE SCHEMA aaaaaaaaaa;


-- auto-generated definition
USE ciklum_test;
DROP TABLE IF EXISTS ciklum_test.ticket;
DROP TABLE IF EXISTS ciklum_test.cinema_movie;
DROP TABLE IF EXISTS ciklum_test.movie_session;
DROP TABLE IF EXISTS ciklum_test.movie;
DROP TABLE IF EXISTS ciklum_test.cinema;
USE ciklum_test;
CREATE TABLE cinema
(
  id      INT(11) NOT NULL AUTO_INCREMENT
    PRIMARY KEY,
  address VARCHAR(255) NULL,
  name    VARCHAR(255) NULL
);

CREATE TABLE movie
(
  id INT(11) NOT NULL AUTO_INCREMENT
    PRIMARY KEY,
  duration INT NULL,
  name    VARCHAR(255) NULL
);

CREATE TABLE cinema_movie
(
  movie_id INT(11)  NOT NULL,
  cinema_id INT(11) NOT NULL,
  INDEX movie_id (movie_id),
  INDEX cinema_id (cinema_id),
  PRIMARY KEY (movie_id , cinema_id),
  FOREIGN KEY (movie_id) REFERENCES movie(id),
  FOREIGN KEY (cinema_id) REFERENCES cinema(id)
);

CREATE TABLE movie_session
(
  id      INT NOT NULL AUTO_INCREMENT
    PRIMARY KEY,
  movie INT NULL,
  cinema INT NULL,
  start    TIMESTAMP NULL,
  end TIMESTAMP null,
  FOREIGN KEY (movie) REFERENCES movie(id),
  FOREIGN KEY (cinema) REFERENCES cinema(id)
);



CREATE TABLE ticket
(
  id      INT NOT NULL AUTO_INCREMENT
    PRIMARY KEY,
  session INT NULL,
  cost    VARCHAR(255) NULL,
  client varchar(255) null,
  FOREIGN KEY (session) REFERENCES movie_session(id)
);


