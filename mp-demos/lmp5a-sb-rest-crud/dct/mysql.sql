create database domdb;
use domdb;
SELECT * FROM PRODUCTS;
SELECT * FROM hibernate_sequence;

INSERT INTO PRODUCTS VALUES(0,"SWW",500);
DROP TABLE PRODUCTS;
-- OPTIONAL
    create table products (
        product_id bigint not null,
        product_name varchar(255) not null,
        price float not null,
        primary key (product_id)
    )
