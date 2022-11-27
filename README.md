# Team_2

HBV501G Hugbúnaðarverkefni 1

## Project description
Director guessing game

## Deployed website
https://team2-production.up.railway.app/

## Team members
Axel Thor Aspelund <br>
Bjarni Haukur Bjarnason <br>
Freyr Guðmundsson <br>
Stefán Hermundsson <br>

## Quick start
Assumes that you have postgres installed on your machine. Refer to postgres quick start if not. <br>
https://www.postgresql.org/docs/9.1/tutorial-start.html <br>

1. Clone the repo: `git clone
2. Create a user in postgres
3. Input the user and password into src/main/resources/application.properties
4. Open a terminal in the root folder of the project
5. Run: ```psql -U <username>``` and enter the password
6. Connect to the database: ```\c gamedb```
7. Run the sql script: ```\i src/data/database.sql```
8. Run the application: ```mvn spring-boot:run``` or use your IDE to run the application

