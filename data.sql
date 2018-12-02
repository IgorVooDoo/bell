
insert into country_type (name, code) values ("Россия",643);
insert into country_type (name, code) values ("Канада",124);
insert into country_type (name, code) values ("Мадагаскар",261);
insert into country_type (name, code) values ("Камбоджа",116);
insert into country_type (name, code) values ("Нидерланды",528);
/*
id |name       |code |
---|-----------|-----|
1  |Россия     |643  |
2  |Канада     |124  |
3  |Мадагаскар |261  |
4  |Камбоджа   |116  |
5  |Нидерланды |528  |
*/

INSERT INTO doc_type (name, code) VALUES('Свидетельство о рождении', 03);
INSERT INTO doc_type (name, code) VALUES('Военный билет', 07);
INSERT INTO doc_type (name, code) VALUES('Паспорт иностранного гражданина', 10);
INSERT INTO doc_type (name, code) VALUES('Удостоверение беженца', 13);
INSERT INTO doc_type (name, code) VALUES('Паспорт гражданина Российской Федерации', 21);

/**
id |name                                    |code |
---|----------------------------------------|-----|
1  |Свидетельство о рождении                |3    |
2  |Военный билет                           |7    |
3  |Паспорт иностранного гражданина         |10   |
4  |Удостоверение беженца                   |13   |
5  |Паспорт гражданина Российской Федерации |21   |
*/

INSERT INTO organization (name, full_name, adress, phone, inn, kpp, is_active) 
VALUES('Java', 'Full Java', 'Saratoff', '9151212233', 121212122121212, 4545454545, 1);
INSERT INTO organization (name, full_name, adress, phone, inn, kpp, is_active) 
VALUES('Spring', 'Spring Boot', 'SpringCity', '9161214455', 1233333333312, 4577777745, 1);

/*
id |name   |full_name   |adress     |phone      |inn             |kpp        |is_active |
---|-------|------------|-----------|-----------|----------------|-----------|----------|
1  |Java   |Full Java   |Saratoff   |9151212233 |121212122121212 |4545454545 |1         |
2  |Spring |Spring Boot |SpringCity |9161214455 |1233333333312   |4577777745 |1         |
*/

INSERT INTO office (name, adress, phone, is_active, org_id) 
VALUES('Java Core', 'street1', '9189788877', 1, 1);

INSERT INTO office (name, adress, phone, is_active, org_id) 
VALUES('Java EE', 'street2', '9189755557', 1, 1);

INSERT INTO office (name, adress, phone, is_active, org_id) 
VALUES('Spring MVC', 'street2', '9189755567', 1, 2);

/*
id |name       |adress  |phone      |is_active |org_id |
---|-----------|--------|-----------|----------|-------|
1  |Java Core  |street1 |9189788877 |1         |1      |
2  |Java EE    |street2 |9189755557 |1         |1      |
3  |Spring MVC |street2 |9189755567 |1         |2      |
*/

INSERT INTO document (`type`, doc_number, doc_date) VALUES(1, 332333233, '2007-06-15');
INSERT INTO document (`type`, doc_number, doc_date) VALUES(5, 221212122, '2012-06-15');

/*
id |type |doc_number |doc_date   |
---|-----|-----------|-----------|
1  |1    |332333233  |2007-06-15 |
2  |5    |221212122  |2012-06-15 |
*/

INSERT INTO employee (first_name, last_name, middle_name, position, doc_id, citizenship_id, is_identified, office_id) 
VALUES('Шепелев', 'Игорь', 'Николаевич', 'e1', 2, 1, 1, 2);

INSERT INTO employee (first_name, last_name, middle_name, position, doc_id, citizenship_id, is_identified, office_id) 
VALUES('Пушкин', 'Александр', 'Сергеевич', 'e2', 1, 4, 1, 3);
/*
id |first_name |last_name |middle_name |position |doc_id |citizenship_id |is_identified |office_id |
---|-----------|----------|------------|---------|-------|---------------|--------------|----------|
6  |Шепелев    |Игорь     |Николаевич  |e1       |2      |1              |1             |2         |
7  |Пушкин     |Александр |Сергеевич   |e2       |1      |4              |1             |3         |
*/
