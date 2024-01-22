CREATE TABLE IF NOT EXISTS brothers (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    created_at timestamp not null default now()
);
