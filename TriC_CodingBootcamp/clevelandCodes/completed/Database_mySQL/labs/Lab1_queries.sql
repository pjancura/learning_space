SELECT vendor_name, vendor_contact_last_name, vendor_contact_first_name
FROM vendors
ORDER BY vendor_contact_last_name, vendor_contact_first_name DESC;

SELECT invoice_number, invoice_due_date, invoice_total AS invoice_total_original, invoice_total* 0.1 AS "10%", ((invoice_total * 0.1) + invoice_total) AS invoice_total_110
FROM invoices
WHERE invoice_total >= 500 AND invoice_total <= 1000
ORDER BY invoice_due_date DESC;

SELECT invoice_number, invoice_total, (payment_total + credit_total) AS payment_credit_total, (invoice_total - payment_total - credit_total) AS balance_due
FROM invoices
WHERE (invoice_total - payment_total - credit_total) > 50
ORDER BY balance_due DESC;

SELECT invoice_number, invoice_date, (invoice_total - payment_total - credit_total) AS balance_due, payment_date
FROM invoices
WHERE payment_date IS NULL;

SELECT 50000 AS starting_principal, ROUND(50000 * 0.065) AS interest,  ROUND(500000 * 1.065, 2) AS principal_plus_interest;
 
