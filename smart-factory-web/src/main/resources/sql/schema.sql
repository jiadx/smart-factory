-- clear context
CREATE TABLE IF NOT EXISTS 'city';
CREATE TABLE IF NOT EXISTS 'user';
-- Create syntax for TABLE 'city'
CREATE TABLE `city` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `province_id` BIGINT(20) DEFAULT NULL ,
  `city_name` VARCHAR(255) DEFAULT NULL ,
  `description` VARCHAR(255) DEFAULT NULL ,
  PRIMARY KEY (`id`)
);

-- Create syntax for TABLE 'user'
CREATE TABLE `user` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `user_name` VARCHAR(255) DEFAULT NULL ,
  `description` VARCHAR(255) DEFAULT NULL ,
  PRIMARY KEY (`id`)
);