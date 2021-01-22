create table user(
    id INT auto_increment,
    user_id VARCHAR(10) UNIQUE NOT NULL,
    user_name VARCHAR(10) UNIQUE NOT NULL,
    email_address VARCHAR(40) UNIQUE NOT NULL,
    password VARCHAR(40) UNIQUE NOT NULL,
    created_at DATE NOT NULL,
    updated_at DATE NOT NULL,
    PRIMARY KEY(id)
);