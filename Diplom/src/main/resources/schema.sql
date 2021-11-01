DROP TABLE IF EXISTS setting;
CREATE TABLE setting(
    id BIGSERIAL,
    code varchar(255),
    description varchar(255),
    value varchar(255),
    CONSTRAINT setting_pk PRIMARY KEY (id));

CREATE INDEX setting_code ON setting(code);

DROP TABLE IF EXISTS entity;
CREATE TABLE entity(
    id BIGSERIAL,
    code varchar(255),
    description varchar(255),
    CONSTRAINT entity_pk PRIMARY KEY (id));

CREATE UNIQUE INDEX entity_code ON entity(code);

DROP TABLE IF EXISTS entity_attr;
CREATE TABLE entity_attr(
    id BIGSERIAL,
    code varchar(255),
    description varchar(255),
    type varchar(255),
    entity_id BIGINT,
    CONSTRAINT entity_attr_pk PRIMARY KEY (id));

CREATE UNIQUE INDEX entity_attr_entity_id ON entity_attr(entity_id, code);