DROP TABLE IF EXISTS speakers;
CREATE TABLE speakers (id serial PRIMARY KEY, title VARCHAR(255), name VARCHAR(25), shortname VARCHAR(25),
summary VARCHAR(500), description VARCHAR(2100));