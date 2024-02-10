CREATE TABLE IF NOT EXISTS brothers (
    id uuid DEFAULT gen_random_uuid() PRIMARY KEY,
    name VARCHAR(255),
    nick_name VARCHAR(255),
    profile_url TEXT,
    created_at timestamp not null default now()
);

