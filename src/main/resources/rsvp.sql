DROP DATABASE IF EXISTS rsvp;

CREATE DATABASE rsvp;

Use rsvp;

CREATE TABLE booking(
    email VARCHAR(128) NOT NULL,
    phone VARCHAR(128) NOT NULL,
    confirmDate VARCHAR(64) NOT NULL,
    comments TEXT
);

GRANT ALL PRIVILEGES ON rsvp.* TO 'fred'@'localhost';
FLUSH PRIVILEGES;
