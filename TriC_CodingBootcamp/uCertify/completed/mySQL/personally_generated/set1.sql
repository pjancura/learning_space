USE class_demo;
CREATE TABLE parents(
p_id INT,
p_one VARCHAR(20),
p_two VARCHAR(20));

ALTER TABLE parents
DROP COLUMN p_two;

ALTER TABLE parents
RENAME COLUMN p_one TO p_name;

INSERT INTO parents (p_id,p_name)
VALUES (100, "John Doe"),
(101, "Jane Doe"),
(102, "Freda Fish"),
(103, "Bill Bass");

SELECT * FROM parents;

ALTER TABLE parents
ADD PRIMARY KEY (p_id);

SELECT * FROM parents;

CREATE TABLE kids(
k_parent_id INT,
k_name VARCHAR(25),
k_dob DATE);

INSERT INTO kids(k_parent_id, k_name, k_dob)
VALUES (100, "Betty", "1988-02-02"),
(100, "Frank", "1990-04-03"),
(101, "Betty", "1988-02-02"),
(101, "Frank", "1990-04-03"),
(102, "Henry", "1979-04-04"),
(102, "Jane", "1984-08-02"),
(102, "Jill", "1988-07-09"),
(102, "Bill", "1990-10-03"),
(103, "Hank", "1989-05-04"),
(103, "April", "1994-09-09"),
(103, "Ellen", "1998-07-10");

SELECT * FROM kids;

SELECT p_name, k_name
FROM parents p
JOIN kids k ON p.p_id = k.k_parent_id
ORDER BY p_name; 