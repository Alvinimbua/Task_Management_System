CREATE TABLE IF NOT EXISTS `task` (
    `task_id` int AUTO_INCREMENT  PRIMARY KEY,
    `name` varchar(100) NOT NULL,
    `description` varchar(100) NOT NULL,
    `task_status` varchar(20) NOT NULL,
    `created_at` date NOT NULL,
    `updated_at` date DEFAULT NULL
    );