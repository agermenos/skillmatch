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
CREATE TABLE "user"
(
    id INTEGER PRIMARY KEY NOT NULL,
    name VARCHAR NOT NULL,
    last_name VARCHAR,
    address_id INTEGER NOT NULL,
    image_id INTEGER
);
CREATE UNIQUE INDEX address_id_uindex ON address (id);
CREATE UNIQUE INDEX catalog_id_uindex ON catalog (id);