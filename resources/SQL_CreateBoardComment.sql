CREATE TABLE `boardComment` (
	`id` BIGINT NOT NULL DEFAULT 0,
	`comment` VARCHAR(50) NOT NULL DEFAULT '0',
	`userId` BIGINT NOT NULL DEFAULT 0,
	`postId` BIGINT NOT NULL DEFAULT 0,
	`createDate` DATE NOT NULL,
	PRIMARY KEY (`id`)
);