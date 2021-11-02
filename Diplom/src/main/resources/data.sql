INSERT INTO setting (code, description, value) VALUES ('OUTPUT_DIR', 'Каталог для выгрузки сгенерированных файлов', 'd:\temp\generate');
INSERT INTO setting (code, description, value) VALUES ('GENERATE_REPO', 'Генерировать репозитории для каждой сущности, Да/Нет', 'Да');
INSERT INTO setting (code, description, value) VALUES ('PACKAGE_FOR_ENTITY', 'Пакет для генерируемых сущностей', 'ru.otus.gpbu.mygena.runtime.entity');

INSERT INTO entity (code, description) VALUES ('Entity1', 'EntityDescription1');
INSERT INTO entity (code, description) VALUES ('Entity2', 'EntityDescription2');
INSERT INTO entity (code, description) VALUES ('Entity3', 'EntityDescription3');

INSERT INTO entity_attr (code, description, type, entity_id) VALUES ('Attribute1', 'AttributeDescription1', 'String', 1);
INSERT INTO entity_attr (code, description, type, entity_id) VALUES ('Attribute2', 'AttributeDescription2', 'Long', 1);


INSERT INTO entity_attr (code, description, type, entity_id) VALUES ('Attribute3', 'AttributeDescription3', 'String', 2);
INSERT INTO entity_attr (code, description, type, entity_id) VALUES ('Attribute4', 'AttributeDescription4', 'Long', 2);
INSERT INTO entity_attr (code, description, type, entity_id) VALUES ('Attribute5', 'AttributeDescription4', 'String', 2);

INSERT INTO entity_attr (code, description, type, entity_id) VALUES ('Attribute6', 'AttributeDescription6', 'String', 3);
INSERT INTO entity_attr (code, description, type, entity_id) VALUES ('Attribute7', 'AttributeDescription7', 'Long', 3);
