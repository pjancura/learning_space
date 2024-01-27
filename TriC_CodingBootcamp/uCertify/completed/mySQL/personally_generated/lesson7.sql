USE proaudio;

CREATE TABLE distributors 
(d_num INT NOT NULL,
d_name VARCHAR(50) NOT NULL,
d_street VARCHAR(25) NOT NULL,
d_city VARCHAR(25) NOT NULL,
d_state VARCHAR(2) NOT NULL,
d_zip VARCHAR(10) NOT NULL,
d_phone VARCHAR(15) NOT NULL,
d_contact VARCHAR(50) NOT NULL,
d_contact_extension VARCHAR(10) NOT NULL,
PRIMARY KEY (d_num));

CREATE TABLE customers(
c_num INT NOT NULL,
c_first_name VARCHAR(25) NOT NULL,
c_last_name VARCHAR(25) NOT NULL,
c_street VARCHAR(30) NOT NULL,
c_city VARCHAR(25) NOT NULL,
c_state VARCHAR(2) NOT NULL,
c_zip VARCHAR(10) NOT NULL,
c_phone VARCHAR(15),
c_cc_num VARCHAR(20),
c_exp_date VARCHAR(5),
PRIMARY KEY (c_num));

CREATE TABLE Orders
(o_num INTEGER NOT NULL PRIMARY KEY,
 c_num INTEGER NOT NULL,
 s_num INTEGER NOT NULL,
 o_date DATE NOT NULL,
 o_filled VARCHAR (5) DEFAULT 'false' CHECK (VALUE='true' OR VALUE='false'),
 CONSTRAINT fk_cnum FOREIGN KEY (c_num) REFERENCES Customers (c_num)
  ON UPDATE CASCADE
  ON DELETE CASCADE);

CREATE TABLE Items
(i_num INTEGER NOT NULL PRIMARY KEY,
 i_title VARCHAR (50) NOT NULL,
 d_num INTEGER NOT NULL,
 i_price DECIMAL(6,2) NOT NULL,
 i_release_date DATE NOT NULL,
 i_genre VARCHAR (15) NOT NULL CHECK
 (i_genre IN ('Jazz', 'Blues', 'Country', 'Rock', 'Alternative', 'Rap', 'Classical', 'Other')),
 CONSTRAINT fk_dnum FOREIGN KEY (d_num) REFERENCES Distributors (d_num)
  ON UPDATE CASCADE
  ON DELETE CASCADE);

CREATE TABLE Order_Lines
(o_num INTEGER NOT NULL,
 i_num INTEGER NOT NULL,
 ol_quantity INTEGER NOT NULL,
 o_price DECIMAL (8,2) NOT NULL,
 o_cost DECIMAL (8,2) NOT NULL,
 shipped VARCHAR (5) DEFAULT 'false' CHECK(VALUE='true' OR VALUE='false'),
 CONSTRAINT pk_Order_Lines PRIMARY KEY (o_num, i_num),
 CONSTRAINT fk_ol_onum FOREIGN KEY (o_num) REFERENCES Orders (o_num)
  ON UPDATE CASCADE
  ON DELETE CASCADE,
 CONSTRAINT fk_ol_inum FOREIGN KEY (i_num) REFERENCES Items (i_num)
  ON UPDATE CASCADE
  ON DELETE CASCADE);

CREATE TABLE Musicians
(a_num INTEGER NOT NULL PRIMARY KEY,
 a_name VARCHAR (50) NOT NULL);

CREATE TABLE Performance
(a_num INTEGER NOT NULL,
 i_num INTEGER NOT NULL,
 p_instrument VARCHAR (50) NOT NULL,
 CONSTRAINT pk_Performance PRIMARY KEY (a_num, i_num),
 CONSTRAINT fk_anum FOREIGN KEY (a_num) REFERENCES Musicians(a_num)
  ON UPDATE CASCADE
  ON DELETE CASCADE,
 CONSTRAINT fk_inum FOREIGN KEY (i_num) REFERENCES Items (i_num)
  ON UPDATE CASCADE
  ON DELETE CASCADE);

CREATE TABLE Producers
(p_num INTEGER NOT NULL PRIMARY KEY,
 p_name VARCHAR (50));

CREATE TABLE Production
(p_num INTEGER NOT NULL,
 i_num INTEGER NOT NULL,
 p_studio VARCHAR (50) NOT NULL,
 CONSTRAINT pk_Production PRIMARY KEY (p_num, i_num),
 CONSTRAINT fk_pname FOREIGN KEY (p_num) REFERENCES Producers (p_num)
  ON UPDATE CASCADE
  ON DELETE CASCADE,
 CONSTRAINT fk_p_inum FOREIGN KEY (i_num) REFERENCES Items (i_num)
  ON UPDATE CASCADE
  ON DELETE CASCADE);