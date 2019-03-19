CREATE TABLE `task` (
  `id`  varchar(255) NOT NULL,
  `title` varchar(255),
  `description` varchar(255),
  `started` boolean,
  `completed` boolean,
   primary key (`id`)
  );
