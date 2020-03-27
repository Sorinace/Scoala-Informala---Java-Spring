DROP TABLE IF EXISTS feedback;
CREATE TABLE feedback(id serial PRIMARY KEY, name VARCHAR(25), email VARCHAR(25), title VARCHAR(255),
message VARCHAR(2100), visible BOOL);