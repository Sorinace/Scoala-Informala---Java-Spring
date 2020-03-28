DROP TABLE IF EXISTS artwork;
CREATE TABLE artwork(id serial PRIMARY KEY, speaker_id INTEGER REFERENCES speakers (id) ON DELETE CASCADE, picture VARCHAR(50));