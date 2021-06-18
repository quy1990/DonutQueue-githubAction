DROP TABLE IF EXISTS orders;

CREATE TABLE `orders` (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  `client_id` int DEFAULT NULL,
  `quantity` int NOT NULL,
  `created_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP
) ;

INSERT INTO `orders` (`id`, `client_id`, `quantity`, `created_date`) VALUES
(1, 1, 1, '2021-05-23 21:33:05'),
(2, 2, 1, '2021-05-23 21:33:50'),
(3, 3, 1, '2021-05-23 21:33:50'),
(4, 4, 1, '2021-05-23 21:33:50'),
(5, 5, 1, '2021-05-23 21:33:50'),
(6, 6, 1, '2021-05-23 21:33:50'),
(7, 7, 1, '2021-05-23 21:33:50'),
(8, 8, 1, '2021-05-23 21:33:50'),
(9, 9, 1, '2021-05-23 21:33:50'),
(10, 10, 1, '2021-05-23 21:33:50');