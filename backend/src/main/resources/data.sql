INSERT INTO Accounts VALUES ('Alex', 'appa@gmail.se', '0760473396', 'secretpsw');
INSERT INTO Accounts VALUES ('Bert', 'berti@hotmail.se', '07304650032', 'anotherpsw');
INSERT INTO Accounts VALUES ('Carl', 'calle@yahoo.dk', '0310450027', 'pizza');

INSERT INTO Organizations VALUES ('Finman', 'Kvarnbygatan 5', '421 44', 'Gothenburg', 'Sweden', '7025263243', 'finman@block.chain', '556036-0793');

INSERT INTO Members VALUES ('appa@gmail.se', 'finman@block.chain');
INSERT INTO Members VALUES ('berti@hotmail.se', 'finman@block.chain');
INSERT INTO Members VALUES ('calle@yahoo.dk', 'finman@block.chain');

INSERT INTO UserCustomers VALUES ('appa@gmail.se', '{"name":"Elizabeth Elizabethson","address": "England Road P 201", "zipCode": "4422", "city":"London", "country":"LITTLE AMERICA", "telephone":"7025263243", "email": "brexit@london.uk"}');
INSERT INTO UserCustomers VALUES ('berti@hotmail.se', '{"name":"Alex","address":"Noob Road 69", "zipCode":"42069", "city":"Gamer Town", "country":"Sweden", "telephone":"0760473396", "email": "appa@gmail.se"}');
INSERT INTO UserCustomers VALUES ('appa@gmail.se', '{"name": "Dante", "address": "Hell District 678", "zipCode": "666666", "city": "Heaven", "country":"Hell", "telephone": "7012356671", "email": "berti@hotmail.se"}');

INSERT INTO Invoices(source, serial_no, OCR, invoice_date, expiry_date, bankgiro, seller, customer, invoice_items) VALUES ('appa@gmail.se', '9dd576c5-d7ee-4e00-a653-b5c4727e5275', '426523791', '1980-01-01', '2005-01-01', '57257167', 'finman@block.chain', '{"name":"Elizabeth Elizabethson","address": "England Road P 201", "zipCode": "4422", "city":"London", "country":"LITTLE AMERICA", "telephone":"7025263243", "email": "brexit@london.uk"}', '[{"name": "Boba Tea", "amount": "2", "price":"25"} , {"name": "Hot Dog", "amount": "4", "price":"45"}]');
INSERT INTO Invoices(source, serial_no, OCR, invoice_date, expiry_date, bankgiro, seller, customer, invoice_items) VALUES ('berti@hotmail.se', '74645d1c-9d33-417f-bce7-ba3bc7079776', '432133392', '1988-03-23', '1995-04-01', '05352567', 'finman@block.chain', '{"name":"Alex","address":"Noob Road 69", "zipCode":"42069", "city":"Gamer Town", "country": "Sweden", "telephone":"0760473396", "email": "appa@gmail.se"}', '[{"name":"Boba Tea", "amount":"50", "price":"25"}]');
INSERT INTO Invoices(source, serial_no, OCR, invoice_date, expiry_date, bankgiro, seller, customer, invoice_items) VALUES ('appa@gmail.se', '8ada6be8-a81c-4275-9bec-514ba37c1d7d', '893247921', '1999-08-29', '1999-09-13', '03333337', 'finman@block.chain', '{"name": "Dante", "address": "Hell District 678", "zipCode": "666666", "city": "Heaven", "country":"Hell", "telephone": "7012356671", "email": "berti@hotmail.se"}', '[{"name": "Premium Handcrafted Special Omega Deluxe Edition Lard", "amount": "2", "price":"169"}, {"name": "Mayonnaise", "amount": "2", "price":"54"}]');

INSERT INTO Items VALUES  ('appa@gmail.se', 'Boba Tea', 25);
INSERT INTO Items VALUES  ('appa@gmail.se', 'Hot dog', 45);
INSERT INTO Items VALUES  ('appa@gmail.se', 'Bacon strips', 35);
INSERT INTO Items VALUES  ('berti@hotmail.se', 'Mayonnaise', 54);
INSERT INTO Items VALUES  ('berti@hotmail.se', 'Premium Handcrafted Special Omega Deluxe Edition Lard', 169);

-- INSERT INTO InvoiceItems VALUES ('9dd576c5-d7ee-4e00-a653-b5c4727e5275', 'finman@block.chain', 'Boba Tea', 'appa@gmail.se', 2);
-- INSERT INTO InvoiceItems VALUES ('9dd576c5-d7ee-4e00-a653-b5c4727e5275', 'finman@block.chain', 'Hot dog', 'appa@gmail.se', 4);
-- INSERT INTO InvoiceItems VALUES ('74645d1c-9d33-417f-bce7-ba3bc7079776', 'finman@block.chain', 'Boba Tea', 'appa@gmail.se', 50);
-- INSERT INTO InvoiceItems VALUES ('8ada6be8-a81c-4275-9bec-514ba37c1d7d', 'finman@block.chain', 'Premium Handcrafted Special Omega Deluxe Edition Lard', 'berti@hotmail.se', 2);
-- INSERT INTO InvoiceItems VALUES ('8ada6be8-a81c-4275-9bec-514ba37c1d7d', 'finman@block.chain', 'Mayonnaise', 'berti@hotmail.se', 2);
