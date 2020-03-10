insert into users (user_id, user_type, name, last_name, gender, cellphone, email, password, birth_date, registration_date) values (1000, 2, 'User1', 'User1', 'Masculino', '123456789', 'user1@email.com', '$2a$10$bK48sgKQLdE6DjLS7tKYF.s90DOoikdab50yc7tvq59/SBDC9NVNO', '1990-03-23', '2020-03-01 13:21:39.413');

insert into categories (category_id, name, description) values (1, 'Marvel', 'Heroes del Marvel Universe');
insert into categories (category_id, name, description) values (2, 'DC Comics', 'Heroes de DC Comics');
insert into categories (category_id, name, description) values (3, 'Otros', 'Heroes de la comunidad');

insert into types (type_id, name, description) values (1, 'Comics', 'Comics de tus heroies favoritos');
insert into types (type_id, name, description) values (2, 'Juguetes', 'Juguetes de tus heroies favoritos');
insert into types (type_id, name, description) values (3, 'Camisetas', 'Camisetas de tus heroies favoritos');
insert into types (type_id, name, description) values (4, 'Vasos', 'Vasos de tus heroies favoritos');
insert into types (type_id, name, description) values (5, 'Accesorios', 'Accesorios de tus heroies favoritos');

insert into products (product_id, name, description, quantity, price, category_fk, type_fk) values (1000, 'Iron Man Comics', '', 100, 20000.0, 1, 1);
insert into products (product_id, name, description, quantity, price, category_fk, type_fk) values (2000, 'Batman Comics', '', 100, 20000.0, 2, 1);

insert into receipts (receipt_id, total_price, total_quantity, product_fk, user_fk, date) values (1000, 60000, 3, 1000, 1000, '2020-03-01 13:21:39.413');
insert into receipts (receipt_id, total_price, total_quantity, product_fk, user_fk, date) values (1001, 40000, 2, 2000, 1000, '2020-03-01 13:21:39.413');