-- *********
-- ********* VALUES FOR timeSignatures
-- *********  

-- VALUES FOR beats
INSERT INTO beats VALUES
(1),(2),(3),(4),(5),(6),(7),(8),(9);

-- VALUES FOR noteValues
INSERT INTO noteValues VALUES
(2),(4),(8),(16);

-- CREATE PERMUTATIONS
INSERT INTO timeSignatures(time_signature)
SELECT CONCAT(beats.beat_count, " / ", noteValues.note_value)
FROM beats
CROSS JOIN noteValues
ORDER BY noteValues.note_value, beats.beat_count;

-- *********
-- ********* VALUES FOR keySignatures
-- *********
-- THESE WERE USED TO POPULATE THE keys AND tonalities TABLES
INSERT INTO musicKeys VALUES
("Ab"),("A"),("A#"),
("Bb"),("B"),("B#"),
("Cb"),("C"),("C#"),
("Db"),("D"),("D#"),
("Eb"),("E"),("E#"),
("Fb"),("F"),("F#"),
("Gb"),("G"),("G#");

INSERT INTO tonalities VALUES
("major"),("minor");

-- THIS CREATED ALL THE PERMUTATIONS OF THE KEYS FOR ME
INSERT INTO keySignatures(key_sig_name)
SELECT CONCAT(musicKeys.music_key, " ", tonalities.tonality) 
FROM musicKeys
CROSS JOIN tonalities
ORDER BY tonalities.tonality, musicKeys.music_key;


-- *********
-- ********* THE BELOW STATEMENTS WERE USED TO MODIFY THE DATA
-- ********* OF THE pieces TABLE.  THE NAMES HAD ? INSTEAD OF ' UPON IMPORT
-- *********
START TRANSACTION;
 
 UPDATE pieces
 SET piece_name = REPLACE (piece_name, "?", "'")
 WHERE piece_id IN (4, 31, 49, 54, 55);
 
 SELECT *
FROM pieces
WHERE piece_name LIKE ("%?%");

SELECT *
FROM pieces
WHERE piece_name LIKE ("%'%");

COMMIT;
