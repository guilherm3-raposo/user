CREATE TABLE `user` (
    `id` int(11) AUTO_INCREMENT NULL,
    `username` varchar(255) NOT NULL,
    `password` varchar(255) NOT NULL,
    `avatar` varchar(255) NULL,
    CONSTRAINT user_PK PRIMARY KEY (id)
);