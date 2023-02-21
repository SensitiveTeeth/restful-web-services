INSERT INTO user_details(id, birth_date, name) VALUES (10001, current_date(), 'test1')
INSERT INTO user_details(id, birth_date, name) VALUES (10002, current_date(), 'test2')
INSERT INTO user_details(id, birth_date, name) VALUES (10003, current_date(), 'test3')
INSERT INTO user_details(id, birth_date, name) VALUES (10004, current_date(), 'test4')
INSERT INTO user_details(id, birth_date, name) VALUES (10005, current_date(), 'test5')

INSERT INTO post(id,description,user_id) VALUES (20001, 'first post', 10001)
INSERT INTO post(id,description,user_id) VALUES (20002, 'second post', 10001)
INSERT INTO post(id,description,user_id) VALUES (20003, 'third post', 10002)