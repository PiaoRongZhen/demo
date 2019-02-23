CREATE TABLE customers
(
  cust_id      int       NOT NULL AUTO_INCREMENT ,
  cust_name    char(50)  NOT NULL ,
  cust_address char(50)  NULL ,
  cust_city    char(50)  NULL ,
  cust_state   char(5)   NULL ,
  cust_zip     char(10)  NULL ,
  cust_country char(50)  NULL ,
  cust_contact char(50)  NULL ,
  cust_email   char(255) NULL ,
  PRIMARY KEY (cust_id)
) ENGINE=InnoDB;

SELECT name, population, area
FROM World
WHERE area > 3000000 OR population > 25000000;

UPDATE salary
SET sex = CASE
WHEN sex = 'm' THEN 'f'
WHEN sex = 'f' THEN 'm'
END;

SELECT id, movie, description, rating
FROM cinema
WHERE id % 2 = 1 AND description != 'boring'
ORDER BY rating DESC;

SELECT Email
FROM Person
GROUP BY Email
HAVING COUNT(*) > 1;

SELECT FirstName, LastName, City, State
FROM Person LEFT JOIN Address ON Person.PersonId = Address.PersonId;

SELECT E1.Name AS Employee
FROM Employee E1 JOIN Employee E2 ON E1.ManagerId = E2.Id AND E1.Salary > E2.Salary;

SELECT Name AS Customers
FROM Customers
WHERE Id NOT IN (
	SELECT CustomerId
	FROM Orders
);

SELECT class
FROM courses
GROUP BY class
HAVING COUNT(DISTINCT student) >= 5;

SELECT W1.Id
FROM Weather W1 JOIN Weather W2 ON DATEDIFF(W1.RecordDate, W2.RecordDate) = 1 AND W1.Temperature > W2.Temperature;

DELETE P1
FROM Person P1 JOIN Person P2 ON P1.Email = P2.Email AND P1.Id > P2.Id;

SELECT MAX(Salary) AS SecondHighestSalary
FROM Employee
WHERE Salary < (
    SELECT MAX(Salary)
    FROM Employee
);

SELECT IF(id < (SELECT COUNT(*) FROM seat), IF(id % 2 = 1, id + 1, id - 1), IF(id % 2 = 1, id, id - 1)) AS id, student
FROM seat
ORDER BY id ASC;

SELECT Department.Name AS Department, Employee.Name AS Employee, Salary
FROM Employee JOIN Department ON Employee.DepartmentId = Department.Id AND (Salary, Employee.DepartmentId) IN (
	SELECT MAX(Salary), DepartmentId
	FROM Employee
	GROUP BY DepartmentId
);



