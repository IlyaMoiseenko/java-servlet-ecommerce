ALTER TABLE tb_user
RENAME COLUMN id TO user_id;

ALTER TABLE tb_role
RENAME COLUMN id TO role_id;

ALTER TABLE tb_address
    RENAME COLUMN id TO address_id;

ALTER TABLE tb_country
    RENAME COLUMN id TO country_id;