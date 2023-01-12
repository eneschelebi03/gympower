INSERT INTO user_roles (id, userRole)
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


