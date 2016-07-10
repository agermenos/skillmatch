CREATE TABLE address
(
    id INTEGER PRIMARY KEY NOT NULL,
    street VARCHAR NOT NULL,
    number VARCHAR,
    po_box VARCHAR,
    line_extra VARCHAR
);
CREATE TABLE catalog
(
    id INTEGER PRIMARY KEY NOT NULL,
    text VARCHAR,
    parent_id INTEGER
);
CREATE TABLE contact
(
    id INTEGER PRIMARY KEY NOT NULL,
    user_id INTEGER NOT NULL,
    contact_type_id INTEGER NOT NULL,
    contact_type_value VARCHAR
);
CREATE TABLE skill
(
    id INTEGER PRIMARY KEY NOT NULL,
    skill_desc INTEGER NOT NULL,
    skill_type INTEGER,
    date_added DATE,
    status_id INTEGER
);
CREATE TABLE skill_level
(
    id INTEGER PRIMARY KEY NOT NULL,
    skill_id INTEGER NOT NULL,
    level_id INTEGER NOT NULL
);
CREATE TABLE "user"
(
    id INTEGER PRIMARY KEY NOT NULL,
    name VARCHAR NOT NULL,
    last_name VARCHAR,
    address_id INTEGER NOT NULL,
    image_id INTEGER
);
CREATE TABLE user_skill
(
    id INTEGER PRIMARY KEY NOT NULL,
    user_id INTEGER NOT NULL,
    skill_level_id INTEGER NOT NULL,
    date_added DATE,
    status_id INTEGER
);
CREATE UNIQUE INDEX address_id_uindex ON address (id);
CREATE UNIQUE INDEX catalog_id_uindex ON catalog (id);
ALTER TABLE contact ADD FOREIGN KEY (user_id) REFERENCES contact (id);
ALTER TABLE contact ADD FOREIGN KEY (contact_type_id) REFERENCES catalog (id);
ALTER TABLE skill ADD FOREIGN KEY (skill_desc) REFERENCES ;
ALTER TABLE skill ADD FOREIGN KEY (skill_type) REFERENCES ;
ALTER TABLE skill ADD FOREIGN KEY (status_id) REFERENCES ;
ALTER TABLE skill_level ADD FOREIGN KEY (skill_id) REFERENCES skill (id);
ALTER TABLE skill_level ADD FOREIGN KEY (level_id) REFERENCES ;
CREATE UNIQUE INDEX skill_level_id_uindex ON skill_level (id);
ALTER TABLE "user" ADD FOREIGN KEY (address_id) REFERENCES address (id);
ALTER TABLE user_skill ADD FOREIGN KEY (user_id) REFERENCES "user" (id);
ALTER TABLE user_skill ADD FOREIGN KEY (skill_level_id) REFERENCES skill_level (id);
ALTER TABLE user_skill ADD FOREIGN KEY (status_id) REFERENCES ;
CREATE UNIQUE INDEX user_skill_id_uindex ON user_skill (id);