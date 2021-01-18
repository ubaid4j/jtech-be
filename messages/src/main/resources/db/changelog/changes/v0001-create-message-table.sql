-- liquibase formatted sql
-- changeset  ubaid:18Jan2021-2305
-- comment creating message table

create table message (
    id bigint primary key,
    session_id bigint,
    text varchar(255),
    sent_time timestamp,
    received_time timestamp,
    seen_time timestamp,
    owner_id bigint,
    port int
)