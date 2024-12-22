-- MySQL dump 10.13  Distrib 9.0.1, for macos14.7 (x86_64)
--
-- Host: localhost    Database: griegLyricPieces_2
-- ------------------------------------------------------
-- Server version	9.0.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `beats`
--

DROP TABLE IF EXISTS `beats`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `beats` (
  `beat_count` int NOT NULL,
  PRIMARY KEY (`beat_count`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `beats`
--

LOCK TABLES `beats` WRITE;
/*!40000 ALTER TABLE `beats` DISABLE KEYS */;
INSERT INTO `beats` VALUES (1),(2),(3),(4),(5),(6),(7),(8),(9);
/*!40000 ALTER TABLE `beats` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `keySignatures`
--

DROP TABLE IF EXISTS `keySignatures`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `keySignatures` (
  `ks_id` int NOT NULL AUTO_INCREMENT,
  `key_sig_name` varchar(256) NOT NULL,
  PRIMARY KEY (`ks_id`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `keySignatures`
--

LOCK TABLES `keySignatures` WRITE;
/*!40000 ALTER TABLE `keySignatures` DISABLE KEYS */;
INSERT INTO `keySignatures` VALUES (1,'A major'),(2,'A# major'),(3,'Ab major'),(4,'B major'),(5,'B# major'),(6,'Bb major'),(7,'C major'),(8,'C# major'),(9,'Cb major'),(10,'D major'),(11,'D# major'),(12,'Db major'),(13,'E major'),(14,'E# major'),(15,'Eb major'),(16,'F major'),(17,'F# major'),(18,'Fb major'),(19,'G major'),(20,'G# major'),(21,'Gb major'),(22,'A minor'),(23,'A# minor'),(24,'Ab minor'),(25,'B minor'),(26,'B# minor'),(27,'Bb minor'),(28,'C minor'),(29,'C# minor'),(30,'Cb minor'),(31,'D minor'),(32,'D# minor'),(33,'Db minor'),(34,'E minor'),(35,'E# minor'),(36,'Eb minor'),(37,'F minor'),(38,'F# minor'),(39,'Fb minor'),(40,'G minor'),(41,'G# minor'),(42,'Gb minor');
/*!40000 ALTER TABLE `keySignatures` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `musicKeys`
--

DROP TABLE IF EXISTS `musicKeys`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `musicKeys` (
  `music_key` varchar(10) NOT NULL,
  PRIMARY KEY (`music_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `musicKeys`
--

LOCK TABLES `musicKeys` WRITE;
/*!40000 ALTER TABLE `musicKeys` DISABLE KEYS */;
INSERT INTO `musicKeys` VALUES ('A'),('A#'),('Ab'),('B'),('B#'),('Bb'),('C'),('C#'),('Cb'),('D'),('D#'),('Db'),('E'),('E#'),('Eb'),('F'),('F#'),('Fb'),('G'),('G#'),('Gb');
/*!40000 ALTER TABLE `musicKeys` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `noteValues`
--

DROP TABLE IF EXISTS `noteValues`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `noteValues` (
  `note_value` int NOT NULL,
  PRIMARY KEY (`note_value`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `noteValues`
--

LOCK TABLES `noteValues` WRITE;
/*!40000 ALTER TABLE `noteValues` DISABLE KEYS */;
INSERT INTO `noteValues` VALUES (2),(4),(8),(16);
/*!40000 ALTER TABLE `noteValues` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `opusInfo`
--

DROP TABLE IF EXISTS `opusInfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `opusInfo` (
  `id_num` int NOT NULL AUTO_INCREMENT,
  `op_num` int NOT NULL,
  `year_complete` int NOT NULL,
  `dedication` varchar(256) DEFAULT NULL,
  `total_pieces` int NOT NULL,
  PRIMARY KEY (`id_num`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `opusInfo`
--

LOCK TABLES `opusInfo` WRITE;
/*!40000 ALTER TABLE `opusInfo` DISABLE KEYS */;
INSERT INTO `opusInfo` VALUES (1,12,1867,'Dedicated to Betty Egeberg',8),(2,38,1884,NULL,8),(3,43,1886,'Dedicated to Isidor Seiss',6),(4,47,1888,'Dedicated to Elisabeth Hornemann',7),(5,54,1891,'Dedicated to Julius Rontgen',6),(6,57,1893,'Dedicated to Herrmann Scholtz',6),(7,62,1895,NULL,6),(8,65,1897,NULL,6),(9,68,1899,NULL,6),(10,71,1901,'Dedicated to Mrs. Mien Rontgen',7);
/*!40000 ALTER TABLE `opusInfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `performances`
--

DROP TABLE IF EXISTS `performances`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `performances` (
  `performance_id` int NOT NULL AUTO_INCREMENT,
  `piece_id` int NOT NULL,
  `recording_id` int NOT NULL,
  PRIMARY KEY (`performance_id`),
  KEY `piece_id` (`piece_id`),
  KEY `recording_id` (`recording_id`)
) ENGINE=InnoDB AUTO_INCREMENT=170 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `performances`
--

LOCK TABLES `performances` WRITE;
/*!40000 ALTER TABLE `performances` DISABLE KEYS */;
INSERT INTO `performances` VALUES (1,1,1),(2,4,1),(3,5,1),(4,9,1),(5,10,1),(6,13,1),(7,15,1),(8,17,1),(9,20,1),(10,22,1),(11,23,1),(12,24,1),(13,25,1),(14,28,1),(15,30,1),(16,31,1),(17,33,1),(18,41,1),(19,44,1),(20,45,1),(21,47,1),(22,52,1),(23,53,1),(24,58,1),(25,62,1),(26,66,1),(27,66,2),(28,53,2),(29,8,2),(30,19,2),(31,22,2),(32,29,2),(33,3,2),(34,17,2),(35,25,2),(36,20,2),(37,43,2),(38,27,2),(39,28,2),(40,35,2),(41,21,2),(42,32,2),(43,9,2),(44,42,2),(45,46,2),(46,38,2),(47,37,2),(48,36,2),(49,53,2),(50,57,3),(51,58,3),(52,53,3),(53,1,4),(54,2,4),(55,3,4),(56,4,4),(57,5,4),(58,6,4),(59,7,4),(60,8,4),(61,9,4),(62,10,4),(63,11,4),(64,12,4),(65,13,4),(66,14,4),(67,15,4),(68,16,4),(69,17,4),(70,18,4),(71,19,4),(72,20,4),(73,21,4),(74,22,4),(75,23,4),(76,24,4),(77,25,4),(78,26,4),(79,27,4),(80,28,4),(81,29,4),(82,30,5),(83,31,5),(84,32,5),(85,33,5),(86,34,5),(87,35,5),(88,36,5),(89,37,5),(90,38,5),(91,39,5),(92,40,5),(93,41,5),(94,42,5),(95,43,5),(96,44,5),(97,45,5),(98,46,5),(99,47,5),(100,48,6),(101,49,6),(102,50,6),(103,51,6),(104,52,6),(105,53,6),(106,54,6),(107,55,6),(108,56,6),(109,57,6),(110,58,6),(111,59,6),(112,60,6),(113,61,6),(114,62,6),(115,63,6),(116,64,6),(117,65,6),(118,66,6),(119,33,7),(120,31,7),(121,17,7),(122,1,8),(123,2,8),(124,3,8),(125,4,8),(126,12,8),(127,16,8),(128,17,8),(129,22,8),(130,23,8),(131,31,8),(132,34,8),(133,35,8),(134,39,8),(135,40,8),(136,41,8),(137,46,8),(138,53,8),(139,57,8),(140,35,9),(141,53,10),(142,57,10),(143,58,10),(144,30,11),(145,31,11),(146,32,11),(147,33,11),(148,60,12),(149,11,13),(150,21,13),(151,1,13),(152,33,13),(153,61,13),(154,58,13),(155,1,14),(156,20,14),(157,9,14),(158,58,14),(159,66,14),(160,23,15),(161,26,15),(162,27,15),(163,28,15),(164,29,15),(165,45,16),(166,4,17),(167,20,18),(168,32,19),(169,22,20);
/*!40000 ALTER TABLE `performances` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pieces`
--

DROP TABLE IF EXISTS `pieces`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pieces` (
  `piece_id` int NOT NULL AUTO_INCREMENT,
  `piece_name` varchar(256) NOT NULL,
  `opus_id` int NOT NULL,
  `sequence_num` int NOT NULL,
  `tempo` varchar(256) NOT NULL,
  `key_sig_id` int NOT NULL,
  `time_sig_id` int NOT NULL,
  `challenge_rating` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`piece_id`),
  KEY `opus_id` (`opus_id`),
  KEY `key_sig_id` (`key_sig_id`),
  KEY `time_sig_id` (`time_sig_id`),
  CONSTRAINT `pieces_ibfk_1` FOREIGN KEY (`opus_id`) REFERENCES `opusInfo` (`id_num`),
  CONSTRAINT `pieces_ibfk_2` FOREIGN KEY (`key_sig_id`) REFERENCES `keySignatures` (`ks_id`),
  CONSTRAINT `pieces_ibfk_3` FOREIGN KEY (`time_sig_id`) REFERENCES `timeSignatures` (`ts_id`)
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pieces`
--

LOCK TABLES `pieces` WRITE;
/*!40000 ALTER TABLE `pieces` DISABLE KEYS */;
INSERT INTO `pieces` VALUES (1,'Arietta',1,1,'Poco Andante e sostenuto',15,11,'5'),(2,'Waltz',1,2,'Allegro moderato',22,12,'4'),(3,'Watchman\'s Song',1,3,'Molto andante e semplice',13,2,'4'),(4,'Elves\' Dance',1,4,'Molto Allegro e sempre staccato',34,12,'6'),(5,'Folk Melody',1,5,'Con moto',38,12,'5'),(6,'Norwegian Melody',1,6,'Presto marcato',10,12,'6'),(7,'Album Leaf',1,7,'Allegretto e dolce',34,11,'5'),(8,'National Song',1,8,'Maestoso',15,13,'4'),(9,'Berceuse',2,1,'Allegretto tranquillo',19,11,'5'),(10,'Folk Melody',2,2,'Allegro con moto',34,12,'5'),(11,'Melody',2,3,'Allegretto',7,13,'5'),(12,'Halling',2,4,'Allegro marcato',40,11,'6'),(13,'Leaping Dance',2,5,'Allegro giocoso',19,12,'6'),(14,'Elegy',2,6,'Allegretto semplice',22,12,'5'),(15,'Waltz',2,7,'Poco Allegro',34,12,'5'),(16,'Canon',2,8,'Allegretto con moto',27,12,'6'),(17,'Butterfly',3,1,'Allegro grazioso',1,13,'7'),(18,'Lonely Wanderer',3,2,'Allegretto semplice',25,24,'6'),(19,'In My Homeland',3,3,'Poco andante',32,13,'5'),(20,'Little Bird',3,4,'Allegretto leggiero',31,24,'6'),(21,'Erotic Piece',3,5,'Lento molto',16,11,'7'),(22,'To Spring',3,6,'Allegro appassionato',17,15,'7'),(23,'Valse-Impromptu',4,1,'Allegro con moto',34,12,'6'),(24,'Album Leaf',4,2,'Allegro vivace',16,24,'6'),(25,'Melody',4,3,'Allegretto',22,24,'5'),(26,'Halling',4,4,'Allegro',10,11,'5'),(27,'Melancholy',4,5,'Largo',40,11,'5'),(28,'Leaping Dance',4,6,'Allegro vivace',19,12,'6'),(29,'Elegy',4,7,'Poco Andante',25,11,'5'),(30,'Shepard Boy',5,1,'Andante espressivo',40,24,'6'),(31,'Peasants\' March',5,2,'Allegretto marcato',7,24,'5'),(32,'March of the Trolls',5,3,'Allegro moderato',31,11,'8'),(33,'Notturno',5,4,'Andante espressivo',7,27,'5'),(34,'Scherzo',5,5,'Prestissimo leggiero',34,12,'5'),(35,'Bell-Ringing',5,6,'Andante',7,11,'5'),(36,'Vanished Days',6,1,'Andantino',31,12,'5'),(37,'Gade',6,2,'Allegro grazioso',1,2,'5'),(38,'Illusion',6,3,'Allegretto serioso',22,24,'5'),(39,'Secret',6,4,'Andante espressivo',19,13,'5'),(40,'She Dances',6,5,'Tempo di Valse',7,12,'5'),(41,'Homesickness',6,6,'Andante',34,12,'5'),(42,'Sylph',7,1,'Allegretto con moto',25,12,'5'),(43,'Thanks',7,2,'Allegretto semplice',19,13,'4'),(44,'French Serenade',7,3,'Andante grazioso',1,13,'5'),(45,'The Brook',7,4,'Allegro leggiero',25,12,'6'),(46,'Phantom',7,5,'Poco Andante ed espressivo',1,24,'5'),(47,'Homeward',7,6,'Allegro giocoso alla marcia',13,11,'5'),(48,'From Days of Youth',8,1,'Allegro moderato e tranquillo',31,12,'5'),(49,'Peasant\'s Song',8,2,'Andante semplice',1,13,'5'),(50,'Sadness',8,3,'Andante espressivo',25,13,'6'),(51,'Salon',8,4,'Allegretto con grazia',1,24,'6'),(52,'In Ballad Style',8,5,'Lento lugubre',28,2,'5'),(53,'Wedding Day at Troldhaugen',8,6,'Tempo di Marcia un poco vivace',10,13,'7'),(54,'Sailors\' Song',9,1,'Allegro vivace e marcato',7,2,'5'),(55,'Grandmother\'s Minuet',9,2,'Allegretto grazioso e leggerissimo',19,12,'4'),(56,'At Your Feet',9,3,'Pco Andante e molto espressivo',10,11,'5'),(57,'Evening in the Mountains',9,4,'Allegretto',34,11,'5'),(58,'Cradle Song',9,5,'Allegretto tranquillamente',13,13,'5'),(59,'Valse melancolique',9,6,'Tempo di Valse tranquillo',40,12,'5'),(60,'Once upon a Time',10,1,'Andante con moto',34,13,'6'),(61,'Summer Evening',10,2,'Allegretto tranquillamente',27,12,'6'),(62,'Little Troll',10,3,'Allegro molto',36,2,'5'),(63,'Woodland Peace',10,4,'Lento',38,2,'6'),(64,'Halling',10,5,'Allegro molto',7,11,'6'),(65,'Gone',10,6,'Andante doloroso',34,13,'5'),(66,'Remembrances',10,7,'Tempo di Valse',15,12,'5');
/*!40000 ALTER TABLE `pieces` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recordings`
--

DROP TABLE IF EXISTS `recordings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recordings` (
  `r_id` int NOT NULL AUTO_INCREMENT,
  `publisher` varchar(256) DEFAULT NULL,
  `album_name` varchar(256) NOT NULL,
  `artist_first_name` varchar(256) DEFAULT NULL,
  `artist_last_name` varchar(256) NOT NULL,
  `group_name` varchar(256) DEFAULT NULL,
  `year_released` int DEFAULT NULL,
  `instrumentation` varchar(256) NOT NULL,
  PRIMARY KEY (`r_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recordings`
--

LOCK TABLES `recordings` WRITE;
/*!40000 ALTER TABLE `recordings` DISABLE KEYS */;
INSERT INTO `recordings` VALUES (1,'NAXOS','Grieg, Lyric Pieces (Selections)','Einar','Steen-Nokleberg','',1997,'piano'),(2,'NAXOS','Grieg, Lyric Pieces Vol. 2','Balazs','Szokolay','',1993,'piano'),(3,'NAXOS','Grieg: Peer Gynt/Lyric Pieces/Sigurd Jorsalfar','Jerzy','Maksymiuk','BBC Scottish Symphony Orchestra',1994,'orchestra'),(4,'Amadis','Grieg: Lyric Pieces, Books 1-4','Marian','Lapsandsky','',1995,'piano'),(5,'Amadis','Grieg: Lyric Pieces, Books 5-7','Marian','Lapsandsky','',1995,'piano'),(6,'Amadis','Grieg: Lyric Pieces, Books 8-10','Marian','Lapsandsky','',1995,'piano'),(7,'Swedish Society','Grieg, E.: Piano Concerto, Op. 16 / Lyric Pieces (excerpts)','Hilda','Waldeland','',1998,'piano'),(8,'Stradivarius','Grieg, E.: Lyric Pieces (excerpts) / Debussy, C.: Preludes, Book 2 (excerpts)','Sciatoslav','Richter','',2021,'piano'),(9,'NAXOS','Grieg, E.: Orchestral Music, Vol. 2 - Orchestrated Piano Pieces','Bjarte','Engeset','Royal Scottish National Orchestra',2007,'orchestra'),(10,'Amadis','Grieg: Peer Gynt Suites Nos. 1 and 2 /3 Orchestral Pieces from Sigurd Jorsalfar','Stephen','Gunzenhauser','CSSR State Philharmonic Orchestra, Kosice',1995,'orchestra'),(11,'NAXOS','Grieg, E.: Orchestral Music, Vol. 6 - From Holberg?s Time / Lyric Suite / Melodies','Bjarte ','Engeset','Malmo Symphony Orchestra',2011,'orchestra'),(12,'NAXOS','Music for Saxophone and Organ - Grieg, E. / Ebert, J. / Back, J.S. / Debussy, C. / Bozza, E. / Wordtmann, M. ','','','Hans-martin Limberg / Manfred Wordtmann',2012,'alto saxophone and organ'),(13,'NAXOS','Grieg for Meditation (Swedish Edition)','','','Various',2006,'piano / orchestra / violin and piano'),(14,'NAXOS','Franck, C. / Grieg, E.: Violin Sonatas','','','Jeno Jando / Takako Nishizaki',1991,'violin and piano\n'),(15,'Capriccio','Flute and Harp Arrangements - Tartan, G. / Back, J.S. / Mozart, W.A. / Tchaikovsky, P.I. / Liszt, F. / Grieg, E. / Chopin, F.','','','Janos Balint / Deborah Sipkai',1998,'harp and flute'),(16,'Solo Musica','Aqua','Arta','Arnica','',2017,'piano'),(17,'OUR Recordings','Garden Party','','','Lars Hannibal / Michala Petri',2017,'recorder and guitar'),(18,'Dorian Sono Luminus','If I Were a Bird','Michael','Lewin','',2010,'piano'),(19,'Gramola Records','Voyageurs','Barbara','Moser','',2012,'piano'),(20,'NAXOS','Fritz Kreisler Edition, Vol. 9','','','Takako Nishizaki / Wolf Harden',2005,'violin and piano');
/*!40000 ALTER TABLE `recordings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `timeSignatures`
--

DROP TABLE IF EXISTS `timeSignatures`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `timeSignatures` (
  `ts_id` int NOT NULL AUTO_INCREMENT,
  `time_signature` varchar(256) NOT NULL,
  PRIMARY KEY (`ts_id`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `timeSignatures`
--

LOCK TABLES `timeSignatures` WRITE;
/*!40000 ALTER TABLE `timeSignatures` DISABLE KEYS */;
INSERT INTO `timeSignatures` VALUES (1,'1 / 2'),(2,'2 / 2'),(3,'3 / 2'),(4,'4 / 2'),(5,'5 / 2'),(6,'6 / 2'),(7,'7 / 2'),(8,'8 / 2'),(9,'9 / 2'),(10,'1 / 4'),(11,'2 / 4'),(12,'3 / 4'),(13,'4 / 4'),(14,'5 / 4'),(15,'6 / 4'),(16,'7 / 4'),(17,'8 / 4'),(18,'9 / 4'),(19,'1 / 8'),(20,'2 / 8'),(21,'3 / 8'),(22,'4 / 8'),(23,'5 / 8'),(24,'6 / 8'),(25,'7 / 8'),(26,'8 / 8'),(27,'9 / 8'),(28,'1 / 16'),(29,'2 / 16'),(30,'3 / 16'),(31,'4 / 16'),(32,'5 / 16'),(33,'6 / 16'),(34,'7 / 16'),(35,'8 / 16'),(36,'9 / 16');
/*!40000 ALTER TABLE `timeSignatures` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tonalities`
--

DROP TABLE IF EXISTS `tonalities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tonalities` (
  `tonality` varchar(256) NOT NULL,
  PRIMARY KEY (`tonality`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tonalities`
--

LOCK TABLES `tonalities` WRITE;
/*!40000 ALTER TABLE `tonalities` DISABLE KEYS */;
INSERT INTO `tonalities` VALUES ('major'),('minor');
/*!40000 ALTER TABLE `tonalities` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-12-21 21:28:23
