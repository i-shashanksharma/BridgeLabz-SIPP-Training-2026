-- =====================================================
-- Use Case 21: Create View for Latest COVID Data
-- =====================================================

CREATE VIEW Latest_Covid_Data AS
SELECT c.country_name,
       cc.date,
       cc.confirmed_cases,
       cc.deaths,
       cc.recovered
FROM covid_cases cc
INNER JOIN countries c
    ON cc.country_id = c.country_id
WHERE cc.date = (
    SELECT MAX(date)
    FROM covid_cases
    WHERE country_id = cc.country_id
);


-- =====================================================
-- Use Case 22: Build Mortality Rate Function
-- =====================================================

DELIMITER //

CREATE FUNCTION CalculateMortalityRate(
    p_country_id INT,
    p_date DATE
)
RETURNS DECIMAL(5,2)
DETERMINISTIC
BEGIN
    DECLARE mortality_rate DECIMAL(5,2);

    SELECT (deaths * 100.0 / confirmed_cases)
    INTO mortality_rate
    FROM covid_cases
    WHERE country_id = p_country_id
    AND date = p_date;

    RETURN IFNULL(mortality_rate,0);
END //

DELIMITER ;


-- =====================================================
-- Use Case 23: Create Stored Procedure for Data Updates
-- =====================================================

DELIMITER //

CREATE PROCEDURE UpdateCovidStats(
    IN p_country_id INT,
    IN p_date DATE,
    IN p_confirmed_cases INT,
    IN p_deaths INT,
    IN p_recovered INT
)
BEGIN

    START TRANSACTION;

    UPDATE covid_cases
    SET confirmed_cases = p_confirmed_cases,
        deaths = p_deaths,
        recovered = p_recovered
    WHERE country_id = p_country_id
    AND date = p_date;

    COMMIT;

END //

DELIMITER ;


-- =====================================================
-- Use Case 24: Implement Recovery Rate Function
-- =====================================================

DELIMITER //

CREATE FUNCTION CalculateRecoveryRate(
    p_country_id INT
)
RETURNS DECIMAL(5,2)
DETERMINISTIC
BEGIN
    DECLARE recovery_rate DECIMAL(5,2);

    SELECT (SUM(recovered) * 100.0 / SUM(confirmed_cases))
    INTO recovery_rate
    FROM covid_cases
    WHERE country_id = p_country_id;

    RETURN IFNULL(recovery_rate,0);

END //

DELIMITER ;


-- =====================================================
-- Use Case 25: Create Audit Trigger for Data Changes
-- =====================================================

CREATE TABLE covid_audit (
    audit_id INT AUTO_INCREMENT PRIMARY KEY,
    country_id INT,
    old_confirmed_cases INT,
    new_confirmed_cases INT,
    old_deaths INT,
    new_deaths INT,
    old_recovered INT,
    new_recovered INT,
    changed_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


DELIMITER //

CREATE TRIGGER Before_Covid_Update
BEFORE UPDATE ON covid_cases
FOR EACH ROW
BEGIN

    INSERT INTO covid_audit
    (
        country_id,
        old_confirmed_cases,
        new_confirmed_cases,
        old_deaths,
        new_deaths,
        old_recovered,
        new_recovered
    )
    VALUES
    (
        OLD.country_id,
        OLD.confirmed_cases,
        NEW.confirmed_cases,
        OLD.deaths,
        NEW.deaths,
        OLD.recovered,
        NEW.recovered
    );

END //

DELIMITER ;
