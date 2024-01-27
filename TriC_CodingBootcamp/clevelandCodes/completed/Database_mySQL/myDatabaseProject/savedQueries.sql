-- SHOWS ALL PIECES FROM OPUS 4 OF THE LYRIC PIECES
SELECT p.piece_name, p.opus_id, p.sequence_num, p.tempo, ks.key_sig_name AS key_sig, ts.time_signature AS time_sig, p.challenge_rating
FROM pieces p
JOIN keySignatures ks ON ks.ks_id = p.key_sig_id
JOIN timeSignatures ts ON ts.ts_id = p.time_sig_id
WHERE p.opus_id = 4;

-- TELLS ME THE THE KEY SIGNATURES USED AND HOW MANY TIMES THEY ARE USED
SELECT key_sig_name, key_sig_id, COUNT(key_sig_id) AS total_times_used
FROM pieces
JOIN keySignatures ON pieces.key_sig_id = keySignatures.ks_id
GROUP BY key_sig_id
ORDER BY total_times_used DESC;

-- TELLS ME THE TIME SIGNATURES USED AND HOW MANY TIMES THEY ARE USED
SELECT time_signature, COUNT(time_sig_id) AS total_times_used
FROM pieces p
JOIN timeSignatures ts ON ts.ts_id = p.time_sig_id
GROUP BY time_sig_id
ORDER BY total_times_used DESC;


-- THIS LISTS THE PIECE NAME AND THE ASSOCIATED ALBUM NAME FOR ALL
-- OF THE PERFORMANCES IN THE DATABASE
SELECT p.piece_id, r.album_name, p.piece_name
FROM pieces p
JOIN performances per USING (piece_id)
JOIN recordings r ON r.r_id = per.recording_id
ORDER BY r.album_name;

-- THIS COUNTS THE TOTAL PERFORMANCES OF A PIECE GIVEN THE RECORDING DATA
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