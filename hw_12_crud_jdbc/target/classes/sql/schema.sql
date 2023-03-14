CREATE TABLE pets (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    pet_type VARCHAR(255) NOT NULL
);

CREATE TABLE owners (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255) NULL,
    last_name VARCHAR(255) NULL,
    email VARCHAR(255) NULL,
    phone VARCHAR(50) NULL,
    created DATETIME(6) NULL,
    updated DATETIME(6) NULL
);

CREATE TABLE pet_own (
    pet_id BIGINT NOT NULL,
    own_id BIGINT NOT NULL,
    PRIMARY KEY (pet_id , own_id),
    FOREIGN KEY (pet_id)
        REFERENCES pets (id),
    FOREIGN KEY (own_id)
        REFERENCES owners (id)
);
