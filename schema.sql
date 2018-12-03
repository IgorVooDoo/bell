/*MariaDB 10.3*/

CREATE TABLE IF NOT EXISTS Doc_type (
    id      INT NOT NULL AUTO_INCREMENT COMMENT 'Уникальный идентификатор;',
    name    VARCHAR(45) NOT NULL COMMENT 'Наименование вида документа;',
    code    INT NOT NULL COMMENT 'Числовой код документа;',
    PRIMARY KEY (id)
) COMMENT = 'Перечень документов удостоверяющих личность.';

/*Document - таблица документов работников*/
CREATE TABLE IF NOT EXISTS Document (
  id INT NOT NULL AUTO_INCREMENT COMMENT 'Уникальный идентификатор',
  type INT NOT NULL COMMENT 'Ссылка на атрибут id в таблице Doc_type',
  doc_number INT NOT NULL COMMENT 'Номер документа',
  doc_date DATE NOT NULL COMMENT 'Дата выдачи документа',
  PRIMARY KEY (id),
  KEY FK__doc_type (type),
  CONSTRAINT FK__doc_type FOREIGN KEY (type) REFERENCES doc_type (id)
) COMMENT = 'Таблица документов работников';

/*Country_type - справочная таблица с перечнем стран*/
CREATE TABLE IF NOT EXISTS Country_type (
    id      INT NOT NULL AUTO_INCREMENT COMMENT 'Уникальный идентификатор',
    name    VARCHAR(45) NOT NULL COMMENT 'Наименование страны',
    code    INT NOT NULL COMMENT 'Числовой код страны',
    PRIMARY KEY (id)
) COMMENT = 'Cправочная таблица с перечнем стран';

/*Organization - таблица организаций*/
CREATE TABLE IF NOT EXISTS Organization (
  id INT NOT NULL AUTO_INCREMENT COMMENT 'Уникальный идентификатор',
  name VARCHAR(20) NOT NULL COMMENT 'Краткое наименование организации',
  full_name VARCHAR(45) NOT NULL COMMENT 'Полное наименование организации',
  adress VARCHAR(100) NOT NULL COMMENT 'Юридический адрес',
  phone VARCHAR(20) NOT NULL COMMENT 'Номер телефона',
  inn BIGINT NOT NULL COMMENT 'ИНН',
  kpp BIGINT NOT NULL COMMENT 'КПП',
  is_active BOOLEAN NOT NULL COMMENT 'Актуальность',
  PRIMARY KEY (id)
) COMMENT = 'Таблица организаций';

/*Office - офисы организаций*/
CREATE TABLE IF NOT EXISTS Office (
  id INT NOT NULL AUTO_INCREMENT COMMENT 'Уникальный идентификатор',
  name VARCHAR(45) NOT NULL COMMENT 'Наименование офиса',
  adress VARCHAR(100) NOT NULL COMMENT 'Адрес расположения офиса',
  phone VARCHAR(45) NOT NULL COMMENT 'Номер телефона в данном офисе',
  is_active BOOLEAN NOT NULL COMMENT 'Актуальность',
  org_id INT NOT NULL COMMENT 'Ссылка на организацию, к которой принадлежит офис',
  PRIMARY KEY (id),
  KEY office_organization_fk (org_id),
  CONSTRAINT office_organization_fk FOREIGN KEY (org_id) REFERENCES organization (id)
) COMMENT = 'Офисы организации';

/*Employee - таблица сотрудников*/
CREATE TABLE IF NOT EXISTS Employee (
  id INT NOT NULL AUTO_INCREMENT COMMENT 'Уникальный идентификатор',
  first_name VARCHAR(45) NOT NULL COMMENT 'Имя',
  last_name VARCHAR(45) NOT NULL COMMENT 'Фамилия',
  middle_name VARCHAR(45) NOT NULL COMMENT 'Отчество',
  position VARCHAR(45) NOT NULL COMMENT 'Должность',
  doc_id INT NOT NULL COMMENT 'Ссылка на id документа работника в таблице Document',
  citizenship_id INT NOT NULL COMMENT 'Ссылка на id страны в таблице Country_type',
  is_identified INT NOT NULL COMMENT '',
  office_id INT NOT NULL COMMENT 'Ссылка на id офиса в таблице Office',
  PRIMARY KEY (id),
  KEY employee_document_fk (doc_id),
  CONSTRAINT employee_document_fk FOREIGN KEY (doc_id) REFERENCES document (id),
  KEY employee_office_fk (office_id),
  CONSTRAINT employee_office_fk FOREIGN KEY (office_id) REFERENCES office (id),
  KEY employee_country_type_fk (citizenship_id),
  CONSTRAINT employee_country_type_fk FOREIGN KEY (citizenship_id) REFERENCES country_type (id)
) COMMENT = 'Таблица сотрудников';


