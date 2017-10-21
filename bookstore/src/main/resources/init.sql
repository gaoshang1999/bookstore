

INSERT INTO user (username, role,  firstName, lastName, password,address, phone, zipcode, created, updated) VALUES ('admin', 0, 'admin', 'admin', '$2a$10$2f0EGxg500UFbQZ5VCNx4uhi8KkAY7lAKGAxORTnjztC4m5w0FEM6', 'test', '1234', '222', NOW(), NOW());

INSERT INTO user (username, role,  firstName, lastName, password,address, phone, zipcode, created, updated) VALUES ('gs', 1, 'Shang', 'Gao', '$2a$10$2f0EGxg500UFbQZ5VCNx4uhi8KkAY7lAKGAxORTnjztC4m5w0FEM6', 'test', '1234', '222', NOW(), NOW());

INSERT INTO category(name,description) VALUES('Sports','Sports books are very interesting and informative! You can learn different rules and regulations about sports.')
INSERT INTO category(name,description) VALUES('Computer','Computer boos are very effective for knowing and career! You can be an expert by following the rules and practising regularly.')
INSERT INTO category(name,description) VALUES('History','History books are very informative! You make a bridge between eras through history.')

INSERT INTO book(title,description,price,categoryId, imagePath) VALUES('Java Book','History books are very informative! You make a bridge between eras through history.',40,2, "/images/1.png")
INSERT INTO book(title,description,price,categoryId, imagePath) VALUES('C# Book','History books are very informative! You make a bridge between eras through history.',40,2, "/images/2.png")
INSERT INTO book(title,description,price,categoryId, imagePath) VALUES('Modern History','History books are very informative! You make a bridge between eras through history.',40,3, "/images/3.png")
INSERT INTO book(title,description,price,categoryId, imagePath) VALUES('Messi Magic in Football','History books are very informative! You make a bridge between eras through history.',40,1, "/images/4.png")
INSERT INTO book(title,description,price,categoryId, imagePath) VALUES('Spring MVC and Microservices','History books are very informative! You make a bridge between eras through history.',40,2, "/images/5.png")
INSERT INTO book(title,description,price,categoryId, imagePath) VALUES('Embedded Networking','History books are very informative! You make a bridge between eras through history.',40,2, "/images/6.png")