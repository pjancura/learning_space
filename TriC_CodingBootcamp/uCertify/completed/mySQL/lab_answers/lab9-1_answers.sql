
-- #1
SELECT customers.c_id, c_phone_num, order_num, order_date, filled
FROM customers c
JOIN orders o ON c.c_id = o.c_id;

-- #2
SELECT customers.c_id, c_phone_num, order_num, order_date, filled
FROM customers c
LEFT JOIN orders o ON c.c_id = o.c_id;

-- #3


USE proaudio;


-- #1
SELECT c.c_num, CONCAT(c_first_name, " ", c_last_name) AS c_full_name, c_phone, o_num, o_date, o_filled
FROM customers c
JOIN orders o ON c.c_num = o.c_num
ORDER BY o.o_num;

-- #2
SELECT c.c_num, CONCAT(c_first_name, " ", c_last_name) AS c_full_name, c_phone, o_num, o_date, o_filled
FROM customers c
LEFT JOIN orders o ON c.c_num = o.c_num  
ORDER BY c.c_num;

-- #3
SELECT d_name, d_phone, i_title, i_price
FROM distributors
JOIN items USING (d_num)
ORDER BY d_name;

-- #4
SELECT a_name, p_name, i_title
FROM items i
JOIN performance p ON i.i_num = p.i_num
JOIN musicians m USING (a_num)
JOIN production ON i.i_num = production.i_num
JOIN producers USING (p_num)
ORDER BY i_title; 
  

SELECT * FROM items;


SELECT Customer.c_id, last_name, first_name, address, city, state, zip, Tour.tour_no FROM Customer, Tour WHERE  Customer.c_id = Tour.c_id;

SELECT Customer.c_id, last_name, first_name, address, city, state, zip, Tour.c_id, tour_no FROM Customer, Tour WHERE Customer.c_id = Tour.c_id;



 


