USE ap;

USE ap;
       
SELECT * FROM invoices;

-- RESET THE invoice_id IN THE invoices TABLE
ALTER TABLE invoices AUTO_INCREMENT = 115;

-- LAB 3.  !!!!!!!!!!!!!!!!!!
-- #1
INSERT INTO invoices
VALUES (NULL , 32, "AX-014-027", "2014-08-01", 434.58, 0.00, 0.00, 2, "2014-08-31", NULL);

-- SHOW RESULT #1
SELECT * FROM invoices;

-- #2
INSERT INTO invoice_line_items
VALUES ((SELECT invoice_id FROM invoices ORDER BY invoice_id DESC LIMIT 1), 1, 160, 180.23, "Hard Drive"),
((SELECT invoice_id FROM invoices ORDER BY invoice_id DESC LIMIT 1), 2, 527, 254.35, "Exchange Server Update");

-- SHOW RESULT #2
SELECT * FROM invoice_line_items;

-- #3
UPDATE invoices
SET credit_total = (invoice_total * 0.1), payment_total = (invoice_total - credit_total), payment_date = NOW()
WHERE invoice_id = 115;

-- SHOW RESULT #3
SELECT * FROM invoices;

-- #4 
UPDATE vendors
SET default_account_number = 403
WHERE vendor_id = 44;

-- SHOW RESULT #4
SELECT * FROM vendors WHERE vendor_id = 44;

-- #5
DELETE FROM invoice_line_items
WHERE invoice_id = (SELECT invoice_id FROM invoices ORDER BY invoice_id DESC LIMIT 1);

DELETE FROM invoices
ORDER BY invoice_id DESC LIMIT 1;

-- SHOW RESULT #5
SELECT * FROM invoice_line_items;
SELECT * FROM invoices;





            