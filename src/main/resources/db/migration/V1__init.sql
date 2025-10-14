CREATE TYPE gender AS ENUM('MALE', 'FEMALE', 'OTHER');
CREATE TYPE status As ENUM('ACTIVE', 'INACTIVE', 'BLOCKED');
CREATE TABLE IF NOT EXISTS users
(
    user_id       SERIAL PRIMARY KEY,
    username      VARCHAR(100) NOT NULL,
    email_address VARCHAR(150) NOT NULL UNIQUE,
    password      VARCHAR(255) NOT NULL,
    first_name    VARCHAR(100),
    last_name     VARCHAR(100),
    date_of_birth DATE,
    gender        gender NOT NULL,
    created_at    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status        status NOT NULL
);

CREATE TABLE IF NOT EXISTS contacts
(
    contact_id SERIAL PRIMARY KEY,
    user_id    INT NOT NULL,
    first_name VARCHAR(100),
    last_name  VARCHAR(100),
    FOREIGN KEY (user_id) REFERENCES users (user_id) ON DELETE CASCADE
);



