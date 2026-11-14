CREATE TABLE country (
     n_id INT AUTO_INCREMENT PRIMARY KEY,
     v_name VARCHAR(255) NOT NULL
);

CREATE TABLE team (
    n_id INT AUTO_INCREMENT PRIMARY KEY,
    v_name VARCHAR(255) NOT NULL,
    n_country_id INT,
    dt_year_founded DATETIME,
    CONSTRAINT fk_team_country FOREIGN KEY (n_country_id) REFERENCES country(n_id)
);