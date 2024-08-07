CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS post (
    uuid uuid not null,
    userId uuid not null,
    header text not null,
    body text not null,
    created_at timestamp default now() not null,
    updated_at timestamp default now() not null,
    deleted_at timestamp,
    primary key (uuid)
);
