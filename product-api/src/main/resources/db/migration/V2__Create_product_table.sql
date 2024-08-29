create table products.product (
    id bigserial primary key,
    name varchar(100) not null,
    price float not null,
    description varchar(65535),
    category_id bigint REFERENCES products.category(id)
);