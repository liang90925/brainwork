# Write your MySQL query statement below
SELECT tt.Request_at AS 'Day', ROUND(SUM(IF(tt.Status = 'completed', 0, 1)) / COUNT(*), 2) AS 'Cancellation Rate'
FROM Trips tt
LEFT JOIN Users ut
ON tt.Client_Id = ut.Users_Id
WHERE ut.Banned = 'No' AND tt.Request_at BETWEEN '2013-10-01' AND '2013-10-03'
GROUP BY tt.Request_at
ORDER BY tt.Request_at ASC;


####Following code To create and build the table #####

-- 执行脚本前必须建立名为LEETCODE的DATABASE
USE LEETCODE;

DROP TABLE IF EXISTS Trips; #指如果存在一样的table将其删除，因为下面要create
CREATE TABLE Trips (
  Id INT NOT NULL,
  Client_Id INT,
  Driver_Id INT,
  City_Id INT,
  Status ENUM('completed', 'cancelled_by_driver', 'cancelled_by_client'),
  Request_at DATE,
  PRIMARY KEY (Id),
  FOREIGN KEY (Client_Id) REFERENCES Users(Users_Id)
  FOREIGN KEY (Driver_Id) REFERENCES Users(Users_Id)
)

INSERT INTO Trips (Id, Client_Id, Driver_Id, City_Id, Status, Request_at)
  VALUES (1, 1, 10, 1, 'completed', '2013-10-01');
INSERT INTO Trips (Id, Client_Id, Driver_Id, City_Id, Status, Request_at)
  VALUES (2, 2, 11, 1, 'cancelled_by_driver', '2013-10-01');
INSERT INTO Trips (Id, Client_Id, Driver_Id, City_Id, Status, Request_at)
  VALUES (3, 3, 12, 6, 'completed', '2013-10-01');
INSERT INTO Trips (Id, Client_Id, Driver_Id, City_Id, Status, Request_at)
  VALUES (4, 4, 13, 6, 'cancelled_by_client', '2013-10-01');
INSERT INTO Trips (Id, Client_Id, Driver_Id, City_Id, Status, Request_at)
  VALUES (5, 1, 10, 1, 'completed', '2013-10-02');
INSERT INTO Trips (Id, Client_Id, Driver_Id, City_Id, Status, Request_at)
  VALUES (6, 2, 11, 6, 'completed', '2013-10-02');
INSERT INTO Trips (Id, Client_Id, Driver_Id, City_Id, Status, Request_at)
  VALUES (7, 3, 12, 6, 'completed', '2013-10-02');
INSERT INTO Trips (Id, Client_Id, Driver_Id, City_Id, Status, Request_at)
  VALUES (8, 2, 12, 12, 'completed', '2013-10-03');
INSERT INTO Trips (Id, Client_Id, Driver_Id, City_Id, Status, Request_at)
  VALUES (9, 3, 10, 12, 'completed', '2013-10-03');
INSERT INTO Trips (Id, Client_Id, Driver_Id, City_Id, Status, Request_at)
  VALUES (10, 4, 13, 12, 'cancelled_by_driver', '2013-10-03');

DROP TABLE IF EXISTS Users; #指如果存在一样的table将其删除，因为下面要create
CREATE TABLE Users (
  Users_Id INT NOT NULL,
  Banned VARCHAR(5),
  Role ENUM('client', 'driver', 'partner'),
  PRIMARY KEY (Users_Id)
);
#VARCHAR(5) 指最大存储5个字符

INSERT INTO Users (Users_Id, Banned, Role) VALUES (1, 'N0', 'client');
INSERT INTO Users (Users_Id, Banned, Role) VALUES (2, 'Yes', 'client');
INSERT INTO Users (Users_Id, Banned, Role) VALUES (3, 'No', 'client');
INSERT INTO Users (Users_Id, Banned, Role) VALUES (4, 'No', 'client');
INSERT INTO Users (Users_Id, Banned, Role) VALUES (10, 'No', 'driver');
INSERT INTO Users (Users_Id, Banned, Role) VALUES (11, 'No', 'driver');
INSERT INTO Users (Users_Id, Banned, Role) VALUES (12, 'No', 'driver');
INSERT INTO Users (Users_Id, Banned, Role) VALUES (13, 'No', 'driver');s
