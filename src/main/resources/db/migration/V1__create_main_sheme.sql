CREATE TABLE IF NOT EXISTS tb_user (
    id BIGSERIAL PRIMARY KEY,
    email VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(16) NOT NULL UNIQUE,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS tb_country (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(74) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS tb_address (
    id BIGSERIAL PRIMARY KEY,
    city VARCHAR(168) UNIQUE NOT NULL,
    postal_code INT UNIQUE NOT NULL,
    street_name VARCHAR(250) UNIQUE NOT NULL,
    apartment_number INT UNIQUE NOT NULL,
    country_id BIGINT REFERENCES tb_country(id)
);

CREATE TABLE IF NOT EXISTS tb_user_address (
    user_id BIGINT REFERENCES tb_user(id),
    address_id BIGINT REFERENCES tb_address(id),
    PRIMARY KEY (user_id, address_id)
);