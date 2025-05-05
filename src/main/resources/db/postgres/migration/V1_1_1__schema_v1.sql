CREATE TABLE IF NOT EXISTS brothers (
    id uuid DEFAULT gen_random_uuid() PRIMARY KEY,
    name VARCHAR(255),
    nick_name VARCHAR(255),
    profile_url TEXT,
    created_at timestamp not null default now()
);

CREATE TABLE IF NOT EXISTS CUSTOMERS (
    id uuid DEFAULT gen_random_uuid() PRIMARY KEY,
    name VARCHAR(255),
    nick_name VARCHAR(255),
    profile_url TEXT,
    created_at timestamp not null default now()
);

CREATE TABLE IF NOT EXISTS WALLETS (
    id uuid DEFAULT gen_random_uuid() PRIMARY KEY,
    name VARCHAR(255),
    customer_id uuid not null,
    profile_url TEXT,
    created_at timestamp not null default now(),
    foreign key (customer_id) references CUSTOMERS(id)
);

CREATE TABLE IF NOT EXISTS ORDERS (
    id uuid DEFAULT gen_random_uuid() PRIMARY KEY,
    wallet_id uuid not null,
    paper_code varchar(10) not null,
    unit_price double precision not null,
    total_amount double precision not null,
    quantity double precision not null,
    created_at timestamp not null default now(),
    foreign key (wallet_id) references WALLETS(id)
);
