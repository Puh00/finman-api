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

CREATE TABLE UserCustomers (
    email VARCHAR(128),
    customer JSONB,
    PRIMARY KEY (email, customer),
    FOREIGN KEY (email) REFERENCES Accounts(email)
);


CREATE TABLE Invoices
(
    source       VARCHAR(128),
    serial_no    UUID DEFAULT uuid_generate_v4(),
    VAT          INTEGER      NOT NULL DEFAULT 25,
    OCR          VARCHAR(16)  NOT NULL,
    invoice_date DATE         NOT NULL,
    expiry_date  DATE         NOT NULL,
    bankgiro     VARCHAR(16),
    seller       VARCHAR(128) REFERENCES Organizations (email),
    customer     JSONB NOT NULL,
    items JSONB,
    is_paid      BOOLEAN DEFAULT FALSE,
    UNIQUE (serial_no, seller),
    PRIMARY KEY (serial_no, seller),
    FOREIGN KEY (source, customer) REFERENCES UserCustomers(email, customer)
);

CREATE TABLE Items
(
    owner VARCHAR(128) REFERENCES Accounts (email),
    name  VARCHAR(128) NOT NULL,
    price INTEGER      NOT NULL,
    PRIMARY KEY (owner, name)
);

CREATE VIEW InvoiceItemsHelper AS (
    SELECT serial_no, jsonb_array_elements(invoice_items) AS invoiceitems
    FROM Invoices
);
