CREATE TABLE player (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    position VARCHAR(30),
    age INT NOT NULL,
    team_id INT,
    CONSTRAINT fk_player_team FOREIGN KEY (team_id) REFERENCES team(id)
);