CREATE TABLE IF NOT EXISTS card
(
    number                  BIGINT PRIMARY KEY,
    holders_passport_number VARCHAR(9) NOT NULL,
    balance                 BIGINT     NOT NULL
);
