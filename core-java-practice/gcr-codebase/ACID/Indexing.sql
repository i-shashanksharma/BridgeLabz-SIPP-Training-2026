
-- ============================================================
-- Use Case 26: Create Indexes on Frequently Searched Columns
-- Objective:
-- Improve the performance of queries filtering by country and date.
-- ============================================================

CREATE INDEX idx_country_date
ON covid_cases(Country, Date);

CREATE INDEX idx_date
ON covid_cases(Date);

SELECT *
FROM covid_cases
WHERE Country='India'
AND Date='2022-01-01';







-- ============================================================
-- Use Case 27: Optimize Top 10 High Infection Rate Queries
-- Objective:
-- Enable faster retrieval of the top 10 countries sorted by
-- infection_rate.
-- ============================================================

CREATE INDEX idx_infection_rate
ON covid_cases(infection_rate DESC, Country);

SELECT Country, infection_rate
FROM covid_cases
ORDER BY infection_rate DESC
LIMIT 10;






-- ============================================================
-- Use Case 28: Analyze Query Execution Plans
-- Objective:
-- Identify missing indexes and understand query execution.
-- ============================================================

EXPLAIN
SELECT c.Country,
v.total_vaccinations
FROM covid_cases c
JOIN covid_vaccinations v
ON c.Country=v.Country
WHERE c.Country='India';

CREATE INDEX idx_country
ON covid_cases(Country);

CREATE INDEX idx_vaccine_country
ON covid_vaccinations(Country);

EXPLAIN
SELECT c.Country,
v.total_vaccinations
FROM covid_cases c
JOIN covid_vaccinations v
ON c.Country=v.Country
WHERE c.Country='India';








-- ============================================================
-- Use Case 29: Implement ACID Transaction for Vaccine Data
-- Objective:
-- Ensure data integrity using transactions.
-- ============================================================

START TRANSACTION;

INSERT INTO covid_vaccinations
(Country, Date, total_vaccinations)
VALUES
('India','2022-01-01',1000000);

INSERT INTO vaccine_distribution
(Country, Date, doses_distributed)
VALUES
('India','2022-01-01',1000000);

COMMIT;

START TRANSACTION;

INSERT INTO covid_vaccinations
(Country, Date, total_vaccinations)
VALUES
('India','2022-01-01',1000000);

ROLLBACK;







-- ============================================================
-- Use Case 30: Demonstrate Isolation Levels
-- Objective:
-- Demonstrate Dirty Read, Non-Repeatable Read and Phantom Read.
-- ============================================================

-- Dirty Read (READ UNCOMMITTED)

SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED;

START TRANSACTION;

UPDATE covid_vaccinations
SET total_vaccinations=5000
WHERE Country='India';

-- In another session

SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED;

START TRANSACTION;

SELECT *
FROM covid_vaccinations
WHERE Country='India';

COMMIT;


-- Read Committed (Prevents Dirty Reads)

SET TRANSACTION ISOLATION LEVEL READ COMMITTED;

START TRANSACTION;

SELECT *
FROM covid_vaccinations
WHERE Country='India';

COMMIT;


-- Repeatable Read (Prevents Non-Repeatable Reads)

SET TRANSACTION ISOLATION LEVEL REPEATABLE READ;

START TRANSACTION;

SELECT *
FROM covid_vaccinations
WHERE Country='India';

COMMIT;


-- Serializable (Prevents Phantom Reads)

SET TRANSACTION ISOLATION LEVEL SERIALIZABLE;

START TRANSACTION;

SELECT *
FROM covid_vaccinations
WHERE total_vaccinations>100000;

COMMIT;