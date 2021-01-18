-- liquibase formatted sql
-- changeset  ubaid:18Jan2021-2305
-- comment adding some random data in message table

INSERT INTO message(id, owner_id, received_time, seen_time, sent_time, session_id, text) VALUES (1, 1, '2019-10-18 20:03:12', '2019-10-18 20:02:12', '2019-10-18 20:01:12', 1, 'Hello');
INSERT INTO message(id, owner_id, received_time, seen_time, sent_time, session_id, text) VALUES (2, 2, '2019-10-18 20:06:12', '2019-10-18 20:05:12', '2019-10-18 20:04:12', 1, 'Hi');
INSERT INTO message(id, owner_id, received_time, seen_time, sent_time, session_id, text) VALUES (3, 1, '2019-10-18 20:09:12', '2019-10-18 20:08:12', '2019-10-18 20:07:12', 1, 'Are you good');
INSERT INTO message(id, owner_id, received_time, seen_time, sent_time, session_id, text) VALUES (4, 2, '2019-10-18 20:12:12', '2019-10-18 20:11:12', '2019-10-18 20:10:12', 1, 'I am fine');
INSERT INTO message(id, owner_id, received_time, seen_time, sent_time, session_id, text) VALUES (5, 1, '2019-10-18 20:15:12', '2019-10-18 20:14:12', '2019-10-18 20:13:12', 1, 'Alright');
INSERT INTO message(id, owner_id, received_time, seen_time, sent_time, session_id, text) VALUES (6, 1, null, null, '2019-10-19 03:39:14.861000000', 1, 'han bhai');
INSERT INTO message(id, owner_id, received_time, seen_time, sent_time, session_id, text) VALUES (7, 1, null, null, '2019-10-19 03:39:19.096000000', 1, 'kia hal hai');
INSERT INTO message(id, owner_id, received_time, seen_time, sent_time, session_id, text) VALUES (8, 1, null, null, '2019-10-19 03:39:25.901000000', 1, 'thek ho ');