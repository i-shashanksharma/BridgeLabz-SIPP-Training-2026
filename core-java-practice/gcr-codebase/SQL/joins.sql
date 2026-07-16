-- =====================================================
-- Use Case 1: Find Highest Confirmed Cases using INNER JOIN
-- =====================================================

SELECT c.country_name,
       cc.confirmed_cases
FROM covid_cases cc
INNER JOIN countries c
    ON cc.country_id = c.country_id
WHERE cc.date = '2021-06-01'
ORDER BY cc.confirmed_cases DESC
LIMIT 1;


-- =====================================================
-- Use Case 2: Join COVID Deaths and Vaccination Data
-- =====================================================

SELECT c.country_name,
       d.date,
       d.deaths,
       v.vaccination_status
FROM covid_deaths d
LEFT JOIN covid_vaccines v
    ON d.country_id = v.country_id
    AND d.date = v.date
INNER JOIN countries c
    ON d.country_id = c.country_id;


-- =====================================================
-- Use Case 3: Analyze Deaths by Continent
-- =====================================================

SELECT ct.continent_name,
       SUM(cc.deaths) AS total_deaths
FROM covid_cases cc
INNER JOIN countries c
    ON cc.country_id = c.country_id
INNER JOIN continents ct
    ON c.continent_id = ct.continent_id
GROUP BY ct.continent_name;


-- =====================================================
-- Use Case 4: Calculate Average New Deaths Per Day
-- =====================================================

SELECT date,
       AVG(deaths) AS average_daily_deaths
FROM covid_deaths
GROUP BY date
ORDER BY date;


-- =====================================================
-- Use Case 5: Find Countries with Highest Infection Rates
-- =====================================================

SELECT c.country_name,
       c.population,
       cc.confirmed_cases,
       (cc.confirmed_cases * 100.0 / c.population) AS infection_rate
FROM covid_cases cc
INNER JOIN countries c
    ON cc.country_id = c.country_id
ORDER BY infection_rate DESC;