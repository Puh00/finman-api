DROP SCHEMA public CASCADE;
CREATE SCHEMA public;

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE Accounts
(
    id        INTEGER PRIMARY KEY,
    name      VARCHAR(128) NOT NULL,
    email     VARCHAR(128) NOT NULL,
    telephone VARCHAR(16)  NOT NULL,
    password  TEXT         NOT NULL,
    CHECK (email LIKE '%@%.%')
);

CREATE TABLE Customers
(
    id        INTEGER PRIMARY KEY,
    address   VARCHAR(128) NOT NULL,
    zip_code  VARCHAR(16)  NOT NULL,
    city      VARCHAR(128) NOT NULL,
    country   VARCHAR(128) NOT NULL,
    telephone VARCHAR(16)  NOT NULL,
    email     VARCHAR(128) NOT NULL,
    CHECK (email LIKE '%@%.%')
);

CREATE TABLE Organizations
(
    id     INTEGER PRIMARY KEY REFERENCES Customers (id),
    name   VARCHAR(128) NOT NULL,
    org_no VARCHAR(16)  NOT NULL UNIQUE
);

CREATE TABLE Members
(
    account      INTEGER REFERENCES Accounts (id),
    organization INTEGER REFERENCES Organizations (id),
    PRIMARY KEY (account, organization)
);

CREATE TABLE Persons
(
    id                 INTEGER PRIMARY KEY REFERENCES Customers (id),
    name               VARCHAR(128) NOT NULL,
    social_security_no VARCHAR(16)  NOT NULL UNIQUE
);

CREATE TABLE Invoices
(
    serial_no    UUID DEFAULT uuid_generate_v4(),
    VAT          INTEGER     NOT NULL DEFAULT 25,
    OCR          VARCHAR(16) NOT NULL,
    invoice_date DATE        NOT NULL,
    expiry_date  DATE        NOT NULL,
    bankgiro     VARCHAR(16),
    seller       INTEGER     REFERENCES Organizations (id),
    buyer        INTEGER     NOT NULL REFERENCES Customers (id),
    UNIQUE (serial_no, seller),
    PRIMARY KEY (serial_no, seller)
);

CREATE TABLE Items
(
    owner INTEGER REFERENCES Accounts (id),
    name  VARCHAR(128) NOT NULL,
    price INTEGER      NOT NULL,
    PRIMARY KEY (owner, name)
);

CREATE TABLE InvoiceItems
(
    invoice UUID,
    seller  INTEGER,
    name    VARCHAR(128),
    owner   INTEGER,
    amount  INTEGER NOT NULL CHECK (amount >= 0),
    PRIMARY KEY (invoice, seller, owner, name),
    FOREIGN KEY (invoice, seller) REFERENCES Invoices (serial_no, seller)
);
