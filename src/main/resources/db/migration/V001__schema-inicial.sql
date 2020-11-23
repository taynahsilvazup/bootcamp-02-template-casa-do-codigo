CREATE TABLE IF NOT EXISTS `casadocodigo`.`autor` (
    `autor_id` BIGINT NOT NULL AUTO_INCREMENT,
    `nome` VARCHAR(160) NOT NULL,
    `email` VARCHAR(254) NOT NULL,
    `descricao` VARCHAR(400) NOT NULL,
    `data_registro` DATETIME NOT NULL,
    PRIMARY KEY (`autor_id`))
ENGINE = InnoDB;