INSERT INTO setting (code, description, value) VALUES ('GENERATOR.GENERATE_REPOSITORIES', 'Gen to the repository for every entity', 'YES');
INSERT INTO setting (code, description, value) VALUES ('GENERATOR.GENERATE_ENTITIES', 'Gen to the repository for every entity', 'YES');
INSERT INTO setting (code, description, value) VALUES ('GENERATOR.PACKAGE.ROOT_NAME', 'Java package', 'ru.otus.gpbu.moon.domain');
INSERT INTO setting (code, description, value) VALUES ('GENERATOR.PACKAGE.SHELL_COMMANDS_NAME', 'Java package for shell commands', 'ru.otus.gpbu.moon.shell');
INSERT INTO setting (code, description, value) VALUES ('GENERATOR.OUTPUT_DIR', 'Destination path', 'd:\MoonRuntime\');

INSERT INTO setting (code, description, value) VALUES ('GENERATOR.JOB.CHUNK_SIZE', 'Chunk size for job generate', '5');
INSERT INTO setting (code, description, value) VALUES ('GENERATOR.JOB.JPA_PAGING_ITEM_READER.PAGE_SIZE', 'Page size for JpaPagingItemReader', '10');
INSERT INTO setting (code, description, value) VALUES ('GENERATOR.JOB.JPA_PAGING_ITEM_READER.QUERY_STRING', 'QUERY STRING for JpaPagingItemReader', 'SELECT e FROM MyEntity e');
INSERT INTO setting (code, description, value) VALUES ('GENERATOR.REST_API_PREFIX', 'Prefix for generate rest api', '/api/v1/entities');

INSERT INTO setting (code, description, value) VALUES ('ADMIN_SERVER.HOME_DIR', 'Path', 'd:\AdminServer\');
INSERT INTO setting (code, description, value) VALUES ('ADMIN_SERVER.JAR_NAME', '', 'AdminServer.jar');
INSERT INTO setting (code, description, value) VALUES ('ADMIN_SERVER.TEMPLATE_SOURCE', '', 'BOOT-INF/classes/');
INSERT INTO setting (code, description, value) VALUES ('ADMIN_SERVER.URL', '', 'http://localhost:8081/');

INSERT INTO setting (code, description, value) VALUES ('RUNTIME.ENVIRONMENT.TEMPLATE_FILE', '', 'runtime.zip');
INSERT INTO setting (code, description, value) VALUES ('RUNTIME.ENVIRONMENT.TEMPLATE_FILE_PATH', '', 'BOOT-INF/classes/');
INSERT INTO setting (code, description, value) VALUES ('RUNTIME.ENVIRONMENT.ARTIFACT_FILE_NAME', '', 'moon-1.jar');
INSERT INTO setting (code, description, value) VALUES ('RUNTIME.ENVIRONMENT.COMPILE.LOG_FILE', '', 'compile.log');
INSERT INTO setting (code, description, value) VALUES ('RUNTIME.ENVIRONMENT.COMPILE.MAVEN_SKIP_TESTS', '', 'YES');
INSERT INTO setting (code, description, value) VALUES ('RUNTIME.ENVIRONMENT.COMPILE.MAVEN_BUILD_OPTIONS', '', 'clean package -T 1C -o -am');

INSERT INTO entity (code, description) VALUES ('Person', 'Person description');
INSERT INTO entity (code, description) VALUES ('Customer', 'Customer description');
INSERT INTO entity (code, description) VALUES ('Loan', 'Loan description');
INSERT INTO entity (code, description) VALUES ('Signs', 'Signs description');

INSERT INTO entity_attr (code, description, type, entity_id) VALUES ('firstName', 'Firstname', 'String', 1);
INSERT INTO entity_attr (code, description, type, entity_id) VALUES ('lastName', 'Lastname', 'String', 1);
INSERT INTO entity_attr (code, description, type, entity_id) VALUES ('age', 'AttributeDescription2', 'Long', 1);

INSERT INTO entity_attr (code, description, type, entity_id) VALUES ('systemId', 'System id', 'Long', 2);
INSERT INTO entity_attr (code, description, type, entity_id) VALUES ('name', 'Customer name', 'Long', 2);
INSERT INTO entity_attr (code, description, type, entity_id) VALUES ('inn', 'Customer inn', 'String', 2);

INSERT INTO entity_attr (code, description, type, entity_id) VALUES ('code', 'Loan code', 'String', 3);
INSERT INTO entity_attr (code, description, type, entity_id) VALUES ('description', 'Loan desc', 'String', 3);

INSERT INTO entity_attr (code, description, type, entity_id) VALUES ('code', 'Loan code', 'String', 4);