CREATE TABLE transaction_detail (
	id VARCHAR(256) PRIMARY KEY,
    user_id VARCHAR(256) NOT NULL,
    counter_party_id VARCHAR(256) NOT NULL,
    counter_party_name VARCHAR(256),
    type VARCHAR(20) NOT NULL,
    status VARCHAR(20) NOT NULL,
    description VARCHAR(256),
    amount BIGINT NOT NULL,
    currency VARCHAR(20) NOT NULL,
    updated_balance BIGINT NOT NULL,
    date_time TIMESTAMP NOT NULL
	);

CREATE TABLE user_info (
	id VARCHAR(255) PRIMARY KEY,
	name VARCHAR(255) NOT NULL,
	email_id VARCHAR(255) NOT NULL
);
