-- changeset nomad:1
-- Таблица пользователей
CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,
    email VARCHAR(255) NOT NULL UNIQUE,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    phone VARCHAR(20),
    role VARCHAR(20) NOT NULL,
    image VARCHAR(255),
    password VARCHAR(255) NOT NULL,
    enabled BOOLEAN NOT NULL
);

-- changeset nomad:2
-- Таблица объявлений (items)
CREATE TABLE items (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(64) NOT NULL,
    description VARCHAR(256),
    price INT NOT NULL,
    image VARCHAR(255),
    user_id BIGINT NOT NULL,
    CONSTRAINT fk_items_user FOREIGN KEY (user_id) REFERENCES users (id)
);

-- changeset nomad:3
-- Таблица комментариев
CREATE TABLE comments (
    id BIGSERIAL PRIMARY KEY,
    text VARCHAR(256) NOT NULL,
    ad_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    created_at TIMESTAMP,
    CONSTRAINT fk_comments_ad FOREIGN KEY (ad_id) REFERENCES items (id),
    CONSTRAINT fk_comments_user FOREIGN KEY (user_id) REFERENCES users (id)
);
