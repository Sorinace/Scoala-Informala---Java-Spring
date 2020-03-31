DROP TABLE IF EXISTS auth_user_group;
CREATE TABLE auth_user_group(
    id serial PRIMARY KEY,
    username VARCHAR(128) NOT NULL,
    auth_group VARCHAR(128) NOT NULL,
    user_auth_user_group_fk INTEGER REFERENCES username (user_id) ON DELETE CASCADE,
    UNIQUE (username, auth_group))