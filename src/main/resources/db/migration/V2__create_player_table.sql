CREATE TABLE player (
    n_id INT AUTO_INCREMENT PRIMARY KEY,
    v_firstname VARCHAR(50) NOT NULL,
    v_lastname VARCHAR(50) NOT NULL,
    v_position VARCHAR(30),
    dt_date_of_birth DATETIME NOT NULL,
    n_team_id INT,
    CONSTRAINT fk_player_team FOREIGN KEY (n_team_id) REFERENCES team(n_id)
);