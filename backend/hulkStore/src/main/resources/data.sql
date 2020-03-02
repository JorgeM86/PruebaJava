insert into users (user_id, user_type, name, last_name, gender, cellphone, email, password, birth_date, registration_date) values (1000, 1, 'Tony', 'Stark', 'Masculino', '123456789', 'admin@email.com', '$2a$10$bK48sgKQLdE6DjLS7tKYF.s90DOoikdab50yc7tvq59/SBDC9NVNO', '1990-03-23', '2020-03-01 13:21:39.413');
insert into users (user_id, user_type, name, last_name, gender, cellphone, email, password, birth_date, registration_date) values (2000, 2, 'User1', 'User1', 'Masculino', '123456789', 'user1@email.com', '$2a$10$bK48sgKQLdE6DjLS7tKYF.s90DOoikdab50yc7tvq59/SBDC9NVNO', '1990-03-23', '2020-03-01 13:21:39.413');

insert into categories (category_id, name, description) values (1, 'Marvel', 'Heroes del Marvel Universe');
insert into categories (category_id, name, description) values (2, 'DC Comics', 'Heroes de DC Comics');
insert into categories (category_id, name, description) values (3, 'Otros', 'Heroes de la comunidad');

insert into types (type_id, name, description) values (1, 'Comics', 'Comics de tus heroies favoritos');
insert into types (type_id, name, description) values (2, 'Juguetes', 'Juguetes de tus heroies favoritos');
insert into types (type_id, name, description) values (3, 'Camisetas', 'Camisetas de tus heroies favoritos');
insert into types (type_id, name, description) values (4, 'Vasos', 'Vasos de tus heroies favoritos');
insert into types (type_id, name, description) values (5, 'Accesorios', 'Accesorios de tus heroies favoritos');

insert into products (product_id, name, description, quantity, price, category_fk, type_fk) values (1000, 'Iron Man Comics', '', 100, 20000.0, 1, 1);
insert into products (product_id, name, description, quantity, price, category_fk, type_fk) values (2000, 'Iron Man Juguete 1', '', 100, 25000, 1, 2);
insert into products (product_id, name, description, quantity, price, category_fk, type_fk) values (3000, 'Iron Man Camiseta 1', '', 100, 30000, 1, 3);
insert into products (product_id, name, description, quantity, price, category_fk, type_fk) values (4000, 'Iron Man Vaso 1', '', 100, 20000, 1, 4);
insert into products (product_id, name, description, quantity, price, category_fk, type_fk) values (5000, 'Iron Man Accesorio 1', '', 100, 15000, 1, 5);
insert into products (product_id, name, description, quantity, price, category_fk, type_fk) values (6000, 'Iron Man Comics', '', 100, 20000, 1, 1);
insert into products (product_id, name, description, quantity, price, category_fk, type_fk) values (7000, 'Iron Man Juguete 2', '', 100, 25000, 1, 2);
insert into products (product_id, name, description, quantity, price, category_fk, type_fk) values (8000, 'Iron Man Camiseta 2', '', 100, 30000, 1, 3);
insert into products (product_id, name, description, quantity, price, category_fk, type_fk) values (9000, 'Iron Man Vaso 2', '', 100, 20000, 1, 4);
insert into products (product_id, name, description, quantity, price, category_fk, type_fk) values (10000, 'Iron Man Accesorio 2', '', 100, 15000, 1, 5);

