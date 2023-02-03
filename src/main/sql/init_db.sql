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

DROP TABLE IF EXISTS public.employee;
CREATE TABLE employee (
                          id int NOT NULL,
                          first_name varchar(20) DEFAULT NULL,
                          last_name varchar(20) DEFAULT NULL,
                          username varchar(250) DEFAULT NULL,
                          password varchar(20) DEFAULT NULL,
                          address varchar(45) DEFAULT NULL,
                          contact varchar(45) DEFAULT NULL,
                          PRIMARY KEY (id)
);
INSERT INTO employee (id,first_name, last_name,username,password,address,contact)
VALUES ('1','admin','admin','admin','123','misisipi kurła','0-700-880');

INSERT INTO supplier (name, description)
VALUES ('Brembo', 'Brakes parts'),
       ('FMIC', 'Tunning parts'),
       ('Bilstein', 'Suspension parts'),
       ('Sachs', 'Suspension parts'),
       ('Bilstein', 'Suspension parts'),
       ('Garrett Motion', 'Gasoline Turbochargers parts'),
       ('Akrapovic', 'Exhaust parts'),
       ('Bosch', 'Electronics parts');

INSERT INTO product_category (name, department, description)
VALUES ('Suspension', '1', 'Suspension parts'),
       ('Tunning', '1', 'Tunning parts'),
       ('Brakes', '2', 'Brakes parts'),
       ('Turbochargers', '2', 'Turbochargers parts'),
       ('Exhaust', '3', 'Exhaust parts'),
       ('Electronics', '3', 'Electronics parts');

INSERT INTO product (name, price, currency, description, product_category, supplier)
VALUES ('Brembo Pads', 100, 'USD',
        'Brembo brake pads represent the best in terms of performance, comfort and durability. They are available for over 6000 applications, with a wide variety of compounds: from organic resins to sintered and carbon-ceramic pads.', 1, 3),
       ('Bilstein EVO S', 2000, 'USD', ' BILSTEIN EVO S street performance suspension not only gives you the stance you want, it also gives you dynamic and sporty handling qualities – perfect for your everyday life and exactly your style.', 3, 1),
       ('Intercooler FMIC.PRO ', 1111, 'USD', 'Intercooler Fmic.Pro BMW EVO3 BMW E82 E90  Dedicated Intercooler FMIC.Pro is the latest product from our professional line of tuning air coolers. Its exceptional performance is due to its unique core, which combines two most important features: extreme cooling and maximum flow rates.', 4, 1),
       ('Garret Turbo GBC', 5352, 'USD', 'Club Line Turbochargers are calibrated with a 0.5 bar actuator. Actuators with higher pressure settings (1.0, 1.5 bar) are available for individual purchase.', 1, 3),
       ('Audi RS 3 Sedan (8Y) Exhaust', 1111, 'USD', 'This product is constructed with high-grade titanium tubes and a muffler, which are attached to the car’s stock downpipes with a high-quality stainless-steel link pipe and finished with handcrafted carbon-fibre tailpipes and a titanium inner sleeve', 2, 2),
       ('Bosch PFS 3000-2', 5352, 'USD', 'Paint with finely sprayed paint, glaze or varnish, providing excellent coverage, also on demanding wooden surfaces, in narrow and hard-to-reach places and where you need to hold the tool over your head. Enjoy freedom of movement thanks to the comfortable carrying strap that makes it easy to carry and operate the spray system', 3, 1)
;



ALTER TABLE ONLY public.product
    ADD CONSTRAINT fk_product_category_id FOREIGN KEY (product_category) REFERENCES product_category (id),
    ADD CONSTRAINT fk_supplier_id FOREIGN KEY (supplier) REFERENCES supplier (id);

ALTER TABLE ONLY public.product_category
    ADD CONSTRAINT fk_product_category_id FOREIGN KEY (id) REFERENCES product_category (id);

ALTER TABLE ONLY public.supplier
    ADD CONSTRAINT fk_supplier_id FOREIGN KEY (id) REFERENCES supplier (id);