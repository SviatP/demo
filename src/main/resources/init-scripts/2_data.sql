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




INSERT INTO ciklum_test.cinema (address, name) VALUES ('Kyiv, Getmana 2/5', 'Ultramarine');
INSERT INTO ciklum_test.cinema (address, name) VALUES ('Kyiv, Banderu 2', 'IMax');
INSERT INTO ciklum_test.cinema (address, name) VALUES ('Kyiv, Gulliver', 'Oscar');
INSERT INTO ciklum_test.cinema (address, name) VALUES ('Kyiv, Ocan Plaza', 'Oscar');
INSERT INTO ciklum_test.cinema (address, name) VALUES ('Kyiv, Zulanska 5', 'Ultramarine');


INSERT INTO ciklum_test.movie (duration, name) VALUES (120, 'Watchers');
INSERT INTO ciklum_test.movie (duration, name) VALUES (135, 'Hangover');
INSERT INTO ciklum_test.movie (duration, name) VALUES (140, 'Astral');
INSERT INTO ciklum_test.movie (duration, name) VALUES (125, 'Smurfs');
INSERT INTO ciklum_test.movie (duration, name) VALUES (140, 'Bond');


INSERT INTO ciklum_test.cinema_movie (movie_id, cinema_id) VALUES (1, 1);
INSERT INTO ciklum_test.cinema_movie (movie_id, cinema_id) VALUES (1, 2);
INSERT INTO ciklum_test.cinema_movie (movie_id, cinema_id) VALUES (1, 4);
INSERT INTO ciklum_test.cinema_movie (movie_id, cinema_id) VALUES (1, 5);
INSERT INTO ciklum_test.cinema_movie (movie_id, cinema_id) VALUES (2, 1);
INSERT INTO ciklum_test.cinema_movie (movie_id, cinema_id) VALUES (2, 3);
INSERT INTO ciklum_test.cinema_movie (movie_id, cinema_id) VALUES (2, 4);
INSERT INTO ciklum_test.cinema_movie (movie_id, cinema_id) VALUES (2, 5);
INSERT INTO ciklum_test.cinema_movie (movie_id, cinema_id) VALUES (3, 1);
INSERT INTO ciklum_test.cinema_movie (movie_id, cinema_id) VALUES (3, 2);
INSERT INTO ciklum_test.cinema_movie (movie_id, cinema_id) VALUES (3, 5);
INSERT INTO ciklum_test.cinema_movie (movie_id, cinema_id) VALUES (4, 1);
INSERT INTO ciklum_test.cinema_movie (movie_id, cinema_id) VALUES (4, 2);
INSERT INTO ciklum_test.cinema_movie (movie_id, cinema_id) VALUES (5, 5);

