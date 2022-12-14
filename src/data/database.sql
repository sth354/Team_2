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

    INSERT INTO facts(id, fact) VALUES (1, 'It is physically impossible for pigs to look up into the sky.');
    INSERT INTO facts(id, fact) VALUES (2, 'In Joker, Joaquin Phoenix lost 52 pounds to play the role of Arthur Fleck.');
    INSERT INTO facts(id, fact) VALUES (3, 'One famous "Pulp Fiction" scene was filmed backward');

    INSERT INTO directors(id,name) VALUES(2378215,'Bang Woo-ri');
    INSERT INTO movies(id,title,year,director_id) VALUES(851644,'20th Century Girl',2022,2378215);
    INSERT INTO directors(id,name) VALUES(1776,'Francis Ford Coppola');
    INSERT INTO movies(id,title,year,director_id) VALUES(238,'The Godfather',1972,1776);
    INSERT INTO directors(id,name) VALUES(4027,'Frank Darabont');
    INSERT INTO movies(id,title,year,director_id) VALUES(278,'The Shawshank Redemption',1994,4027);
    INSERT INTO directors(id,name) VALUES(2377386,'MTJJ');
    INSERT INTO movies(id,title,year,director_id) VALUES(620249,'The Legend of Hei',2019,2377386);
    INSERT INTO directors(id,name) VALUES(488,'Steven Spielberg');
    INSERT INTO movies(id,title,year,director_id) VALUES(424,'Schindler''s List',1993,488);
    INSERT INTO directors(id,name) VALUES(35771,'Aditya Chopra');
    INSERT INTO movies(id,title,year,director_id) VALUES(19404,'Dilwale Dulhania Le Jayenge',1995,35771);
    INSERT INTO directors(id,name) VALUES(1205254,'Ernesto Contreras');
    INSERT INTO movies(id,title,year,director_id) VALUES(667257,'Impossible Things',2021,1205254);
    INSERT INTO directors(id,name) VALUES(608,'Hayao Miyazaki');
    INSERT INTO movies(id,title,year,director_id) VALUES(129,'Spirited Away',2001,608);
    INSERT INTO directors(id,name) VALUES(39996,'Sidney Lumet');
    INSERT INTO movies(id,title,year,director_id) VALUES(389,'12 Angry Men',1957,39996);
    INSERT INTO directors(id,name) VALUES(1549377,'Shouko Nakamura');
    INSERT INTO movies(id,title,year,director_id) VALUES(372754,'Dou kyu sei – Classmates',2016,1549377);
    INSERT INTO directors(id,name) VALUES(74091,'Makoto Shinkai');
    INSERT INTO movies(id,title,year,director_id) VALUES(372058,'Your Name.',2016,74091);
    INSERT INTO directors(id,name) VALUES(21684,'Bong Joon-ho');
    INSERT INTO movies(id,title,year,director_id) VALUES(496243,'Parasite',2019,21684);
    INSERT INTO directors(id,name) VALUES(525,'Christopher Nolan');
    INSERT INTO movies(id,title,year,director_id) VALUES(155,'The Dark Knight',2008,525);
    INSERT INTO directors(id,name) VALUES(935563,'Tosca Musk');
    INSERT INTO movies(id,title,year,director_id) VALUES(724089,'Gabriel''s Inferno: Part II',2020,935563);
    INSERT INTO directors(id,name) VALUES(2042738,'Park Jun-soo');
    INSERT INTO movies(id,title,year,director_id) VALUES(553512,'Burn the Stage: The Movie',2018,2042738);
    INSERT INTO directors(id,name) VALUES(138,'Quentin Tarantino');
    INSERT INTO movies(id,title,year,director_id) VALUES(680,'Pulp Fiction',1994,138);
    INSERT INTO directors(id,name) VALUES(4385,'Sergio Leone');
    INSERT INTO movies(id,title,year,director_id) VALUES(429,'The Good, the Bad and the Ugly',1966,4385);
    INSERT INTO directors(id,name) VALUES(24,'Robert Zemeckis');
    INSERT INTO movies(id,title,year,director_id) VALUES(13,'Forrest Gump',1994,24);
    INSERT INTO directors(id,name) VALUES(108,'Peter Jackson');
    INSERT INTO movies(id,title,year,director_id) VALUES(122,'The Lord of the Rings: The Return of the King',2003,108);
    INSERT INTO directors(id,name) VALUES(1032,'Martin Scorsese');
    INSERT INTO movies(id,title,year,director_id) VALUES(769,'GoodFellas',1990,1032);
    INSERT INTO directors(id,name) VALUES(65314,'Giuseppe Tornatore');
    INSERT INTO movies(id,title,year,director_id) VALUES(11216,'Cinema Paradiso',1988,65314);
    INSERT INTO directors(id,name) VALUES(4818,'Roberto Benigni');
    INSERT INTO movies(id,title,year,director_id) VALUES(637,'Life Is Beautiful',1997,4818);
    INSERT INTO directors(id,name) VALUES(5026,'Akira Kurosawa');
    INSERT INTO movies(id,title,year,director_id) VALUES(346,'Seven Samurai',1954,5026);
    INSERT INTO directors(id,name) VALUES(2636,'Alfred Hitchcock');
    INSERT INTO movies(id,title,year,director_id) VALUES(539,'Psycho',1960,2636);
    INSERT INTO directors(id,name) VALUES(628,'Isao Takahata');
    INSERT INTO movies(id,title,year,director_id) VALUES(12477,'Grave of the Fireflies',1988,628);
    INSERT INTO directors(id,name) VALUES(76978,'Masaki Kobayashi');
    INSERT INTO movies(id,title,year,director_id) VALUES(14537,'Harakiri',1962,76978);
    INSERT INTO directors(id,name) VALUES(126809,'Lee Joon-ik');
    INSERT INTO movies(id,title,year,director_id) VALUES(255709,'Hope',2013,126809);
    INSERT INTO directors(id,name) VALUES(7467,'David Fincher');
    INSERT INTO movies(id,title,year,director_id) VALUES(550,'Fight Club',1999,7467);
    INSERT INTO directors(id,name) VALUES(3974,'Miloš Forman');
    INSERT INTO movies(id,title,year,director_id) VALUES(510,'One Flew Over the Cuckoo''s Nest',1975,3974);
    INSERT INTO directors(id,name) VALUES(185438,'Genndy Tartakovsky');
    INSERT INTO movies(id,title,year,director_id) VALUES(704264,'Primal: Tales of Savagery',2019,185438);
    INSERT INTO directors(id,name) VALUES(102560,'Guel Arraes');
    INSERT INTO movies(id,title,year,director_id) VALUES(40096,'A Dog''s Will',2000,102560);
    INSERT INTO directors(id,name) VALUES(59918,'Rodney Rothman');
    INSERT INTO movies(id,title,year,director_id) VALUES(324857,'Spider-Man: Into the Spider-Verse',2018,59918);
    INSERT INTO directors(id,name) VALUES(992866,'Takahiro Omori');
    INSERT INTO movies(id,title,year,director_id) VALUES(92321,'Hotarubi no Mori e',2011,992866);
    INSERT INTO directors(id,name) VALUES(1072778,'Naoko Yamada');
    INSERT INTO movies(id,title,year,director_id) VALUES(378064,'A Silent Voice: The Movie',2016,1072778);
    INSERT INTO directors(id,name) VALUES(10930,'Irvin Kershner');
    INSERT INTO movies(id,title,year,director_id) VALUES(1891,'The Empire Strikes Back',1980,10930);
    INSERT INTO directors(id,name) VALUES(2232175,'Son Sung-deuk');
    INSERT INTO movies(id,title,year,director_id) VALUES(568300,'BTS World Tour: Love Yourself in Seoul',2019,2232175);
    INSERT INTO directors(id,name) VALUES(77921,'Hideaki Anno');
    INSERT INTO movies(id,title,year,director_id) VALUES(18491,'Neon Genesis Evangelion: The End of Evangelion',1997,77921);
    INSERT INTO directors(id,name) VALUES(3556,'Roman Polanski');
    INSERT INTO movies(id,title,year,director_id) VALUES(423,'The Pianist',2002,3556);
    INSERT INTO directors(id,name) VALUES(1582093,'Kotaro Tamura');
    INSERT INTO movies(id,title,year,director_id) VALUES(652837,'Josee, the Tiger and the Fish',2020,1582093);
    INSERT INTO directors(id,name) VALUES(3146,'Billy Wilder');
    INSERT INTO movies(id,title,year,director_id) VALUES(599,'Sunset Boulevard',1950,3146);
    INSERT INTO directors(id,name) VALUES(2217620,'Amp Wong');
    INSERT INTO movies(id,title,year,director_id) VALUES(795607,'Green Snake',2021,2217620);
    INSERT INTO directors(id,name) VALUES(136495,'Damien Chazelle');
    INSERT INTO movies(id,title,year,director_id) VALUES(244786,'Whiplash',2014,136495);
    INSERT INTO directors(id,name) VALUES(814,'Tony Kaye');
    INSERT INTO movies(id,title,year,director_id) VALUES(73,'American History X',1998,814);
    INSERT INTO directors(id,name) VALUES(2428,'Ernst Lubitsch');
    INSERT INTO movies(id,title,year,director_id) VALUES(20334,'The Shop Around the Corner',1940,2428);
    INSERT INTO directors(id,name) VALUES(13848,'Charlie Chaplin');
    INSERT INTO movies(id,title,year,director_id) VALUES(914,'The Great Dictator',1940,13848);
    INSERT INTO directors(id,name) VALUES(1640511,'Jorge Ulloa');
    INSERT INTO movies(id,title,year,director_id) VALUES(644479,'Dedicated to my ex',2019,1640511);
    INSERT INTO directors(id,name) VALUES(86270,'Joseph Kosinski');
    INSERT INTO movies(id,title,year,director_id) VALUES(361743,'Top Gun: Maverick',2022,86270);
    INSERT INTO directors(id,name) VALUES(2564771,'Hikaru Yamaguchi');
    INSERT INTO movies(id,title,year,director_id) VALUES(632632,'Given',2020,2564771);
    INSERT INTO directors(id,name) VALUES(96676,'Tomm Moore');
    INSERT INTO movies(id,title,year,director_id) VALUES(441130,'Wolfwalkers',2020,96676);
    INSERT INTO directors(id,name) VALUES(16294,'Jonathan Demme');
    INSERT INTO movies(id,title,year,director_id) VALUES(274,'The Silence of the Lambs',1991,16294);
    INSERT INTO directors(id,name) VALUES(1484773,'Taichi Ishidate');
    INSERT INTO movies(id,title,year,director_id) VALUES(533514,'Violet Evergarden: The Movie',2020,1484773);
    INSERT INTO directors(id,name) VALUES(59,'Luc Besson');
    INSERT INTO movies(id,title,year,director_id) VALUES(101,'Léon: The Professional',1994,59);
    INSERT INTO directors(id,name) VALUES(2690,'Peter Weir');
    INSERT INTO movies(id,title,year,director_id) VALUES(207,'Dead Poets Society',1989,2690);
    INSERT INTO directors(id,name) VALUES(88675,'Justin Baldoni');
    INSERT INTO movies(id,title,year,director_id) VALUES(630566,'Clouds',2020,88675);
    INSERT INTO directors(id,name) VALUES(1283010,'Haruo Sotozaki');
    INSERT INTO movies(id,title,year,director_id) VALUES(635302,'Demon Slayer -Kimetsu no Yaiba- The Movie: Mugen Train',2020,1283010);
    INSERT INTO directors(id,name) VALUES(93406,'Elem Klimov');
    INSERT INTO movies(id,title,year,director_id) VALUES(25237,'Come and See',1985,93406);
    INSERT INTO directors(id,name) VALUES(586154,'Mitja Okorn');
    INSERT INTO movies(id,title,year,director_id) VALUES(447362,'Life in a Year',2020,586154);
    INSERT INTO directors(id,name) VALUES(1223175,'Elizabeth Allen Rosenbaum');
    INSERT INTO movies(id,title,year,director_id) VALUES(762975,'Purple Hearts',2022,1223175);
    INSERT INTO directors(id,name) VALUES(1485823,'Thomas Kail');
    INSERT INTO movies(id,title,year,director_id) VALUES(556574,'Hamilton',2020,1485823);
    INSERT INTO directors(id,name) VALUES(2264366,'Sunghoo Park');
    INSERT INTO movies(id,title,year,director_id) VALUES(810693,'Jujutsu Kaisen 0',2021,2264366);
    INSERT INTO directors(id,name) VALUES(240,'Stanley Kubrick');
    INSERT INTO movies(id,title,year,director_id) VALUES(975,'Paths of Glory',1957,240);
    INSERT INTO directors(id,name) VALUES(103393,'Jacques Becker');
    INSERT INTO movies(id,title,year,director_id) VALUES(29259,'Le Trou',1960,103393);
    INSERT INTO directors(id,name) VALUES(1637776,'Matt Peters');
    INSERT INTO movies(id,title,year,director_id) VALUES(618344,'Justice League Dark: Apokolips War',2020,1637776);
    INSERT INTO directors(id,name) VALUES(40333,'Satoshi Kon');
    INSERT INTO movies(id,title,year,director_id) VALUES(10494,'Perfect Blue',1997,40333);
    INSERT INTO directors(id,name) VALUES(19271,'Anthony Russo');
    INSERT INTO movies(id,title,year,director_id) VALUES(299534,'Avengers: Endgame',2019,19271);
    INSERT INTO directors(id,name) VALUES(230767,'Mehmet Ada Öztekin');
    INSERT INTO movies(id,title,year,director_id) VALUES(637920,'Miracle in Cell No. 7',2019,230767);
    INSERT INTO directors(id,name) VALUES(1145368,'Souichi Masui');
    INSERT INTO movies(id,title,year,director_id) VALUES(572154,'Rascal Does Not Dream of a Dreaming Girl',2019,1145368);
    INSERT INTO directors(id,name) VALUES(31894,'Ettore Scola');
    INSERT INTO movies(id,title,year,director_id) VALUES(42269,'We All Loved Each Other So Much',1974,31894);
    INSERT INTO directors(id,name) VALUES(1245726,'Rebecca Sugar');
    INSERT INTO movies(id,title,year,director_id) VALUES(537061,'Steven Universe: The Movie',2019,1245726);
    INSERT INTO directors(id,name) VALUES(96801,'Hiroshi Teshigahara');
    INSERT INTO movies(id,title,year,director_id) VALUES(16672,'Woman in the Dunes',1964,96801);
    INSERT INTO directors(id,name) VALUES(143035,'Edward Yang');
    INSERT INTO movies(id,title,year,director_id) VALUES(15804,'A Brighter Summer Day',1991,143035);
    INSERT INTO directors(id,name) VALUES(84425,'Éric Toledano');
    INSERT INTO movies(id,title,year,director_id) VALUES(77338,'The Intouchables',2011,84425);
    INSERT INTO directors(id,name) VALUES(10099,'Park Chan-wook');
    INSERT INTO movies(id,title,year,director_id) VALUES(670,'Oldboy',2003,10099);
    INSERT INTO directors(id,name) VALUES(143593,'Xavier Dolan');
    INSERT INTO movies(id,title,year,director_id) VALUES(265177,'Mommy',2014,143593);
    INSERT INTO directors(id,name) VALUES(2662,'Frank Capra');
    INSERT INTO movies(id,title,year,director_id) VALUES(1585,'It''s a Wonderful Life',1946,2662);
    INSERT INTO directors(id,name) VALUES(84969,'Kim Yong-hwa');
    INSERT INTO movies(id,title,year,director_id) VALUES(518068,'Along with the Gods: The Last 49 Days',2018,84969);
    INSERT INTO directors(id,name) VALUES(133502,'Simon Curtis');
    INSERT INTO movies(id,title,year,director_id) VALUES(522924,'The Art of Racing in the Rain',2019,133502);
    INSERT INTO directors(id,name) VALUES(15812,'Roger Allers');
    INSERT INTO movies(id,title,year,director_id) VALUES(8587,'The Lion King',1994,15812);
    INSERT INTO directors(id,name) VALUES(124749,'Sergio Pablos');
    INSERT INTO movies(id,title,year,director_id) VALUES(508965,'Klaus',2019,124749);
    INSERT INTO directors(id,name) VALUES(6648,'Ingmar Bergman');
    INSERT INTO movies(id,title,year,director_id) VALUES(797,'Persona',1966,6648);
    INSERT INTO directors(id,name) VALUES(1257117,'Mari Okada');
    INSERT INTO movies(id,title,year,director_id) VALUES(476292,'Maquia: When the Promised Flower Blooms',2018,1257117);
    INSERT INTO directors(id,name) VALUES(1281402,'Takaomi Kanasaki');
    INSERT INTO movies(id,title,year,director_id) VALUES(532067,'KonoSuba: God''s Blessing on this Wonderful World! Legend of Crimson',2019,1281402);
    INSERT INTO directors(id,name) VALUES(1307036,'Kenji Nagasaki');
    INSERT INTO movies(id,title,year,director_id) VALUES(592350,'My Hero Academia: Heroes Rising',2019,1307036);
    INSERT INTO directors(id,name) VALUES(115128,'Bo Burnham');
    INSERT INTO movies(id,title,year,director_id) VALUES(823754,'Bo Burnham: Inside',2021,115128);
    INSERT INTO directors(id,name) VALUES(57641,'Dino Risi');
    INSERT INTO movies(id,title,year,director_id) VALUES(24188,'Il Sorpasso',1962,57641);
    INSERT INTO directors(id,name) VALUES(125105,'Derek Tsang');
    INSERT INTO movies(id,title,year,director_id) VALUES(575813,'Better Days',2019,125105);
    INSERT INTO directors(id,name) VALUES(7396,'Peter Farrelly');
    INSERT INTO movies(id,title,year,director_id) VALUES(490132,'Green Book',2018,7396);
    INSERT INTO directors(id,name) VALUES(15217,'Zack Snyder');
    INSERT INTO movies(id,title,year,director_id) VALUES(791373,'Zack Snyder''s Justice League',2021,15217);
    INSERT INTO directors(id,name) VALUES(42274,'Nick Hurran');
    INSERT INTO movies(id,title,year,director_id) VALUES(313106,'Doctor Who: The Day of the Doctor',2013,42274);
    INSERT INTO directors(id,name) VALUES(81718,'Mamoru Hosoda');
    INSERT INTO movies(id,title,year,director_id) VALUES(110420,'Wolf Children',2012,81718);
    INSERT INTO directors(id,name) VALUES(12329,'Vittorio De Sica');
    INSERT INTO movies(id,title,year,director_id) VALUES(5156,'Bicycle Thieves',1948,12329);
    INSERT INTO directors(id,name) VALUES(1565301,'Thomas Astruc');
    INSERT INTO movies(id,title,year,director_id) VALUES(755812,'Miraculous World: New York, United HeroeZ',2020,1565301);
    INSERT INTO directors(id,name) VALUES(1938744,'Shinichiro Ushijima');
    INSERT INTO movies(id,title,year,director_id) VALUES(504253,'I Want to Eat Your Pancreas',2018,1938744);
    INSERT INTO directors(id,name) VALUES(8,'Lee Unkrich');
    INSERT INTO movies(id,title,year,director_id) VALUES(354912,'Coco',2017,8);
    INSERT INTO directors(id,name) VALUES(1661032,'Haruka Fujita');
    INSERT INTO movies(id,title,year,director_id) VALUES(610892,'Violet Evergarden: Eternity and the Auto Memory Doll',2019,1661032);
    INSERT INTO directors(id,name) VALUES(8452,'Andrei Tarkovsky');
    INSERT INTO movies(id,title,year,director_id) VALUES(1398,'Stalker',1979,8452);
    INSERT INTO directors(id,name) VALUES(4415,'Federico Fellini');
    INSERT INTO movies(id,title,year,director_id) VALUES(422,'8½',1963,4415);
    INSERT INTO directors(id,name) VALUES(204553,'Ethan Spaulding');
    INSERT INTO movies(id,title,year,director_id) VALUES(664767,'Mortal Kombat Legends: Scorpion''s Revenge',2020,204553);
    INSERT INTO directors(id,name) VALUES(85637,'Béla Tarr');
    INSERT INTO movies(id,title,year,director_id) VALUES(31414,'Satantango',1994,85637);
    INSERT INTO directors(id,name) VALUES(1,'George Lucas');
    INSERT INTO movies(id,title,year,director_id) VALUES(11,'Star Wars',1977,1);
    INSERT INTO directors(id,name) VALUES(66121,'George Tillman, Jr.');
    INSERT INTO movies(id,title,year,director_id) VALUES(470044,'The Hate U Give',2018,66121);
    INSERT INTO directors(id,name) VALUES(95456,'Elio Petri');
    INSERT INTO movies(id,title,year,director_id) VALUES(26451,'Investigation of a Citizen Above Suspicion',1970,95456);
    INSERT INTO directors(id,name) VALUES(578,'Ridley Scott');
    INSERT INTO movies(id,title,year,director_id) VALUES(98,'Gladiator',2000,578);
    INSERT INTO directors(id,name) VALUES(25161,'Marcel Carné');
    INSERT INTO movies(id,title,year,director_id) VALUES(2457,'Children of Paradise',1945,25161);
    INSERT INTO directors(id,name) VALUES(9032,'Bryan Singer');
    INSERT INTO movies(id,title,year,director_id) VALUES(629,'The Usual Suspects',1995,9032);
    INSERT INTO directors(id,name) VALUES(55789,'Tate Taylor');
    INSERT INTO movies(id,title,year,director_id) VALUES(50014,'The Help',2011,55789);
    INSERT INTO directors(id,name) VALUES(68813,'Céline Sciamma');
    INSERT INTO movies(id,title,year,director_id) VALUES(531428,'Portrait of a Lady on Fire',2019,68813);
    INSERT INTO directors(id,name) VALUES(1665497,'Zhao Ji');
    INSERT INTO movies(id,title,year,director_id) VALUES(663558,'New Gods: Nezha Reborn',2021,1665497);
    INSERT INTO directors(id,name) VALUES(9339,'Lilly Wachowski');
    INSERT INTO movies(id,title,year,director_id) VALUES(603,'The Matrix',1999,9339);
    INSERT INTO directors(id,name) VALUES(78160,'Luca Guadagnino');
    INSERT INTO movies(id,title,year,director_id) VALUES(398818,'Call Me by Your Name',2017,78160);
    INSERT INTO directors(id,name) VALUES(2461,'Mel Gibson');
    INSERT INTO movies(id,title,year,director_id) VALUES(324786,'Hacksaw Ridge',2016,2461);
    INSERT INTO directors(id,name) VALUES(1706418,'Susana Garcia');
    INSERT INTO movies(id,title,year,director_id) VALUES(620683,'My Mom is a Character 3',2019,1706418);
    INSERT INTO directors(id,name) VALUES(8012,'Alan Barillaro');
    INSERT INTO movies(id,title,year,director_id) VALUES(399106,'Piper',2016,8012);
    INSERT INTO directors(id,name) VALUES(935910,'Javier Soto');
    INSERT INTO movies(id,title,year,director_id) VALUES(297610,'Abraham Lincoln Vampire Hunter: The Great Calamity',2012,935910);
    INSERT INTO directors(id,name) VALUES(53431,'Nadine Labaki');
    INSERT INTO movies(id,title,year,director_id) VALUES(517814,'Capernaum',2018,53431);
    INSERT INTO directors(id,name) VALUES(12890,'Pete Docter');
    INSERT INTO movies(id,title,year,director_id) VALUES(508442,'Soul',2020,12890);
    INSERT INTO directors(id,name) VALUES(57130,'Todd Phillips');
    INSERT INTO movies(id,title,year,director_id) VALUES(475557,'Joker',2019,57130);
    INSERT INTO directors(id,name) VALUES(68,'Fritz Lang');
    INSERT INTO movies(id,title,year,director_id) VALUES(19,'Metropolis',1927,68);
    INSERT INTO directors(id,name) VALUES(1168139,'Ashley Avis');
    INSERT INTO movies(id,title,year,director_id) VALUES(526702,'Black Beauty',2020,1168139);
    INSERT INTO directors(id,name) VALUES(19311,'Stephen Chbosky');
    INSERT INTO movies(id,title,year,director_id) VALUES(406997,'Wonder',2017,19311);
    INSERT INTO directors(id,name) VALUES(32375,'Mario Monicelli');
    INSERT INTO movies(id,title,year,director_id) VALUES(20914,'My Friends',1975,32375);
    INSERT INTO directors(id,name) VALUES(13284,'Stanley Donen');
    INSERT INTO movies(id,title,year,director_id) VALUES(872,'Singin'' in the Rain',1952,13284);
    INSERT INTO directors(id,name) VALUES(97202,'Kenji Mizoguchi');
    INSERT INTO movies(id,title,year,director_id) VALUES(20532,'Sansho the Bailiff',1954,97202);
    INSERT INTO directors(id,name) VALUES(4109,'Michael Curtiz');
    INSERT INTO movies(id,title,year,director_id) VALUES(289,'Casablanca',1942,4109);
    INSERT INTO directors(id,name) VALUES(1150,'Brian De Palma');
    INSERT INTO movies(id,title,year,director_id) VALUES(111,'Scarface',1983,1150);
    INSERT INTO directors(id,name) VALUES(2335448,'Natalie Nourigat');
    INSERT INTO movies(id,title,year,director_id) VALUES(831827,'Far from the Tree',2021,2335448);
    INSERT INTO directors(id,name) VALUES(10601,'Joseph L. Mankiewicz');
    INSERT INTO movies(id,title,year,director_id) VALUES(705,'All About Eve',1950,10601);
    INSERT INTO directors(id,name) VALUES(1118818,'Pepe Bojórquez');
    INSERT INTO movies(id,title,year,director_id) VALUES(654299,'Out of the Clear Blue Sky',2019,1118818);
    INSERT INTO directors(id,name) VALUES(2436936,'Gianluca Leuzzi');
    INSERT INTO movies(id,title,year,director_id) VALUES(640344,'Me Against You: Mr. S''s Vendetta',2020,2436936);
    INSERT INTO directors(id,name) VALUES(21673,'Ericson Core');
    INSERT INTO movies(id,title,year,director_id) VALUES(606856,'Togo',2019,21673);
    INSERT INTO directors(id,name) VALUES(1150548,'Florian Zeller');
    INSERT INTO movies(id,title,year,director_id) VALUES(600354,'The Father',2020,1150548);
    INSERT INTO directors(id,name) VALUES(956,'Guy Ritchie');
    INSERT INTO movies(id,title,year,director_id) VALUES(100,'Lock, Stock and Two Smoking Barrels',1998,956);
    INSERT INTO directors(id,name) VALUES(8574,'Walter Salles');
    INSERT INTO movies(id,title,year,director_id) VALUES(666,'Central Station',1998,8574);
    INSERT INTO directors(id,name) VALUES(5216,'Gus Van Sant');
    INSERT INTO movies(id,title,year,director_id) VALUES(489,'Good Will Hunting',1997,5216);
    INSERT INTO directors(id,name) VALUES(8635,'Buster Keaton');
    INSERT INTO movies(id,title,year,director_id) VALUES(992,'Sherlock Jr.',1924,8635);
    INSERT INTO directors(id,name) VALUES(23683,'Tony Cervone');
    INSERT INTO movies(id,title,year,director_id) VALUES(347688,'Scooby-Doo! and Kiss: Rock and Roll Mystery',2015,23683);
    INSERT INTO directors(id,name) VALUES(1876416,'Can Ulkay');
    INSERT INTO movies(id,title,year,director_id) VALUES(472454,'Ayla: The Daughter of War',2017,1876416);
    INSERT INTO directors(id,name) VALUES(1317730,'Daniel Scheinert');
    INSERT INTO movies(id,title,year,director_id) VALUES(545611,'Everything Everywhere All at Once',2022,1317730);
    INSERT INTO directors(id,name) VALUES(1051305,'Oriol Paulo');
    INSERT INTO movies(id,title,year,director_id) VALUES(411088,'The Invisible Guest',2017,1051305);
    INSERT INTO directors(id,name) VALUES(134306,'Kevin Sullivan');
    INSERT INTO movies(id,title,year,director_id) VALUES(17663,'Anne of Green Gables',1985,134306);
    INSERT INTO directors(id,name) VALUES(1169024,'Ilya Naishuller');
    INSERT INTO movies(id,title,year,director_id) VALUES(615457,'Nobody',2021,1169024);
    INSERT INTO directors(id,name) VALUES(4610,'John Landis');
    INSERT INTO movies(id,title,year,director_id) VALUES(92060,'Michael Jackson''s Thriller',1983,4610);
    INSERT INTO directors(id,name) VALUES(52870,'Tim Johnson');
    INSERT INTO movies(id,title,year,director_id) VALUES(638507,'How to Train Your Dragon: Homecoming',2019,52870);
    INSERT INTO directors(id,name) VALUES(11343,'David Yates');
    INSERT INTO movies(id,title,year,director_id) VALUES(12445,'Harry Potter and the Deathly Hallows: Part 2',2011,11343);
    INSERT INTO directors(id,name) VALUES(50767,'Craig Gillespie');
    INSERT INTO movies(id,title,year,director_id) VALUES(337404,'Cruella',2021,50767);
    INSERT INTO directors(id,name) VALUES(32245,'Arturo Brachetti');
    INSERT INTO movies(id,title,year,director_id) VALUES(38288,'I corti',1996,32245);
    INSERT INTO directors(id,name) VALUES(2303,'Wim Wenders');
    INSERT INTO movies(id,title,year,director_id) VALUES(655,'Paris, Texas',1984,2303);
    INSERT INTO directors(id,name) VALUES(2472702,'Matías Moltrasio');
    INSERT INTO movies(id,title,year,director_id) VALUES(652722,'In the Arms of an Assassin',2019,2472702);
    INSERT INTO directors(id,name) VALUES(1145621,'Jon Olb');
    INSERT INTO movies(id,title,year,director_id) VALUES(529531,'Hannah Gadsby: Nanette',2018,1145621);
    INSERT INTO directors(id,name) VALUES(12453,'Wong Kar-wai');
    INSERT INTO movies(id,title,year,director_id) VALUES(843,'In the Mood for Love',2000,12453);
    INSERT INTO directors(id,name) VALUES(201,'Michel Gondry');
    INSERT INTO movies(id,title,year,director_id) VALUES(38,'Eternal Sunshine of the Spotless Mind',2004,201);
    INSERT INTO directors(id,name) VALUES(1187130,'Michael Grandage');
    INSERT INTO movies(id,title,year,director_id) VALUES(744114,'My Policeman',2022,1187130);
    INSERT INTO directors(id,name) VALUES(223708,'Camillo Mastrocinque');
    INSERT INTO movies(id,title,year,director_id) VALUES(55960,'Toto, Peppino, and the Hussy',1956,223708);
    INSERT INTO directors(id,name) VALUES(46085,'Luis Mandoki');
    INSERT INTO movies(id,title,year,director_id) VALUES(20941,'Innocent Voices',2005,46085);
    INSERT INTO directors(id,name) VALUES(4453,'Thomas Vinterberg');
    INSERT INTO movies(id,title,year,director_id) VALUES(103663,'The Hunt',2012,4453);
    INSERT INTO directors(id,name) VALUES(4762,'Paul Thomas Anderson');
    INSERT INTO movies(id,title,year,director_id) VALUES(7345,'There Will Be Blood',2007,4762);
    INSERT INTO directors(id,name) VALUES(54472,'Martin McDonagh');
    INSERT INTO movies(id,title,year,director_id) VALUES(359940,'Three Billboards Outside Ebbing, Missouri',2017,54472);
    INSERT INTO directors(id,name) VALUES(36588,'Joe Wright');
    INSERT INTO movies(id,title,year,director_id) VALUES(4348,'Pride & Prejudice',2005,36588);
    INSERT INTO directors(id,name) VALUES(1173102,'Garth Davis');
    INSERT INTO movies(id,title,year,director_id) VALUES(334543,'Lion',2016,1173102);
    INSERT INTO directors(id,name) VALUES(1294471,'Hwang Dong-hyuk');
    INSERT INTO movies(id,title,year,director_id) VALUES(81481,'Silenced',2011,1294471);
    INSERT INTO directors(id,name) VALUES(137427,'Denis Villeneuve');
    INSERT INTO movies(id,title,year,director_id) VALUES(46738,'Incendies',2010,137427);
    INSERT INTO directors(id,name) VALUES(12160,'Satyajit Ray');
    INSERT INTO movies(id,title,year,director_id) VALUES(5801,'Pather Panchali',1955,12160);
    INSERT INTO directors(id,name) VALUES(1650,'François Truffaut');
    INSERT INTO movies(id,title,year,director_id) VALUES(147,'The 400 Blows',1959,1650);
    INSERT INTO directors(id,name) VALUES(2710,'James Cameron');
    INSERT INTO movies(id,title,year,director_id) VALUES(280,'Terminator 2: Judgment Day',1991,2710);
    INSERT INTO directors(id,name) VALUES(11572,'Carl Theodor Dreyer');
    INSERT INTO movies(id,title,year,director_id) VALUES(780,'The Passion of Joan of Arc',1928,11572);
    INSERT INTO directors(id,name) VALUES(2406,'Mathieu Kassovitz');
    INSERT INTO movies(id,title,year,director_id) VALUES(406,'La Haine',1995,2406);
    INSERT INTO directors(id,name) VALUES(5231,'Wolfgang Petersen');
    INSERT INTO movies(id,title,year,director_id) VALUES(387,'Das Boot',1981,5231);
    INSERT INTO directors(id,name) VALUES(18596,'Taylor Hackford');
    INSERT INTO movies(id,title,year,director_id) VALUES(9702,'Bound by Honor',1993,18596);
    INSERT INTO directors(id,name) VALUES(15127,'Luchino Visconti');
    INSERT INTO movies(id,title,year,director_id) VALUES(8422,'Rocco and His Brothers',1960,15127);
    INSERT INTO directors(id,name) VALUES(5602,'David Lynch');
    INSERT INTO movies(id,title,year,director_id) VALUES(1955,'The Elephant Man',1980,5602);
    INSERT INTO directors(id,name) VALUES(148747,'Jang Hoon');
    INSERT INTO movies(id,title,year,director_id) VALUES(437068,'A Taxi Driver',2017,148747);
    INSERT INTO directors(id,name) VALUES(55934,'Taika Waititi');
    INSERT INTO movies(id,title,year,director_id) VALUES(515001,'Jojo Rabbit',2019,55934);
    INSERT INTO directors(id,name) VALUES(88967,'Greg Berlanti');
    INSERT INTO movies(id,title,year,director_id) VALUES(449176,'Love, Simon',2018,88967);
    INSERT INTO directors(id,name) VALUES(70235,'Marco Tullio Giordana');
    INSERT INTO movies(id,title,year,director_id) VALUES(11659,'The Best of Youth',2003,70235);
    INSERT INTO directors(id,name) VALUES(7,'Andrew Stanton');
    INSERT INTO movies(id,title,year,director_id) VALUES(10681,'WALL·E',2008,7);
    INSERT INTO directors(id,name) VALUES(52968,'Russell Mulcahy');
    INSERT INTO movies(id,title,year,director_id) VALUES(21634,'Prayers for Bobby',2009,52968);
    INSERT INTO directors(id,name) VALUES(1141683,'Theodore Melfi');
    INSERT INTO movies(id,title,year,director_id) VALUES(381284,'Hidden Figures',2016,1141683);
    INSERT INTO directors(id,name) VALUES(26473,'Fisher Stevens');
    INSERT INTO movies(id,title,year,director_id) VALUES(458220,'Palmer',2021,26473);
    INSERT INTO directors(id,name) VALUES(52576,'José Padilha');
    INSERT INTO movies(id,title,year,director_id) VALUES(7347,'Elite Squad',2007,52576);
    INSERT INTO directors(id,name) VALUES(5655,'Wes Anderson');
    INSERT INTO movies(id,title,year,director_id) VALUES(120467,'The Grand Budapest Hotel',2014,5655);
    INSERT INTO directors(id,name) VALUES(37846,'Emeric Pressburger');
    INSERT INTO movies(id,title,year,director_id) VALUES(19542,'The Red Shoes',1948,37846);
    INSERT INTO directors(id,name) VALUES(1202504,'Alessio Cremonini');
    INSERT INTO movies(id,title,year,director_id) VALUES(538362,'On My Skin',2018,1202504);
    INSERT INTO directors(id,name) VALUES(1003237,'Dorota Kobiela');
    INSERT INTO movies(id,title,year,director_id) VALUES(339877,'Loving Vincent',2017,1003237);
    INSERT INTO directors(id,name) VALUES(1640509,'Orlando Herrera');
    INSERT INTO movies(id,title,year,director_id) VALUES(893941,'Misfit',2021,1640509);
    INSERT INTO directors(id,name) VALUES(1703328,'Raúl Martínez');
    INSERT INTO movies(id,title,year,director_id) VALUES(678580,'El mesero',2021,1703328);
    INSERT INTO directors(id,name) VALUES(127611,'Jim Donovan');
    INSERT INTO movies(id,title,year,director_id) VALUES(550776,'Believe Me: The Abduction of Lisa McVey',2018,127611);
    INSERT INTO directors(id,name) VALUES(87742,'Marc Webb');
    INSERT INTO movies(id,title,year,director_id) VALUES(400928,'Gifted',2017,87742);
    INSERT INTO directors(id,name) VALUES(1222374,'Jamie Payne');
    INSERT INTO movies(id,title,year,director_id) VALUES(282848,'Doctor Who: The Time of the Doctor',2013,1222374);
    INSERT INTO directors(id,name) VALUES(2135251,'Rosana Sullivan');
    INSERT INTO movies(id,title,year,director_id) VALUES(574074,'Kitbull',2019,2135251);
    INSERT INTO directors(id,name) VALUES(83281,'Lenny Abrahamson');
    INSERT INTO movies(id,title,year,director_id) VALUES(264644,'Room',2015,83281);
    INSERT INTO directors(id,name) VALUES(1472483,'Noé Santillán-López');
    INSERT INTO movies(id,title,year,director_id) VALUES(610461,'Veinteañera, Divorciada y Fantástica',2020,1472483);
    INSERT INTO directors(id,name) VALUES(1111685,'Dennis Bots');
    INSERT INTO movies(id,title,year,director_id) VALUES(115929,'Cool Kids Don''t Cry',2012,1111685);
    INSERT INTO directors(id,name) VALUES(4081,'Stanley Kramer');
    INSERT INTO movies(id,title,year,director_id) VALUES(821,'Judgment at Nuremberg',1961,4081);
    INSERT INTO directors(id,name) VALUES(8193,'Florian Henckel von Donnersmarck');
    INSERT INTO movies(id,title,year,director_id) VALUES(582,'The Lives of Others',2006,8193);
    INSERT INTO directors(id,name) VALUES(1809041,'Beth David');
    INSERT INTO movies(id,title,year,director_id) VALUES(455661,'In a Heartbeat',2017,1809041);
    INSERT INTO directors(id,name) VALUES(35736,'Karan Johar');
    INSERT INTO movies(id,title,year,director_id) VALUES(26022,'My Name Is Khan',2010,35736);
    INSERT INTO directors(id,name) VALUES(208113,'Sarah Smith');
    INSERT INTO movies(id,title,year,director_id) VALUES(482321,'Ron''s Gone Wrong',2021,208113);
    INSERT INTO directors(id,name) VALUES(132188,'Mario Mattoli');
    INSERT INTO movies(id,title,year,director_id) VALUES(58007,'Poverty and Nobility',1954,132188);
    INSERT INTO directors(id,name) VALUES(6431,'Darren Aronofsky');
    INSERT INTO movies(id,title,year,director_id) VALUES(641,'Requiem for a Dream',2000,6431);
    INSERT INTO directors(id,name) VALUES(1193597,'Amma Asante');
    INSERT INTO movies(id,title,year,director_id) VALUES(426618,'Where Hands Touch',2018,1193597);
    INSERT INTO directors(id,name) VALUES(550280,'Anna Muylaert');
    INSERT INTO movies(id,title,year,director_id) VALUES(310569,'The Second Mother',2015,550280);
    INSERT INTO directors(id,name) VALUES(39,'Sam Mendes');
    INSERT INTO movies(id,title,year,director_id) VALUES(14,'American Beauty',1999,39);
    INSERT INTO directors(id,name) VALUES(8578,'Daniel Rezende');
    INSERT INTO movies(id,title,year,director_id) VALUES(429210,'Bingo: The King of the Mornings',2017,8578);
    INSERT INTO directors(id,name) VALUES(8482,'Robert Mulligan');
    INSERT INTO movies(id,title,year,director_id) VALUES(595,'To Kill a Mockingbird',1962,8482);
    INSERT INTO directors(id,name) VALUES(9577,'George Roy Hill');
    INSERT INTO movies(id,title,year,director_id) VALUES(9277,'The Sting',1973,9577);
    INSERT INTO directors(id,name) VALUES(11770,'John Carpenter');
    INSERT INTO movies(id,title,year,director_id) VALUES(1091,'The Thing',1982,11770);
    INSERT INTO directors(id,name) VALUES(1293994,'Jon Watts');
    INSERT INTO movies(id,title,year,director_id) VALUES(634649,'Spider-Man: No Way Home',2021,1293994);
    INSERT INTO directors(id,name) VALUES(2559,'Henri-Georges Clouzot');
    INSERT INTO movies(id,title,year,director_id) VALUES(204,'The Wages of Fear',1953,2559);
    INSERT INTO directors(id,name) VALUES(1659094,'Cecilia Aranovich');
    INSERT INTO movies(id,title,year,director_id) VALUES(843906,'Straight Outta Nowhere: Scooby-Doo! Meets Courage the Cowardly Dog',2021,1659094);
    INSERT INTO directors(id,name) VALUES(1453550,'Chris Appelhans');
    INSERT INTO movies(id,title,year,director_id) VALUES(550205,'Wish Dragon',2021,1453550);
    INSERT INTO directors(id,name) VALUES(40,'Orson Welles');
    INSERT INTO movies(id,title,year,director_id) VALUES(15,'Citizen Kane',1941,40);
    INSERT INTO directors(id,name) VALUES(1212755,'Gail Mancuso');
    INSERT INTO movies(id,title,year,director_id) VALUES(522518,'A Dog''s Journey',2019,1212755);
    INSERT INTO directors(id,name) VALUES(11218,'Alfonso Cuarón');
    INSERT INTO movies(id,title,year,director_id) VALUES(673,'Harry Potter and the Prisoner of Azkaban',2004,11218);
    INSERT INTO directors(id,name) VALUES(79002,'Nacho G. Velilla');
    INSERT INTO movies(id,title,year,director_id) VALUES(554596,'No Manches Frida 2',2019,79002);
    INSERT INTO directors(id,name) VALUES(114404,'Miguel Sapochnik');
    INSERT INTO movies(id,title,year,director_id) VALUES(522402,'Finch',2021,114404);
    INSERT INTO directors(id,name) VALUES(6593,'John Huston');
    INSERT INTO movies(id,title,year,director_id) VALUES(3090,'The Treasure of the Sierra Madre',1948,6593);
    INSERT INTO directors(id,name) VALUES(793,'Luis Buñuel');
    INSERT INTO movies(id,title,year,director_id) VALUES(800,'The Young and the Damned',1950,793);

END;

