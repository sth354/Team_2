-- psql -U postgres
-- \c gamedb
-- navigate to Team_2 using \cd, (\! dir to see current directory or \! ls for linux)
-- \i src/data/database.sql
-- á windows : \i src//data//database.sql
-- CREATE TABLE facts (id bigint, fact varchar(255));
BEGIN;

    DROP TABLE IF EXISTS facts CASCADE;
    DROP TABLE IF EXISTS directors CASCADE;
    DROP TABLE IF EXISTS movies CASCADE;
    DROP TABLE IF EXISTS scores CASCADE;
    DROP TABLE IF EXISTS users CASCADE;



    CREATE TABLE movies(id bigint, title varchar(255), year integer, director_id bigint);
    CREATE TABLE directors(id bigint, name varchar(255));
    CREATE TABLE facts(id bigint, fact varchar(255));
    CREATE TABLE users(id bigint, username varchar(255), password varchar(255));
    CREATE TABLE scores(id bigint, difficulty integer, points integer, username varchar(255));

    INSERT INTO facts(id, fact) VALUES (1, 'It is physically impossible for pigs to look up into the sky.');
    INSERT INTO facts(id, fact) VALUES (2, 'In Joker, Joaquin Phoenix lost 52 pounds to play the role of Arthur Fleck.');
    INSERT INTO facts(id, fact) VALUES (3, 'One famous "Pulp Fiction" scene was filmed backward');


    INSERT INTO directors(id,name) VALUES(1,'Steven Spielberg');
    INSERT INTO directors(id,name) VALUES(2,'Christopher Nolan');
    INSERT INTO directors(id,name) VALUES(3,'Tim Burton');
    INSERT INTO directors(id,name) VALUES(4,'Peter Jackson');
    INSERT INTO directors(id,name) VALUES(5,'David Lynch');
    INSERT INTO directors(id,name) VALUES(6,'Quentin Tarantino');
    INSERT INTO directors(id,name) VALUES(7,'James Cameron');
    INSERT INTO directors(id,name) VALUES(8,'Stanley Kubrick');
    INSERT INTO directors(id,name) VALUES(9,'Martin Scorsese');
    INSERT INTO directors(id,name) VALUES(10,'Alfred Hitchcock');
    INSERT INTO directors(id,name) VALUES(11,'Francis Ford Coppola');
    INSERT INTO directors(id,name) VALUES(12,'George Lucas');



    INSERT INTO movies(id,title,year,director_id) VALUES(1,'Jaws',1975,1);
    INSERT INTO movies(id,title,year,director_id) VALUES(2,'Ready Player One',2018,1);

    INSERT INTO movies(id,title,year,director_id) VALUES(3,'Interstellar',2014,2);
    INSERT INTO movies(id,title,year,director_id) VALUES(4,'The Dark Knight',2008,2);

    INSERT INTO movies(id,title,year,director_id) VALUES(5,'Edward Scissorhands',1990,3);
    INSERT INTO movies(id,title,year,director_id) VALUES(6,'Planet of the Apes',2001,3);

    INSERT INTO movies(id,title,year,director_id) VALUES(7,'Lord of the Rings',2001,4);
    INSERT INTO movies(id,title,year,director_id) VALUES(8,'King Kong',2005,4);

    INSERT INTO movies(id,title,year,director_id) VALUES(9,'Dune',1984,5);
    INSERT INTO movies(id,title,year,director_id) VALUES(10,'Lost Highway',1997,5);

    INSERT INTO movies(id,title,year,director_id) VALUES(11,'Pulp Fiction',1994,6); 
    INSERT INTO movies(id,title,year,director_id) VALUES(12,'Once Upon a Time.. in Hollywood',2019,6);

    INSERT INTO movies(id,title,year,director_id) VALUES(13,'Titanic',1997,7);
    INSERT INTO movies(id,title,year,director_id) VALUES(14,'Avatar',2009,7);

    INSERT INTO movies(id,title,year,director_id) VALUES(15,'2001: A Space Odyssey',1968,8);
    INSERT INTO movies(id,title,year,director_id) VALUES(16,'The Shining',1980,8);

    INSERT INTO movies(id,title,year,director_id) VALUES(17,'The Departed',2006,9);
    INSERT INTO movies(id,title,year,director_id) VALUES(18,'Goodfellas',1990,9);

    INSERT INTO movies(id,title,year,director_id) VALUES(19,'Psycho',1960,10);
    INSERT INTO movies(id,title,year,director_id) VALUES(20,'Vertigo',1958,10);

    INSERT INTO movies(id,title,year,director_id) VALUES(21,'The Godfather',1972,11);
    INSERT INTO movies(id,title,year,director_id) VALUES(22,'The Godfather: Part II',1974,11);
    INSERT INTO movies(id,title,year,director_id) VALUES(23,'The Godfather: Part III',1990,11);

    INSERT INTO movies(id,title,year,director_id) VALUES(24,'Star Wars',1977,12);

END;
