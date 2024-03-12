USE ap;
SHOW TABLES;
SELECT vendor_name, invoice_number, terms_description
-- FROM tells me where all of the data is located 
FROM invoices 
-- you can add a variable like    "i" for invoices. it must be used in the rest of the script
-- aternate way to write line 4.  =. FROM invoices i. (i now stands for invoices)
-- JOIN tells me where parts of the data are located
JOIN vendors ON invoices.vendor_id = vendors.vendor_id
JOIN terms ON invoices.terms_id = terms.terms_id
ORDER BY vendor_name;

SELECT * FROM terms;

-- another way to write the above JOIN
SELECT vendor_name, invoice_number, terms_description
FROM invoices i
JOIN vendors v USING (vendor_id)
JOIN terms t USING (terms_id)
ORDER BY terms_id,  vendor_name;

-- lab 2 
-- #1
SELECT vendor_name, invoice_number, invoice_date, (invoice_total - payment_total - credit_total) AS balance_due
FROM vendors v
JOIN invoices i USING (vendor_id)
WHERE (invoice_total - payment_total - credit_total) > 0               
ORDER BY vendor_name; 

-- #2
SELECT vendor_name, default_account_number, account_description
FROM vendors v
JOIN general_ledger_accounts gla ON v.default_account_number = gla.account_number
ORDER BY vendor_name; 

-- #3
SELECT vendor_name, invoice_date, invoice_number, invoice_sequence AS li_sequence, line_item_amount AS li_amount
FROM vendors v
JOIN invoices i ON v.vendor_id = i.vendor_id
JOIN invoice_line_items li USING (invoice_id)
ORDER BY vendor_name, invoice_date, invoice_number, invoice_sequence;

-- #4
SELECT account_number, account_description, invoice_id
FROM general_ledger_accounts gla
LEFT JOIN invoice_line_items li USING (account_number)
WHERE li.invoice_id IS NULL
ORDER BY gla.account_number;

-- #5
SELECT vendor_name, "CA"  
FROM vendors
WHERE vendor_state = "CA"
UNION
SELECT vendor_name, "Outside of CA"
FROM vendors
WHERE vendor_state != "CA"
-- WHERE vendor_state <> "CA"     line 57 and 58 will result in the same table being generated 
ORDER BY vendor_name;
 
 

