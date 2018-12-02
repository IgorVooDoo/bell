/*MariaDB 10.3*/

/*
Doc_type  - справочная таблица с перечнем видов 
            документов документов удостоверяющих
            личность.
*/
CREATE TABLE IF NOT EXISTS Doc_type (
    id      INT NOT NULL AUTO_INCREMENT, /*Уникальный идентификатор;*/
    name    VARCHAR(45) NOT NULL,/*Наименование вида документа;*/
    code    INT NOT NULL,/*Числовой код документа;*/
    PRIMARY KEY (id)
);

/*Document - таблица документов работников*/
CREATE TABLE IF NOT EXISTS Document (
  id INT NOT NULL AUTO_INCREMENT,/*Уникальный идентификатор*/
  type INT NOT NULL,/*Ссылка на атрибут id в таблице Doc_type*/
  doc_number INT NOT NULL,/*Номер документа*/
  doc_date DATE NOT NULL,/*Дата выдачи документа*/
  PRIMARY KEY (id),
  KEY FK__doc_type (type),
  CONSTRAINT FK__doc_type FOREIGN KEY (type) REFERENCES doc_type (id)
);
/*Country_type - справочная таблица с перечнем стран*/
CREATE TABLE IF NOT EXISTS Country_type (
    id      INT NOT NULL AUTO_INCREMENT,/*Уникальный идентификатор*/
    name    VARCHAR(45) NOT NULL,/*Наименование страны*/
    code    INT NOT NULL,/*Числовой код страны*/
    PRIMARY KEY (id)
);

/*Organization - таблица организаций*/
CREATE TABLE IF NOT EXISTS Organization (
  id INT NOT NULL AUTO_INCREMENT,/*Уникальный идентификатор*/
  name VARCHAR(20) NOT NULL,/*Краткое наименование организации*/
  full_name VARCHAR(45) NOT NULL,/*Полное наименование организации*/
  adress VARCHAR(100) NOT NULL,/*Юридический адрес*/
  phone VARCHAR(20) NOT NULL,/*Номер телефона*/
  inn BIGINT NOT NULL,/*ИНН*/
  kpp BIGINT NOT NULL,/*КПП*/
  is_active BOOLEAN NOT NULL,/*Актуальность*/
  PRIMARY KEY (id)
);

/*Office - офисы организаций*/
CREATE TABLE IF NOT EXISTS Office (
  id INT NOT NULL AUTO_INCREMENT,/*Уникальный идентификатор*/
  name VARCHAR(45) NOT NULL,/*Наименование офиса*/
  adress VARCHAR(100) NOT NULL,/*Адрес расположения офиса*/
  phone VARCHAR(45) NOT NULL,/*Номер телефона в данном офисе*/
  is_active BOOLEAN NOT NULL,/*Актуальность*/
  org_id INT NOT NULL,/*Ссылка на организацию, к которой принадлежит офис*/
  PRIMARY KEY (id),
  KEY office_organization_fk (org_id),
  CONSTRAINT office_organization_fk FOREIGN KEY (org_id) REFERENCES organization (id)
);

/*Employee - таблица работников*/
CREATE TABLE IF NOT EXISTS Employee (
  id INT NOT NULL AUTO_INCREMENT,/*Уникальный идентификатор*/
  first_name VARCHAR(45) NOT NULL,/*Имя*/
  last_name VARCHAR(45) NOT NULL,/*Фамилия*/
  middle_name VARCHAR(45) NOT NULL,/*Отчество*/
  position VARCHAR(45) NOT NULL,/*Должность*/
  doc_id INT NOT NULL,/*Ссылка на id документа работника в таблице Document*/
  citizenship_id INT NOT NULL,/*Ссылка на id страны в таблице Country_type*/
  is_identified INT NOT NULL,/**/
  office_id INT NOT NULL,/*Ссылка на id офиса в таблице Office*/
  PRIMARY KEY (id),
  KEY employee_document_fk (doc_id),
  CONSTRAINT employee_document_fk FOREIGN KEY (doc_id) REFERENCES document (id),
  KEY employee_office_fk (office_id),
  CONSTRAINT employee_office_fk FOREIGN KEY (office_id) REFERENCES office (id),
  KEY employee_country_type_fk (citizenship_id),
  CONSTRAINT employee_country_type_fk FOREIGN KEY (citizenship_id) REFERENCES country_type (id)
  
);


