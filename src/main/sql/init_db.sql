ALTER TABLE IF EXISTS ONLY public.product
    DROP CONSTRAINT IF EXISTS fk_product_category_id CASCADE,
    DROP CONSTRAINT IF EXISTS fk_supplier_id CASCADE;

ALTER TABLE IF EXISTS ONLY public.product_category
    DROP CONSTRAINT IF EXISTS fk_product_category_id CASCADE;

ALTER TABLE IF EXISTS ONLY public.supplier
    DROP CONSTRAINT IF EXISTS fk_supplier_id CASCADE;


DROP TABLE IF EXISTS public.product;
CREATE TABLE public.product
(

    id               serial NOT NULL PRIMARY KEY,
    name             text,
    description      text,
    price            float,
    currency         text,
    product_category int,
    supplier         int
);


DROP TABLE IF EXISTS public.product_category;
CREATE TABLE public.product_category
(
    id          serial NOT NULL PRIMARY KEY,
    name        text,
    department  text,
    description text
);

DROP TABLE IF EXISTS public.supplier;
CREATE TABLE public.supplier
(
    id          serial NOT NULL PRIMARY KEY,
    name        text,
    description text
);

DROP TABLE IF EXISTS public.users;
CREATE TABLE public.users
(

    username        char,
    password        char,
    emailadress     char
);

INSERT INTO users (name, password,email)
VALUES ('admin', '123','admin@admin.com')
      ;

INSERT INTO supplier (name, description)
VALUES ('fajny1', 'opis'),
       ('fajny2', 'opis'),
       ('fajny3', 'opis'),
       ('fajny4', 'opis');

INSERT INTO product_category (name, department, description)
VALUES ('cat1', '1', 'opis'),
       ('cat6', '1', 'opis'),
       ('cat2', '2', 'opis'),
       ('cat3', '2', 'opis'),
       ('cat4', '3', 'opis'),
       ('cat5', '3', 'opis');

INSERT INTO product (name, price, currency, description, product_category, supplier)
VALUES ('produkt1', 5330, 'USD',
        'opis', 1, 3),
       ('produkt2', 2222, 'USD', 'opis"', 3, 1),
       ('produkt3', 1111, 'USD', 'opis', 4, 1),
       ('produkt4', 5352, 'USD', 'opis', 1, 3),
       ('produkt5', 1111, 'USD', 'opis', 2, 2),
       ('produkt6', 5352, 'USD', 'opis', 3, 1)
;



ALTER TABLE ONLY public.product
    ADD CONSTRAINT fk_product_category_id FOREIGN KEY (product_category) REFERENCES product_category (id),
    ADD CONSTRAINT fk_supplier_id FOREIGN KEY (supplier) REFERENCES supplier (id);

ALTER TABLE ONLY public.product_category
    ADD CONSTRAINT fk_product_category_id FOREIGN KEY (id) REFERENCES product_category (id);

ALTER TABLE ONLY public.supplier
    ADD CONSTRAINT fk_supplier_id FOREIGN KEY (id) REFERENCES supplier (id);