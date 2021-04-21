INSERT INTO Accounts VALUES (1, 'Alex', 'appa@gmail.se', '0760473396', 'secretpsw');
INSERT INTO Accounts VALUES (2, 'Bert', 'berti@hotmail.se', '07304650032', 'anotherpsw');
INSERT INTO Accounts VALUES (3, 'Carl', 'calle@yahoo.dk', '0310450027', 'pizza');

INSERT INTO Customers VALUES (1, 'England Road P 201', '4422', 'London', 'LITTLE AMERICA', '7025263243', 'brexit@london.uk');
INSERT INTO Customers VALUES (2, 'Hell District 678', '666666', 'Heaven', 'Hell', '7012356671', 'guh@hell.se');
INSERT INTO Customers VALUES (3, 'Kvarnbygatan 5', '421 44', 'Gothenburg', 'Sweden', '7025263243', 'finman@block.chain');
INSERT INTO Customers VALUES (4, 'Nybogatan 25', '83335', 'Östersund', 'Sweden', '702536751', 'jamtlandarena@gmail.com');

INSERT INTO Persons VALUES (1, 'Elizabeth Elizabethson', 'AA-553423-B');
INSERT INTO Persons VALUES (2, 'Dante', '201902306666');

INSERT INTO Organizations VALUES (3, 'Finman', '556036-0793');
INSERT INTO Organizations VALUES (4, 'Jämtland Arena', '44444-2643');

INSERT INTO Members VALUES (1, 3);
INSERT INTO Members VALUES (2, 3);
INSERT INTO Members VALUES (2, 4);
INSERT INTO Members VALUES (3, 4);

INSERT INTO Invoices(serial_no, OCR, invoice_date, expiry_date, bankgiro, seller, buyer) VALUES ('9dd576c5-d7ee-4e00-a653-b5c4727e5275', '426523791', '1980-01-01', '2005-01-01', '01234567', 3, 1);
INSERT INTO Invoices(serial_no, OCR, invoice_date, expiry_date, bankgiro, seller, buyer) VALUES ('74645d1c-9d33-417f-bce7-ba3bc7079776', '432133392', '1988-03-23', '1995-04-01', '01234567', 3, 2);
INSERT INTO Invoices(serial_no, OCR, invoice_date, expiry_date, bankgiro, seller, buyer) VALUES ('8ada6be8-a81c-4275-9bec-514ba37c1d7d', '893247921', '1999-08-29', '1999-09-13', '01234567', 4, 3);

INSERT INTO Items VALUES  (1, 1, 'Booba Tea', 25, 'St');
INSERT INTO Items VALUES  (2, 1, 'Hot dog', 45, 'St');
INSERT INTO Items VALUES  (1, 2, 'Bacon strips', 35, 'Pk');
INSERT INTO Items VALUES  (2, 2, 'Mayonnaise', 54, 'Flaska');
INSERT INTO Items VALUES  (3, 2, 'Premium Handcrafted Special Omega Deluxe Edition Lard', 169, 'Burk');

INSERT INTO InvoiceItems VALUES ('9dd576c5-d7ee-4e00-a653-b5c4727e5275', 1, 1, 2);
INSERT INTO InvoiceItems VALUES ('74645d1c-9d33-417f-bce7-ba3bc7079776', 2, 1, 4);
INSERT INTO InvoiceItems VALUES ('8ada6be8-a81c-4275-9bec-514ba37c1d7d', 1, 1, 50);
INSERT INTO InvoiceItems VALUES ('8ada6be8-a81c-4275-9bec-514ba37c1d7d', 3, 2, 2);
INSERT INTO InvoiceItems VALUES ('74645d1c-9d33-417f-bce7-ba3bc7079776', 2, 2, 2);
