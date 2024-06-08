CREATE TABLE IF NOT EXISTS communal_payment
(
    title                VARCHAR(50) NOT NULL,
    user_passport_number VARCHAR(9)  NOT NULL,
    balance              BIGINT      NOT NULL,
    PRIMARY KEY (title, user_passport_number)
);
