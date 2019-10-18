truncate jtech_session.session;
insert into jtech_session.session(initiate_time, is_active, last_time_active, receiver_id, sender_id)
values ('2019-10-01 20:05:12', true, '2019-10-17 20:05:12', 2, 1),
       ('2019-10-02 20:05:12', true, '2019-10-17 20:04:12', 3, 1),
       ('2019-10-03 20:05:12', true, '2019-10-17 20:02:12', 3, 2);
