-- DROP CONSTRAINT
ALTER TABLE tb_address
DROP CONSTRAINT tb_address_city_key;

ALTER TABLE tb_address
DROP CONSTRAINT tb_address_postal_code_key;

ALTER TABLE tb_address
DROP CONSTRAINT tb_address_street_name_key;

ALTER TABLE tb_address
DROP CONSTRAINT tb_address_apartment_number_key;

-- ADD NEW UNIQUE CONSTRAINT TO tb_address
ALTER TABLE tb_address
ADD CONSTRAINT tb_address_unique UNIQUE (city, postal_code, street_name, apartment_number);