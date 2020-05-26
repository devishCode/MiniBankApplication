-- Database minibankappdb /  user root / password 12345678 / jdbc url default mysql with port 127.0.0.1:3306

CREATE TABLE IF NOT EXISTS accountinfo (
userID INT NOT NULL PRIMARY KEY,
name VARCHAR(30) NOT NULL,
balance DOUBLE NOT NULL
);

INSERT INTO accountinfo (userID,name,balance) VALUES(000111,"Devish N",24000) ;
INSERT INTO accountinfo (userID,name,balance) VALUES(000112,"Varun G",15000) ;
INSERT INTO accountinfo (userID,name,balance) VALUES(000123,"Sam P",22000) ;
INSERT INTO accountinfo (userID,name,balance) VALUES(000124,"Sid P",8500) ;

select * from accountinfo;
