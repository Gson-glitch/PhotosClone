-- CREATE TABLE IF NOT EXISTS photoz {
--    id BIGINT IDENTITY PRIMARY KEY,
--    file_name VARCHAR(255),
--    content_type VARCHAR(255),
--    data BINARY
-- }

--drop table photoz;

create table if not exists photoz (
    id int primary key not null auto_increment,
    file_name varchar(255),
    content_type varchar(255),
    data binary large object
);