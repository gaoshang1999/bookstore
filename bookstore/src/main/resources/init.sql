

INSERT INTO user (username, role,  firstName, lastName, password,address, phone, zipcode, created, updated) VALUES ('admin', 0, 'admin', 'admin', '$2a$10$2f0EGxg500UFbQZ5VCNx4uhi8KkAY7lAKGAxORTnjztC4m5w0FEM6', 'test', '1234', '222', NOW(), NOW());

INSERT INTO user (username, role,  firstName, lastName, password,address, phone, zipcode, created, updated) VALUES ('gs', 1, 'Shang', 'Gao', '$2a$10$2f0EGxg500UFbQZ5VCNx4uhi8KkAY7lAKGAxORTnjztC4m5w0FEM6', 'test', '1234', '222', NOW(), NOW());

INSERT INTO category(name,description) VALUES('Sports','Sports books are very interesting and informative! You can learn different rules and regulations about sports.')
INSERT INTO category(name,description) VALUES('Computer','Computer boos are very effective for knowing and career! You can be an expert by following the rules and practising regularly.')
INSERT INTO category(name,description) VALUES('History','History books are very informative! You make a bridge between eras through history.')