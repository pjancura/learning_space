--
-- VIEWS LAB
--
-- #1
CREATE VIEW open_invoices AS
SELECT vendor_name, invoice_number, invoice_total, invoice_total - payment_total - credit_total AS balance_due
FROM vendors v
JOIN invoices i USING (vendor_id)
WHERE invoice_total - payment_total - credit_total > 0;

-- #2
SELECT * 
FROM open_invoices
WHERE balance_due >= 1000;

-- #3
CREATE VIEW vendor_addresses 
AS
SELECT vendor_id, vendor_address1, vendor_address2, vendor_city, vendor_state, vendor_zip_code
FROM vendors;

SELECT * FROM vendor_addresses;

-- #4
UPDATE vendor_addresses
SET vendor_address2 = "Ste 260", vendor_address1 = "1990 Westwood Blvd"
WHERE vendor_id = 4;


-- 
-- SUMMARY LAB
-- 
-- #1
SELECT vendor_id, SUM(invoice_total) AS invTotal
FROM invoices
GROUP BY vendor_id
ORDER BY invTotal DESC;

-- #2
SELECT vendor_name, SUM(payment_total) AS payTotal
FROM invoices
JOIN vendors USING (vendor_id)
GROUP BY vendor_name
ORDER BY payTotal DESC;

-- #3
SELECT vendor_name, COUNT(invoice_number) AS invoice_count, SUM(invoice_total) AS invTotal
FROM invoices
JOIN vendors USING (vendor_id)
GROUP BY vendor_name
ORDER BY invoice_count DESC;

-- #4
SELECT account_description, COUNT(*) AS accCount, SUM(line_item_amount) AS itemTotal
FROM general_ledger_accounts
JOIN invoice_line_items ili USING (account_number)
GROUP BY account_
 	HAVING accCount > 1
ORDER BY itemTotal DESC;

-- #5
SELECT account_description, COUNT(ili.account_number) AS accCount, SUM(line_item_amount) AS itemTotal
FROM general_ledger_accounts
JOIN invoice_line_items ili USING (account_number)
JOIN invoices i USING (invoice_id)
WHERE i.invoice_date BETWEEN "2014-04-01" AND "2014-06-30"
GROUP BY account_description
 	HAVING accCount > 1
ORDER BY itemTotal DESC;


-- #6
SELECT account_description, COUNT(ili.account_number) AS accCount, SUM(ili.line_item_amount) AS accSum
FROM general_ledger_accounts
JOIN invoice_line_items ili USING (account_number)
GROUP BY account_description WITH ROLLUP
ORDER BY accSum ;

-- #7
SELECT vendor_name, COUNT(DISTINCT ili.account_number) AS accCount
FROM vendors
JOIN invoices i USING (vendor_id)
JOIN invoice_line_items ili USING (invoice_id) 
GROUP BY vendor_name
 HAVING accCount > 1;
 
 -- #8
 SELECT ROUND(AVG(DATEDIFF(payment_date, invoice_date))) AS avg_days_to_pay
 FROM invoices; 

-- #9
SELECT MONTHNAME(invoice_date) AS inv_month, SUM(invoice_total) AS inv_total
FROM invoices
GROUP BY inv_month
ORDER BY inv_total DESC LIMIT 1;

-- #10
SELECT vendor_name, invoice_id, DATEDIFF(invoice_due_date, payment_date) AS late_pay_days
FROM invoices
JOIN vendors USING (vendor_id)
WHERE DATEDIFF(invoice_due_date, payment_date) > 0
ORDER BY DATEDIFF(invoice_due_date, payment_date);

-- #11
SELECT county, 2021_pcincome
FROM income_by_county
WHERE state = "Ohio" AND county <> "Ohio"
ORDER BY 2021_pcincome DESC LIMIT 1;

-- #12
SELECT state, COUNT(county) AS county_count
FROM income_by_county
WHERE county <> state
GROUP BY state
ORDER BY county_count;

SELECT * FROM income_by_county; 

-- #13
-- WHERE WE LEFT OFF AFTER CLASS
SELECT state, county, MAX(2021_pcincome) AS maxPCI
FROM income_by_county
WHERE county <> state AND state <> ""
GROUP BY state
ORDER BY state;

--  CORRECT!!!!!!!   this pulls the highest per capita income countyor 2021 in each state
SELECT DISTINCT state, 
FIRST_VALUE(county) OVER(PARTITION BY state ORDER BY 2021_pcincome DESC) AS county, 
MAX(2021_pcincome) OVER (PARTITION BY state) AS highest_PCI_2021
FROM income_by_county
WHERE county <> state AND state <> ""
ORDER BY state;

-- run with and w/out DISTINCT to demonstrate the difference
SELECT DISTINCT state
FROM income_by_county
WHERE county <> state AND state <> "" AND state = "Ohio";

-- this pull the correct county
SELECT FIRST_VALUE(county) OVER(PARTITION BY state ORDER BY 2021_pcincome DESC) AS county 
FROM income_by_county
WHERE county <> state AND state <> "" AND state = "Ohio";

-- this pulls the correct per capita number for 2021
SELECT MAX(2021_pcincome) OVER (PARTITION BY state) AS highest_PCI_2021
FROM income_by_county
WHERE county <> state AND state <> "" AND state = "Ohio";


