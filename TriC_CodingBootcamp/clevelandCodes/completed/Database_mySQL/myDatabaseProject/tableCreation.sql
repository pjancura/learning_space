CREATE DATABASE griegLyricPieces;

USE griegLyricPieces;

CREATE TABLE opusInfo (
id_num INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
op_num INT NOT NULL,
year_complete INT NOT NULL,
dedication VARCHAR(256),
total_pieces INT NOT NULL);



CREATE TABLE recordings (
r_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
album_name VARCHAR(256) NOT NULL,
artist_name VARCHAR(256));

CREATE TABLE pieces (
piece_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
piece_name VARCHAR(256) NOT NULL,
opus_id INT NOT NULL,
sequence_num INT NOT NULL,
tempo VARCHAR(256) NOT NULL,
key_sig_id INT NOT NULL,
time_sig_id INT NOT NULL,
challenge_rating VARCHAR(256),
FOREIGN KEY (opus_id) REFERENCES opusInfo(id_num),
FOREIGN KEY (key_sig_id) REFERENCES keySignatures(ks_id),
FOREIGN KEY (time_sig_id) REFERENCES timeSignatures(ts_id));

CREATE TABLE performances (
performance_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
piece_id INT NOT NULL,
recording_id INT NOT NULL,
FOREIGN KEY (piece_id) REFERENCES pieces(piece_id),
FOREIGN KEY (recording_id) REFERENCES recordings(r_id));

-- THE BELOW TABLES WILL BE USED TO CREATE THE PERMUTATIONS OF THE keySignatures TABLE
CREATE TABLE musicKeys (
music_key VARCHAR(10) NOT NULL PRIMARY KEY);

CREATE TABLE tonalities(
tonality VARCHAR(256) NOT NULL PRIMARY KEY);

-- I HAD TO CHANGE THE ORIGINAL TABLE
ALTER TABLE keySignatures
DROP COLUMN letter,
DROP COLUMN tonality;

-- THIS ADDED THE COLUMN FOR THE PERMUTATIONS OF THE KEYS
ALTER TABLE keySignatures
ADD COLUMN key_sig_name VARCHAR(256);

-- TABLES TO CREATE THE PERMUTATIONS
CREATE TABLE beats (
beat_count INT NOT NULL PRIMARY KEY);

CREATE TABLE noteValues(
note_value INT NOT NULL PRIMARY KEY);

-- CHANGE FOR ORIGINAL TABLE
	-- DROP
ALTER TABLE timeSignatures
DROP COLUMN beats,
DROP COLUMN note_value;
	-- ADD
ALTER TABLE timeSignatures
ADD COLUMN time_signature VARCHAR(256) NOT NULL;

-- CREATE PERMUTATIONS
INSERT INTO timeSignatures(time_signature)
SELECT CONCAT(beats.beat_count, " / ", noteValues.note_value)
FROM beats
CROSS JOIN noteValues
ORDER BY noteValues.note_value, beats.beat_count;


-- THESE WERE NEEDED TO ALTER THE TABLES AFTER THE INITIAL CREATION

ALTER TABLE recordings
ADD COLUMN year_released INT;

DESCRIBE recordings;

ALTER TABLE recordings
ADD COLUMN publisher VARCHAR(256);

ALTER TABLE recordings
MODIFY `publisher` varchar(256) DEFAULT NULL AFTER r_id;

ALTER TABLE recordings
RENAME COLUMN artist_name TO artist_first_name;

ALTER TABLE recordings
ADD COLUMN artist_last_name VARCHAR(256) NOT NULL AFTER artist_first_name;

DESCRIBE performances;

ALTER TABLE recordings
ADD COLUMN instrumentation VARCHAR(256) NOT NULL,
ADD COLUMN group_name VARCHAR(256) AFTER artist_last_name;



