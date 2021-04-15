DROP SCHEMA public CASCADE;
CREATE SCHEMA public;

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
    serial_no    INTEGER PRIMARY KEY,
    invoice_no   VARCHAR(16) NOT NULL,
    VAT          INTEGER     NOT NULL,
    OCR          VARCHAR(16) NOT NULL,
    invoice_date DATE        NOT NULL,
    expiry_date  DATE        NOT NULL,
    bankgiro     VARCHAR(16),
    reg_no       VARCHAR(16),
    seller       INTEGER     NOT NULL REFERENCES Organizations (id),
    buyer        INTEGER     NOT NULL REFERENCES Customers (id)
);

CREATE TABLE Items
(
    id    INTEGER,
    owner INTEGER REFERENCES Accounts (id),
    name  VARCHAR(128) NOT NULL,
    price INTEGER      NOT NULL,
    unit  VARCHAR(16)  NOT NULL,
    PRIMARY KEY (id, owner)
);


CREATE TABLE InvoiceItems
(
    invoice    INTEGER REFERENCES Invoices (serial_no),
    item_id    INTEGER,
    item_owner INTEGER,
    amount     INTEGER NOT NULL CHECK (amount >= 0),
    PRIMARY KEY (invoice, item_id, item_owner),
    FOREIGN KEY (item_id, item_owner) REFERENCES Items (id, owner)
);
