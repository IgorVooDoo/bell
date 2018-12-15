
insert into country_type (name, code) values ('Россия',643);
insert into country_type (name, code) values ('Канада',124);
insert into country_type (name, code) values ('Мадагаскар',261);
insert into country_type (name, code) values ('Камбоджа',116);
insert into country_type (name, code) values ('Нидерланды',528);

INSERT INTO doc_type (name, code) VALUES('Свидетельство о рождении', 03);
INSERT INTO doc_type (name, code) VALUES('Военный билет', 07);
INSERT INTO doc_type (name, code) VALUES('Паспорт иностранного гражданина', 10);
INSERT INTO doc_type (name, code) VALUES('Удостоверение беженца', 13);
INSERT INTO doc_type (name, code) VALUES('Паспорт гражданина Российской Федерации', 21);

INSERT INTO organization (name, full_name, address, phone, inn, kpp, is_active) 
VALUES('Java', 'Full Java', 'Saratoff', '9151212233', 121212122121212, 4545454545, 1);
INSERT INTO organization (name, full_name, address, phone, inn, kpp, is_active) 
VALUES('Spring', 'Spring Boot', 'SpringCity', '9161214455', 1233333333312, 4577777745, 1);

INSERT INTO office (name, address, phone, is_active, org_id) 
VALUES('Java Core', 'street1', '9189788877', 1, 1);

INSERT INTO office (name, address, phone, is_active, org_id) 
VALUES('Java EE', 'street2', '9189755557', 1, 1);

INSERT INTO office (name, address, phone, is_active, org_id) 
VALUES('Spring MVC', 'street2', '9189755567', 1, 2);

INSERT INTO document (`type`, doc_number, doc_date) VALUES(13, 332333233, '2007-06-15');
INSERT INTO document (`type`, doc_number, doc_date) VALUES(21, 221212122, '2012-06-15');

INSERT INTO employee (first_name, last_name, middle_name, position, phone, doc_id, citizenship_id, is_identified, office_id) 
VALUES('Шепелев', 'Игорь', 'Николаевич', 'e1', '65676756756', 2, 643, 1, 2);

INSERT INTO employee (first_name, last_name, middle_name, position, phone, doc_id, citizenship_id, is_identified, office_id) 
VALUES('Пушкин', 'Александр', 'Сергеевич', 'e2', '5484545646546', 1, 116, 1, 3);