insert into products (product_id, name, description, quantity, price, category_fk, type_fk) values (11000, 'Capitan America Comics', '', 100, 20000, 1, 1);
insert into products (product_id, name, description, quantity, price, category_fk, type_fk) values (12000, 'Capitan America Juguete 1', '', 100, 25000, 1, 2);
insert into products (product_id, name, description, quantity, price, category_fk, type_fk) values (13000, 'Capitan America Camiseta 1', '', 100, 30000, 1, 3);
insert into products (product_id, name, description, quantity, price, category_fk, type_fk) values (14000, 'Capitan America Vaso 1', '', 100, 20000, 1, 4);
insert into products (product_id, name, description, quantity, price, category_fk, type_fk) values (15000, 'Capitan America Accesorio 1', '', 100, 15000, 1, 5);
insert into products (product_id, name, description, quantity, price, category_fk, type_fk) values (16000, 'Capitan America Comics', '', 100, 20000, 1, 1);
insert into products (product_id, name, description, quantity, price, category_fk, type_fk) values (17000, 'Capitan America Juguete 2', '', 100, 25000, 1, 2);
insert into products (product_id, name, description, quantity, price, category_fk, type_fk) values (18000, 'Capitan America Camiseta 2', '', 100, 30000, 1, 3);
insert into products (product_id, name, description, quantity, price, category_fk, type_fk) values (19000, 'Capitan America Vaso 2', '', 100, 20000, 1, 4);
insert into products (product_id, name, description, quantity, price, category_fk, type_fk) values (20000, 'Capitan America Accesorio 2', '', 100, 15000, 1, 5);

insert into products (product_id, name, description, quantity, price, category_fk, type_fk) values (21000, 'Thor Comics', '', 100, 20000, 1, 1);
insert into products (product_id, name, description, quantity, price, category_fk, type_fk) values (22000, 'Thor Juguete 1', '', 100, 25000, 1, 2);
insert into products (product_id, name, description, quantity, price, category_fk, type_fk) values (23000, 'Thor Camiseta 1', '', 100, 30000, 1, 3);
insert into products (product_id, name, description, quantity, price, category_fk, type_fk) values (24000, 'Thor Vaso 1', '', 100, 20000, 1, 4);
insert into products (product_id, name, description, quantity, price, category_fk, type_fk) values (25000, 'Thor Accesorio 1', '', 100, 15000, 1, 5);
insert into products (product_id, name, description, quantity, price, category_fk, type_fk) values (26000, 'Thor Comics', '', 100, 20000, 1, 1);
insert into products (product_id, name, description, quantity, price, category_fk, type_fk) values (27000, 'Thor Juguete 2', '', 100, 25000, 1, 2);
insert into products (product_id, name, description, quantity, price, category_fk, type_fk) values (28000, 'Thor Camiseta 2', '', 100, 30000, 1, 3);
insert into products (product_id, name, description, quantity, price, category_fk, type_fk) values (29000, 'Thor Vaso 2', '', 100, 20000, 1, 4);
insert into products (product_id, name, description, quantity, price, category_fk, type_fk) values (30000, 'Thor Accesorio 2', '', 100, 15000, 1, 5);

insert into products (product_id, name, description, quantity, price, category_fk, type_fk) values (31000, 'Super Man Comics', '', 100, 20000, 2, 1);
insert into products (product_id, name, description, quantity, price, category_fk, type_fk) values (32000, 'Super Man Juguete 1', '', 100, 25000, 2, 2);
insert into products (product_id, name, description, quantity, price, category_fk, type_fk) values (33000, 'Super Man Camiseta 1', '', 100, 30000, 2, 3);
insert into products (product_id, name, description, quantity, price, category_fk, type_fk) values (34000, 'Super Man Vaso 1', '', 100, 20000, 2, 4);
insert into products (product_id, name, description, quantity, price, category_fk, type_fk) values (35000, 'Super Man Accesorio 1', '', 100, 15000, 2, 5);
insert into products (product_id, name, description, quantity, price, category_fk, type_fk) values (36000, 'Super Man Comics', '', 100, 20000, 2, 1);
insert into products (product_id, name, description, quantity, price, category_fk, type_fk) values (37000, 'Super Man 2', '', 100, 25000, 2, 2);
insert into products (product_id, name, description, quantity, price, category_fk, type_fk) values (38000, 'Super Man 2', '', 100, 30000, 2, 3);
insert into products (product_id, name, description, quantity, price, category_fk, type_fk) values (39000, 'Super Man Vaso 2', '', 100, 20000, 2, 4);
insert into products (product_id, name, description, quantity, price, category_fk, type_fk) values (40000, 'Super Man Accesorio 2', '', 100, 15000, 2, 5);

