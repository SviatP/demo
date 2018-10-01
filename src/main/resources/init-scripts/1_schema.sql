DROP SCHEMA IF EXISTS ciklum_test ;
CREATE SCHEMA ciklum_test;


-- auto-generated definition
USE ciklum_test;
DROP TABLE IF EXISTS ciklum_test.ticket;
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
)
  ENGINE = InnoDB;

CREATE TABLE movie_session
(
  id     INT AUTO_INCREMENT
    PRIMARY KEY,
  movie  INT       NULL,
  cinema INT       NULL,
  start  TIMESTAMP NULL,
  end    TIMESTAMP NULL,
  CONSTRAINT movie_session_ibfk_1
  FOREIGN KEY (movie) REFERENCES movie (id)
    ON UPDATE CASCADE
    ON DELETE CASCADE,
  CONSTRAINT movie_session_ibfk_2
  FOREIGN KEY (cinema) REFERENCES cinema (id)
    ON UPDATE CASCADE
    ON DELETE CASCADE
)  ENGINE = InnoDB;;
CREATE INDEX cinema
  ON movie_session (cinema);
CREATE INDEX movie
  ON movie_session (movie);




CREATE TABLE ticket
(
  id      INT NOT NULL AUTO_INCREMENT
    PRIMARY KEY,
  session INT NULL,
  cost    VARCHAR(255) NULL,
  client varchar(255) null,
  FOREIGN KEY (session) REFERENCES movie_session(id) ON UPDATE CASCADE ON DELETE CASCADE
);
