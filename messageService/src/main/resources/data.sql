truncate message;
insert into message(owner_id, receieved_time, seen_time, sent_time, session_id, text)
values (1, '2019-10-18 20:03:12', '2019-10-18 20:02:12', '2019-10-18 20:01:12', 1, 'Hello'),
       (2, '2019-10-18 20:06:12', '2019-10-18 20:05:12', '2019-10-18 20:04:12', 1, 'Hi'),
       (1, '2019-10-18 20:09:12', '2019-10-18 20:08:12', '2019-10-18 20:07:12', 1, 'Are you good'),
       (2, '2019-10-18 20:12:12', '2019-10-18 20:11:12', '2019-10-18 20:10:12', 1, 'I am fine'),
       (1, '2019-10-18 20:15:12', '2019-10-18 20:14:12', '2019-10-18 20:13:12', 1, 'Alright');