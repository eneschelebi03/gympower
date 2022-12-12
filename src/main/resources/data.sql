INSERT INTO user_roles (id, role)
VALUES (1, 'ADMIN'),
       (2, 'MODERATOR'),
       (3, 'USER'),
       (4, 'GUEST');

INSERT INTO order_statuses (id, status_name)
VALUES (1, 'PENDING'),
       (2, 'SHIPPING'),
       (3, 'COMPLETED');


INSERT INTO addresses (id, city, country, post_code, street_address)
VALUES (1, 'Madan', 'Bulgaria', '4900', 'Yanovska 48'),
       (2, 'Smolyan', 'Bulgaria', '4700', 'Rapublika 69'),
       (3, 'London', 'United Kingdom', 'EC1A', 'Apple str. 12B'),
       (4, 'Bucharest', 'Romania', '010001', 'Btistei str. 42'),
       (5, 'Sofia', 'Bulgaria', '1000', 'Ivna Vazov str. 17');

INSERT INTO pictures (id, title, url)
VALUES  (7, 'Vitamins Offer', '/pictures/vitamins_discount.png'),
        (8, 'Hoodie And T-Shirt Offer', '/pictures/hoodie_discount.jpg'),
        (9, 'Mens Shorts Offer', '/pictures/shorts_discount.jpg'),
        (10, 'Mens Shirts Offer', '/pictures/shirts_discount.webp'),
        (11, 'Women Leggings Offer', '/pictures/leggings_discount.jpg');


INSERT INTO exclusives(id, discount_percent, end, is_active, start, title, exclusive_picture_id)
VALUES (1, 10, '2022-11-27 00:00:00', 1, '2022-11-17 00:00:00', 'Vitamins discount', 8),
       (2, 15, '2022-11-27 00:00:00', 1, '2022-11-16 00:00:00', 'Hoodie and T-shirt discount', 7),
       (3, 60, '2022-11-27 00:00:00', 1, '2022-11-17 00:00:00', 'Mens Shorts discount', 9),
       (4, 50, '2022-11-27 00:00:00', 1, '2022-11-17 00:00:00', 'Mens Shirt discount', 10),
       (5, 30, '2022-11-27 00:00:00', 1, '2022-11-17 00:00:00', 'Women Leggings discount', 11);

INSERT INTO exclusives_discounted_categories(exclusive_offer_id, discounted_categories_id)
VALUES (1, 16),
       (1, 15),
       (2, 8),
       (3, 11),
       (3, 20),
       (4, 11),
       (4, 23),
       (5, 12),
       (5, 19);


