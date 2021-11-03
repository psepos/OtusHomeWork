INSERT INTO setting (code, description, value) VALUES ('GENERATOR.GENERATE_REPO', 'Gen to the repository for every entity', 'Yes');
INSERT INTO setting (code, description, value) VALUES ('GENERATOR.PACKAGE.FOR_ENTITY', 'Java package for entity', 'ru.otus.gpbu.mygena.runtime.entity');
INSERT INTO setting (code, description, value) VALUES ('GENERATOR.OUTPUT_DIR', 'Destination path', 'd:\temp\generate');

INSERT INTO setting (code, description, value) VALUES ('RUNTIME.ENVIRONMENT.TEMPLATE_FILE', '', 'runtime.zip');
INSERT INTO setting (code, description, value) VALUES ('RUNTIME.ENVIRONMENT.TEMPLATE_FILE_PATH', '', 'BOOT-INF/classes/');
INSERT INTO setting (code, description, value) VALUES ('RUNTIME.ENVIRONMENT.ARTIFACT_FILE_NAME', '', 'runtime-0.0.1-SNAPSHOT.jar');
INSERT INTO setting (code, description, value) VALUES ('RUNTIME.ENVIRONMENT.COMPILE_LOG', '', 'compile.log');

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
