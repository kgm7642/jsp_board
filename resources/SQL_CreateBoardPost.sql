CREATE TABLE `BoardPost` (
	`id` BIGINT NOT NULL AUTO_INCREMENT,
	`subject` VARCHAR(200) NOT NULL,
	`content` TEXT NOT NULL,
	`creatorFullName` CHAR(50) NOT NULL,
	`createDate` DATE NOT NULL,
	PRIMARY KEY (`id`)
)