DROP SCHEMA public CASCADE;
CREATE SCHEMA public;

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE Accounts
(
    name        VARCHAR(128) NOT NULL,
    email       VARCHAR(128) PRIMARY KEY  NOT NULL,
    telephone   VARCHAR(16)  NOT NULL,
    password    TEXT         NOT NULL,
    CHECK       (email LIKE '%@%.%')
);

CREATE TABLE Customers
(
    id    SERIAL PRIMARY KEY,
    info  JSONB,
    email VARCHAR(128)
);

CREATE TABLE Organizations
(
    name      TEXT NOT NULL,
    address   VARCHAR(128) NOT NULL,
    zip_code  VARCHAR(16)  NOT NULL,
    city      VARCHAR(128) NOT NULL,
    country   VARCHAR(128) NOT NULL,
    telephone VARCHAR(16)  NOT NULL,
    email     VARCHAR(128) PRIMARY KEY,
    org_no VARCHAR(16)  NOT NULL UNIQUE
);

CREATE TABLE Members
(
    account      VARCHAR(128) REFERENCES Accounts (email),
    organization VARCHAR(128) REFERENCES Organizations (email),
    PRIMARY KEY (account, organization)
);

CREATE TABLE Invoices
(
    source       VARCHAR(128) REFERENCES Accounts(email),
    serial_no    UUID DEFAULT uuid_generate_v4(),
    VAT          INTEGER      NOT NULL DEFAULT 25,
    OCR          VARCHAR(16)  NOT NULL,
    invoice_date DATE         NOT NULL,
    expiry_date  DATE         NOT NULL,
    bankgiro     VARCHAR(16),
    seller       VARCHAR(128) REFERENCES Organizations (email),
    buyer        SERIAL REFERENCES Customers (id),
    is_paid      BOOLEAN DEFAULT FALSE,
    UNIQUE (serial_no, seller),
    PRIMARY KEY (serial_no, seller)
);

CREATE TABLE Items
(
    owner VARCHAR(128) REFERENCES Accounts (email),
    name  VARCHAR(128) NOT NULL,
    price INTEGER      NOT NULL,
    PRIMARY KEY (owner, name)
);

CREATE TABLE InvoiceItems
(
    invoice UUID,
    seller  VARCHAR(128),
    name    VARCHAR(128),
    owner   VARCHAR(128),
    amount  INTEGER NOT NULL CHECK (amount >= 0),
    PRIMARY KEY (invoice, seller, owner, name),
    FOREIGN KEY (invoice, seller) REFERENCES Invoices (serial_no, seller)
);

CREATE VIEW InvoiceWithMail AS (
    SELECT 
        source,
        serial_no,
        VAT,
        OCR,
        invoice_date,
        expiry_date,
        bankgiro,
        seller,
        buyer,
        email as buyer_email,
        is_paid
    FROM
        Invoices LEFT OUTER JOIN Customers ON buyer=id
);
