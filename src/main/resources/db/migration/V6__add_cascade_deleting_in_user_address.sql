-- DROP CONSTRAINT
ALTER TABLE tb_user_address
DROP CONSTRAINT tb_user_address_user_id_fkey;

-- ADD NEW CASCADE DELETING
ALTER TABLE tb_user_address
ADD CONSTRAINT fk_user
FOREIGN KEY (user_id) REFERENCES tb_user(user_id) ON DELETE CASCADE;