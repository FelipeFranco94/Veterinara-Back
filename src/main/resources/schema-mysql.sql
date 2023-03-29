CREATE TABLE IF NOT EXISTS `duenos_mascotas` (
  `nmid` int(11) NOT NULL AUTO_INCREMENT,
  `dsnombre_dueno` varchar(250) NOT NULL,
  `dstipo_documento` varchar(50) NOT NULL,
  `nmidentificacion` bigint(30) NOT NULL,
  `dsciudad` varchar(150) NOT NULL,
  `dsdireccion` varchar(250) NOT NULL,
  `nmtelefono` bigint(30) NOT NULL,
  `dtfecha_registro` date NOT NULL,
  PRIMARY KEY (`nmid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE IF NOT EXISTS `mascotas` (
  `nmid` int(11) NOT NULL AUTO_INCREMENT,
  `dsnombre_mascota` varchar(250) NOT NULL,
  `nmid_especie` int(11) NOT NULL,
  `dsraza` varchar(150) NOT NULL,
  `dtfecha_nacimiento` date NOT NULL,
  `nmid_dueno` int(11) NOT NULL,
  PRIMARY KEY (`nmid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE IF NOT EXISTS `especie` (
  `nmid` int(11) NOT NULL AUTO_INCREMENT,
  `dsespecie` varchar(100) NOT NULL,
  PRIMARY KEY (`nmid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE IF NOT EXISTS `user` (
  `nmid` int(11) NOT NULL AUTO_INCREMENT,
  `dsusername` varchar(250) NOT NULL,
  `password` varchar(50) NOT NULL,
  `dsrol` varchar(150) NOT NULL,
  PRIMARY KEY (`nmid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


ALTER TABLE `mascotas` ADD CONSTRAINT `FK_mascota_dueno` FOREIGN KEY (`nmid_dueno`) REFERENCES `duenos_mascotas` (`nmid`);
ALTER TABLE `mascotas` ADD CONSTRAINT `FK_especie` FOREIGN KEY (`nmid_especie`) REFERENCES `especie` (`nmid`);
