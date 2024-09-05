CREATE TABLE IF NOT EXISTS tb_role (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS tb_user_role (
    user_id BIGINT REFERENCES tb_user(id),
    role_id BIGINT REFERENCES tb_role(id),

    PRIMARY KEY (user_id, role_id)
)