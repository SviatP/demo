DROP SCHEMA IF EXISTS ciklum_test ;
CREATE SCHEMA ciklum_test;


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
)
  ENGINE = InnoDB;

CREATE TABLE cinema_movie
(
  movie_id  INT NOT NULL,
  cinema_id INT NOT NULL,
  PRIMARY KEY (movie_id, cinema_id),
  CONSTRAINT cinema_movie_ibfk_1
  FOREIGN KEY (movie_id) REFERENCES movie (id)
    ON UPDATE CASCADE
    ON DELETE CASCADE,
  CONSTRAINT cinema_movie_ibfk_2
  FOREIGN KEY (cinema_id) REFERENCES cinema (id)
    ON UPDATE CASCADE
    ON DELETE CASCADE
)
  ENGINE = InnoDB;
CREATE INDEX cinema_id
  ON cinema_movie (cinema_id);


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


# SELECT c.id, c.address, c.name FROM cinema c JOIN ( SELECT * FROM movie_session WHERE end <= '2019-09-29 12:30:00') s ON c.id = s.cinema GROUP BY s.cinema HAVING  COUNT(s.cinema) > 3;
# SELECT c.id, c.address, c.name FROM cinema c JOIN ( SELECT * FROM movie_session WHERE end <= '2019-09-29 12:30:00') s ON c.id = s.cinema;
# SELECT c.id, c.address, c.name FROM cinema c JOIN movie_session s ON c.id = s.cinema GROUP BY s.cinema HAVING  COUNT(s.cinema) > 3;