INSERT INTO ciklum_test.movie_session (movie, cinema, start, end) VALUES (1, 1, '2019-09-29 08:00:00', '2019-09-29 09:30:00');
INSERT INTO ciklum_test.movie_session (movie, cinema, start, end) VALUES (1, 1, '2019-09-29 08:00:00', '2019-09-29 11:30:00');
INSERT INTO ciklum_test.movie_session (movie, cinema, start, end) VALUES (1, 1, '2019-09-29 16:00:00', '2019-09-29 17:30:00');
INSERT INTO ciklum_test.movie_session (movie, cinema, start, end) VALUES (1, 2, '2019-09-29 08:00:00', '2019-09-29 09:30:00');
INSERT INTO ciklum_test.movie_session (movie, cinema, start, end) VALUES (1, 2, '2019-09-29 08:00:00', '2019-09-29 11:30:00');
INSERT INTO ciklum_test.movie_session (movie, cinema, start, end) VALUES (1, 2, '2019-09-29 16:00:00', '2019-09-29 17:30:00');
INSERT INTO ciklum_test.movie_session (movie, cinema, start, end) VALUES (1, 4, '2019-09-29 08:00:00', '2019-09-29 09:30:00');
INSERT INTO ciklum_test.movie_session (movie, cinema, start, end) VALUES (1, 4, '2019-09-29 08:00:00', '2019-09-29 11:30:00');
INSERT INTO ciklum_test.movie_session (movie, cinema, start, end) VALUES (1, 4, '2019-09-29 16:00:00', '2019-09-29 17:30:00');
INSERT INTO ciklum_test.movie_session (movie, cinema, start, end) VALUES (1, 5, '2019-09-29 08:00:00', '2019-09-29 09:30:00');
INSERT INTO ciklum_test.movie_session (movie, cinema, start, end) VALUES (1, 5, '2019-09-29 08:00:00', '2019-09-29 11:30:00');
INSERT INTO ciklum_test.movie_session (movie, cinema, start, end) VALUES (1, 5, '2019-09-29 16:00:00', '2019-09-29 17:30:00');
INSERT INTO ciklum_test.movie_session (movie, cinema, start, end) VALUES (2, 1, '2019-09-29 08:00:00', '2019-09-29 09:30:00');
INSERT INTO ciklum_test.movie_session (movie, cinema, start, end) VALUES (2, 1, '2019-09-29 08:00:00', '2019-09-29 11:30:00');
INSERT INTO ciklum_test.movie_session (movie, cinema, start, end) VALUES (2, 1, '2019-09-29 16:00:00', '2019-09-29 17:30:00');
INSERT INTO ciklum_test.movie_session (movie, cinema, start, end) VALUES (2, 3, '2019-09-29 08:00:00', '2019-09-29 09:30:00');
INSERT INTO ciklum_test.movie_session (movie, cinema, start, end) VALUES (2, 3, '2019-09-29 08:00:00', '2019-09-29 11:30:00');
INSERT INTO ciklum_test.movie_session (movie, cinema, start, end) VALUES (2, 3, '2019-09-29 16:00:00', '2019-09-29 17:30:00');
INSERT INTO ciklum_test.movie_session (movie, cinema, start, end) VALUES (2, 4, '2019-09-29 08:00:00', '2019-09-29 09:30:00');
INSERT INTO ciklum_test.movie_session (movie, cinema, start, end) VALUES (2, 4, '2019-09-29 08:00:00', '2019-09-29 11:30:00');
INSERT INTO ciklum_test.movie_session (movie, cinema, start, end) VALUES (2, 4, '2019-09-29 16:00:00', '2019-09-29 17:30:00');
INSERT INTO ciklum_test.movie_session (movie, cinema, start, end) VALUES (2, 5, '2019-09-29 08:00:00', '2019-09-29 09:30:00');
INSERT INTO ciklum_test.movie_session (movie, cinema, start, end) VALUES (2, 5, '2019-09-29 08:00:00', '2019-09-29 11:30:00');
INSERT INTO ciklum_test.movie_session (movie, cinema, start, end) VALUES (2, 5, '2019-09-29 16:00:00', '2019-09-29 17:30:00');
INSERT INTO ciklum_test.ticket (session, cost, client) VALUES (1, '200', 'Ivan');
INSERT INTO ciklum_test.ticket (session, cost, client) VALUES (1, '200', 'Petr');
INSERT INTO ciklum_test.ticket (session, cost, client) VALUES (1, '200', 'Ivan');
INSERT INTO ciklum_test.ticket (session, cost, client) VALUES (1, '200', 'Petr');
INSERT INTO ciklum_test.ticket (session, cost, client) VALUES (1, '200', 'Ivan');
INSERT INTO ciklum_test.ticket (session, cost, client) VALUES (1, '200', 'Petr');
INSERT INTO ciklum_test.ticket (session, cost, client) VALUES (1, '200', 'Ivan');
INSERT INTO ciklum_test.ticket (session, cost, client) VALUES (1, '200', 'Petr');
INSERT INTO ciklum_test.ticket (session, cost, client) VALUES (1, '200', 'Ivan');
INSERT INTO ciklum_test.ticket (session, cost, client) VALUES (1, '200', 'Petr');
INSERT INTO ciklum_test.ticket (session, cost, client) VALUES (1, '200', 'Ivan');
INSERT INTO ciklum_test.ticket (session, cost, client) VALUES (1, '200', 'Petr');
INSERT INTO ciklum_test.ticket (session, cost, client) VALUES (1, '200', 'Ivan');
INSERT INTO ciklum_test.ticket (session, cost, client) VALUES (1, '200', 'Petr');
INSERT INTO ciklum_test.ticket (session, cost, client) VALUES (1, '200', 'Ivan');
INSERT INTO ciklum_test.ticket (session, cost, client) VALUES (1, '200', 'Petr');
INSERT INTO ciklum_test.ticket (session, cost, client) VALUES (1, '200', 'Ivan');
INSERT INTO ciklum_test.ticket (session, cost, client) VALUES (1, '200', 'Petr');
INSERT INTO ciklum_test.ticket (session, cost, client) VALUES (1, '200', 'Ivan');
INSERT INTO ciklum_test.ticket (session, cost, client) VALUES (1, '200', 'Petr');
INSERT INTO ciklum_test.ticket (session, cost, client) VALUES (1, '200', 'Ivan');
INSERT INTO ciklum_test.ticket (session, cost, client) VALUES (2, '200', 'Ivan');
INSERT INTO ciklum_test.ticket (session, cost, client) VALUES (2, '200', 'Petr');
INSERT INTO ciklum_test.ticket (session, cost, client) VALUES (2, '200', 'Ivan');
INSERT INTO ciklum_test.ticket (session, cost, client) VALUES (2, '200', 'Petr');
INSERT INTO ciklum_test.ticket (session, cost, client) VALUES (2, '200', 'Ivan');
INSERT INTO ciklum_test.ticket (session, cost, client) VALUES (2, '200', 'Petr');
INSERT INTO ciklum_test.ticket (session, cost, client) VALUES (2, '200', 'Ivan');
INSERT INTO ciklum_test.ticket (session, cost, client) VALUES (2, '200', 'Petr');
INSERT INTO ciklum_test.ticket (session, cost, client) VALUES (2, '200', 'Ivan');
INSERT INTO ciklum_test.ticket (session, cost, client) VALUES (2, '200', 'Petr');
INSERT INTO ciklum_test.ticket (session, cost, client) VALUES (2, '200', 'Ivan');
INSERT INTO ciklum_test.ticket (session, cost, client) VALUES (2, '200', 'Petr');
INSERT INTO ciklum_test.ticket (session, cost, client) VALUES (2, '200', 'Ivan');
INSERT INTO ciklum_test.ticket (session, cost, client) VALUES (2, '200', 'Petr');