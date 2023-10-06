
-- TELLS ME THE THE KEY SIGNATURES USED AND HOW MANY TIMES
SELECT key_sig_name, key_sig_id, COUNT(key_sig_id)
FROM pieces
JOIN keySignatures ON pieces.key_sig_id = keySignatures.ks_id
GROUP BY key_sig_id;

-- TELLS ME THE TIME SIGNATURES USED AND HOW MANY TIMES
SELECT time_signature, COUNT(time_sig_id)
FROM pieces p
JOIN timeSignatures ts ON ts.ts_id = p.time_sig_id
GROUP BY time_sig_id;


-- THIS LISTS THE PIECE NAME AND THE ASSOCIATED ALBUM NAME FOR ALL
-- OF THE PERFORMANCES IN THE DATABASE
SELECT piece_name, album_name
FROM pieces p
JOIN performances per USING (piece_id)
JOIN recordings r ON r.r_id = per.recording_id
ORDER BY piece_name;

-- THIS COUNTS THE TOTAL PERFORAMNCES OF A PIECE GIVEN THE RECORDING DATA
SELECT piece_name, COUNT(piece_id) AS total_performances 
FROM performances
JOIN pieces p USING (piece_id)
GROUP BY piece_name
ORDER BY total_performances DESC;

-- DISPLAYS THE PIECES THAT HAVE A KEYSIG = E MINOR AND TIMESIG = 3/4
SELECT p.piece_name, p.opus_id, p.sequence_num, ks.key_sig_name, ts.time_signature
FROM pieces p
JOIN keySignatures ks ON p.key_sig_id = ks.ks_id
JOIN timeSignatures ts ON p.time_sig_id = ts.ts_id
WHERE p.key_sig_id = 34 AND p.time_sig_id = 12
ORDER BY p.piece_name; 
 