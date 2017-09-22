DROP TABLE IF EXISTS DIM_PLAYER;
CREATE TABLE DIM_PLAYER(PLAYERID BIGINT, COUNTRY CHAR(2) NOT NULL, PLAYERSTATE VARCHAR(11), VALIDFROM DATE, VALIDTO DATE,
	PRIMARY KEY (PLAYERID, VALIDFROM));
INSERT INTO DIM_PLAYER VALUES(10000053877, 'SE', 'VALIDATED', '2015-09-22', '2016-09-22');
INSERT INTO DIM_PLAYER VALUES(10000053877, 'FI', 'VALIDATED', '2016-09-22', '2016-10-22');
INSERT INTO DIM_PLAYER VALUES(10000053877, 'SE', 'VALIDATED', '2016-12-22', NULL);
INSERT INTO DIM_PLAYER VALUES(10000053878, 'FI', 'VALIDATED', '2015-09-22', NULL);
