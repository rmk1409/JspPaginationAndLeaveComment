DROP TABLE IF EXISTS msg_app;
DROP SEQUENCE IF EXISTS msg_app_id;

CREATE SEQUENCE msg_app_id;
CREATE TABLE IF NOT EXISTS "msg_app" (
  "id" integer PRIMARY KEY default nextval('msg_app_id'),
  "name" varchar(20) DEFAULT 'Anonym',
  "msg" varchar(100) DEFAULT NULL
);

INSERT into msg_app(name, msg) values ('Ivan', 'Msg1');
INSERT into msg_app(name, msg) values ('Max', 'Msg2');
INSERT into msg_app(name, msg) values ('Test', 'TestMsg');
INSERT into msg_app(name, msg) values ('Rmk', 'Msg4');
INSERT into msg_app(name, msg) values ('Alex', 'Msg5');
INSERT into msg_app(name, msg) values ('Marya', 'Msg6');
INSERT into msg_app(name, msg) values ('Sala', 'Msg7');
