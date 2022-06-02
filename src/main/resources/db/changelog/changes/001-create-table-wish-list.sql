--liquibase formatted sql

--changeset reinis:1

CREATE TABLE IF NOT EXISTS wish
(
    uuid UUID NOT NULL,
    item VARCHAR(255),
    CONSTRAINT pk_wish PRIMARY KEY (uuid)
);