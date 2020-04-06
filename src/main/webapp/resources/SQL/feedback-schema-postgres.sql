DROP TABLE IF EXISTS feedback;
CREATE TABLE feedback(id serial PRIMARY KEY, name VARCHAR(125), email VARCHAR(125), title VARCHAR(255),
message VARCHAR(2100), visible BOOL);