/*MariaDB 10.3*/

CREATE TABLE IF NOT EXISTS Doc_type (
    code    INT NOT NULL COMMENT 'Числовой код документа; Уникальный идентификатор;',
    name    VARCHAR(45) NOT NULL COMMENT 'Наименование вида документа;',
    PRIMARY KEY (code)
) COMMENT = 'Перечень документов удостоверяющих личность.';

/*Document - таблица документов работников*/
CREATE TABLE IF NOT EXISTS Document (
  id INT NOT NULL AUTO_INCREMENT COMMENT 'Уникальный идентификатор',
  type INT NOT NULL COMMENT 'Ссылка на атрибут code в таблице Doc_type',
  doc_number INT NOT NULL COMMENT 'Номер документа',
  doc_date DATE NOT NULL COMMENT 'Дата выдачи документа',
  PRIMARY KEY (id),
  KEY FK__doc_type (type),
  CONSTRAINT FK__doc_type FOREIGN KEY (type) REFERENCES doc_type (code)
) COMMENT = 'Таблица документов работников';

create index Ix_number_doc on Document(doc_number);


/*Organization - таблица организаций*/
CREATE TABLE IF NOT EXISTS Organization (
  id INT NOT NULL AUTO_INCREMENT COMMENT 'Уникальный идентификатор',
  name VARCHAR(20) NOT NULL COMMENT 'Краткое наименование организации',
  full_name VARCHAR(45) NOT NULL COMMENT 'Полное наименование организации',
  address VARCHAR(100) NOT NULL COMMENT 'Юридический адрес',
  phone VARCHAR(20) COMMENT 'Номер телефона',
  inn BIGINT NOT NULL COMMENT 'ИНН',
  kpp BIGINT NOT NULL COMMENT 'КПП',
  is_active BOOLEAN COMMENT 'Актуальность',
  PRIMARY KEY (id)
) COMMENT = 'Таблица организаций';

create index Ix_name_org on Organization(name);
create index Ix_inn_org on Organization(inn);

/*Office - офисы организаций*/
CREATE TABLE IF NOT EXISTS Office (
  id INT NOT NULL AUTO_INCREMENT COMMENT 'Уникальный идентификатор',
  name VARCHAR(45) NOT NULL COMMENT 'Наименование офиса',
  address VARCHAR(100) NOT NULL COMMENT 'Адрес расположения офиса',
  phone VARCHAR(45) COMMENT 'Номер телефона в данном офисе',
  is_active BOOLEAN COMMENT 'Актуальность',
  org_id INT COMMENT 'Ссылка на организацию, к которой принадлежит офис',
  PRIMARY KEY (id),
  KEY office_organization_fk (org_id),
  CONSTRAINT office_organization_fk FOREIGN KEY (org_id) REFERENCES organization (id)
) COMMENT = 'Офисы организации';

create index Ix_name_ofc on Office(name);

/*Country_type - справочная таблица с перечнем стран*/
CREATE TABLE IF NOT EXISTS Country_type (
    code    INT NOT NULL COMMENT 'Числовой код страны; Уникальный идентификатор',
    name    VARCHAR(45) NOT NULL COMMENT 'Наименование страны',
    PRIMARY KEY (code)
) COMMENT = 'Cправочная таблица с перечнем стран';

/*Employee - таблица сотрудников*/
CREATE TABLE IF NOT EXISTS Employee (
  id INT NOT NULL AUTO_INCREMENT COMMENT 'Уникальный идентификатор',
  first_name VARCHAR(45) NOT NULL COMMENT 'Имя',
  last_name VARCHAR(45) COMMENT 'Фамилия',
  middle_name VARCHAR(45) COMMENT 'Отчество',
  position VARCHAR(45) NOT NULL COMMENT 'Должность',
  phone VARCHAR(45) COMMENT 'Номер телефона',
  doc_id INT COMMENT 'Ссылка на id документа работника в таблице Document',
  citizenship_id INT COMMENT 'Ссылка на id страны в таблице Country_type',
  is_identified INT COMMENT '',
  office_id INT COMMENT 'Ссылка на id офиса в таблице Office',
  PRIMARY KEY (id),
  KEY employee_document_fk (doc_id),
  CONSTRAINT employee_document_fk FOREIGN KEY (doc_id) REFERENCES document (id) ON DELETE CASCADE,
  KEY employee_office_fk (office_id),
  CONSTRAINT employee_office_fk FOREIGN KEY (office_id) REFERENCES office (id),
  KEY employee_country_type_fk (citizenship_id),
  CONSTRAINT employee_country_type_fk FOREIGN KEY (citizenship_id) REFERENCES country_type (code)
) COMMENT = 'Таблица сотрудников';

create index Ix_name_emp on Employee(last_name);


