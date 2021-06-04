CREATE TABLE transaction_detail (
	id VARCHAR(256) PRIMARY KEY,
    user_id VARCHAR(256),
    counter_party_id VARCHAR(256),
    counter_party_name VARCHAR(256),
    type VARCHAR(256),
    status VARCHAR(256),
    description VARCHAR(256),
    amount BIGINT,
    currency VARCHAR(256),
    updatedBalance BIGINT,
    dateTime BIGINT
	);

CREATE TABLE user_info (
	id VARCHAR(255) PRIMARY KEY,
	name VARCHAR(255),
	email_id VARCHAR(255)
);
