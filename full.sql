START TRANSACTION;
DROP TABLE IF EXISTS products;
CREATE TABLE products (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(255) NULL,
  `cost` FLOAT NULL,
  PRIMARY KEY (`id`));
INSERT INTO `spring_course`.`products` (`title`, `cost`) VALUES
('one', '110'),
('two', '220'),
('three', '330'),
('four', '440'),
('five', '550');
COMMIT;