insert into products (product_id, name, description, quantity, price, category_fk, type_fk) values (41000, 'Batman Comics', '', 100, 20000, 2, 1);
insert into products (product_id, name, description, quantity, price, category_fk, type_fk) values (42000, 'Batman Juguete 1', '', 100, 25000, 2, 2);
insert into products (product_id, name, description, quantity, price, category_fk, type_fk) values (43000, 'Batman Camiseta 1', '', 100, 30000, 2, 3);
insert into products (product_id, name, description, quantity, price, category_fk, type_fk) values (44000, 'Batman Vaso 1', '', 100, 20000, 2, 4);
insert into products (product_id, name, description, quantity, price, category_fk, type_fk) values (45000, 'Batman Accesorio 1', '', 100, 15000, 2, 5);
insert into products (product_id, name, description, quantity, price, category_fk, type_fk) values (46000, 'Batman Comics', '', 100, 20000, 2, 1);
insert into products (product_id, name, description, quantity, price, category_fk, type_fk) values (47000, 'Batman Juguete 2', '', 100, 25000, 2, 2);
insert into products (product_id, name, description, quantity, price, category_fk, type_fk) values (48000, 'Batman Camiseta 2', '', 100, 30000, 2, 3);
insert into products (product_id, name, description, quantity, price, category_fk, type_fk) values (49000, 'Batman Vaso 2', '', 100, 20000, 2, 4);
insert into products (product_id, name, description, quantity, price, category_fk, type_fk) values (50000, 'Batman Accesorio 2', '', 100, 15000, 2, 5);

insert into products (product_id, name, description, quantity, price, category_fk, type_fk) values (51000, 'Wonder Woman Comics', '', 100, 20000, 2, 1);
insert into products (product_id, name, description, quantity, price, category_fk, type_fk) values (52000, 'Wonder Woman Juguete 1', '', 100, 25000, 2, 2);
insert into products (product_id, name, description, quantity, price, category_fk, type_fk) values (53000, 'Wonder Woman Camiseta 1', '', 100, 30000, 2, 3);
insert into products (product_id, name, description, quantity, price, category_fk, type_fk) values (54000, 'Wonder Woman Vaso 1', '', 100, 20000, 2, 4);
insert into products (product_id, name, description, quantity, price, category_fk, type_fk) values (55000, 'Wonder Woman Accesorio 1', '', 100, 15000, 2, 5);
insert into products (product_id, name, description, quantity, price, category_fk, type_fk) values (56000, 'Wonder Woman Comics', '', 100, 20000, 2, 1);
insert into products (product_id, name, description, quantity, price, category_fk, type_fk) values (57000, 'Wonder Woman Juguete 2', '', 100, 25000, 2, 2);
insert into products (product_id, name, description, quantity, price, category_fk, type_fk) values (58000, 'Wonder Woman Camiseta 2', '', 100, 30000, 2, 3);
insert into products (product_id, name, description, quantity, price, category_fk, type_fk) values (59000, 'Wonder Woman 2', '', 100, 20000, 2, 4);
insert into products (product_id, name, description, quantity, price, category_fk, type_fk) values (60000, 'Wonder Woman Accesorio 2', '', 100, 15000, 2, 5);

insert into receipts (receipt_id, total_price, total_quantity, product_fk, user_fk, date) values (1000, 60000, 3, 1000, 2000, '2020-03-01 13:21:39.413');
insert into receipts (receipt_id, total_price, total_quantity, product_fk, user_fk, date) values (1001, 40000, 2, 1000, 2000, '2020-03-01 13:21:39.413');