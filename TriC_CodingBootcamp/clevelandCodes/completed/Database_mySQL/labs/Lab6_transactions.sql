-- DEMONSTRATING TRANSACTIONS, COMMITS, SAVEPOINTS, ROLLBACKS


USE AP;
START TRANSACTION;
SAVEPOINT before_invoice;
INSERT INTO invoices
     VALUES (NULL, 34, 'ZXA-080', '2015-01-18', 14092.59, 0, 0, 3, '2015-04-18', NULL);

SAVEPOINT before_line_item1;
INSERT INTO invoice_line_items
     VALUES (116, 1, 160, 4447.23, 'HW upgrade');
SAVEPOINT before_line_item2;
INSERT INTO invoice_line_items
     VALUES (116, 2, 167, 9645.36,'OS upgrade');
SELECT * FROM invoices WHERE invoice_id = 116;
SELECT * FROM invoice_line_items where invoice_id = 116;
ROLLBACK TO SAVEPOINT before_line_item2;
SELECT * FROM invoice_line_items where invoice_id = 116;
ROLLBACK TO SAVEPOINT before_line_item1;
SELECT * FROM invoice_line_items where invoice_id = 116;
ROLLBACK TO SAVEPOINT before_invoice;

COMMIT;

SELECT * FROM invoices where invoice_id = 116;

ALTER TABLE invoices AUTO_INCREMENT = 116;

SELECT * FROM invoices;

CREATE TABLE customers (a INT PRIMARY KEY AUTO_INCREMENT, b VARCHAR(50)); 
ALTER TABLE customers ENGINE = InnoDB ;
 START TRANSACTION;
 INSERT INTO customers VALUES (10, 'Heikki');
COMMIT;
START TRANSACTION;
INSERT INTO customers VALUES (15, 'John');
INSERT INTO customers VALUES (20, 'Paul');
DELETE FROM customers WHERE a = '10';
-- Now we undo those last 2 inserts and the delete.
ROLLBACK;
SELECT * FROM customers;
