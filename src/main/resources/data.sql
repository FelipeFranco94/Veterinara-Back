INSERT INTO `especie` (`nmid`, `dsespecie`) VALUES
    (1, 'Perro'),
    (2, 'Gato'),
    (3, 'Pato'),
    (4, 'Ave'),
    (5, 'Otro');

INSERT INTO `duenos_mascotas` (`nmid`, `dsnombre_dueno`, `dstipo_documento`, `nmidentificacion`, `dsciudad`, `dsdireccion`, `nmtelefono`, `dtfecha_registro`) VALUES
    (1, 'Andres Felipe Franco', 'C.C', '124325', 'Bello', 'Calle 1', '3216151559',  '2022-01-01'),
    (2, 'Diego Franco', 'Cédula', '987654321', 'Medellín', 'Carrera 456', '3209876543', '2022-02-15'),
    (3, 'Pedro Garcia', 'Pasaporte', 'ABC123', 'Cali', 'Avenida 789', '3105551234', '2022-03-05'),
    (4, 'Luisa Fernandez', 'Cédula', '456123789', 'Barranquilla', 'Calle 456', '3155556789', '2022-04-20'),
    (5, 'Jorge Ramirez', 'Cédula', '789456123', 'Cartagena', 'Carrera 789', '3107775555', '2022-05-10'),
    (6, 'Ana Gutierrez', 'Cédula', '321654987', 'Bogotá', 'Calle 456', '3205556666', '2022-06-15'),
    (7, 'Carlos Vargas', 'Cédula', '654789123', 'Medellín', 'Carrera 123', '3154443333', '2022-07-02'),
    (8, 'Laura Hernandez', 'Pasaporte', 'DEF456', 'Cali', 'Avenida 456', '3102221111', '2022-08-10'),
    (9, 'Andres Gomez', 'Cédula', '147258369', 'Barranquilla', 'Calle 789', '3208887777', '2022-09-25'),
    (10, 'Camila Rojas', 'Cédula', '369852147', 'Cartagena', 'Carrera 123', '3103332222', '2022-10-18');

INSERT INTO `user` (`nmid`, `dsusername`, `password`, `dsrol`) VALUES
    ('1', 'affranco', '123456', 'admin'),
    ('2', 'user', '123456', 'user');


INSERT INTO `mascotas` (`nmid`, `dsnombre_mascota`, `nmid_especie`, `dsraza`, `dtfecha_nacimiento`, `nmid_dueno`) VALUES
    (1, 'Firulay', 1, 'Bulldog', '2020-01-17', 1),
    (2, 'Jordan', 1, 'Bulldog frances', '2022-10-01', 2),
    (3, 'Toby', 1, 'Pinche miniatura', '2020-06-01',3),
    (4, 'Manchas', 1, 'Pinche miniatura', '2020-08-01', 3),
    (5, 'Luna', 1, 'Pinche miniatura', '2022-09-26', 3),
    (6, 'Simba', 2, 'Bengalí', '2021-01-07', 6),
    (7, 'Rocky', 1, 'Doberman', '2015-08-29', 3),
    (8, 'Nala', 2, 'Sphynx', '2018-12-18', 7),
    (9, 'Charlie', 1, 'Pastor Alemán', '2017-03-11', 2),
    (10, 'Cleo', 2, 'Siamese', '2019-05-06', 8),
    (11, 'Duke', 1, 'Rottweiler', '2016-12-01', 5),
    (12, 'Oreo', 2, 'Sphynx', '2020-08-17', 5),
    (13, 'Bailey', 1, 'Golden Retriever', '2014-10-23', 1),
    (14, 'Loki', 2, 'Birmano', '2017-07-02', 9),
    (15, 'Chico', 1, 'Chihuahua', '2019-02-14', 10),
    (16, 'Luna', 1, 'Golden Retriever', '2018-05-12', 1),
    (17, 'Toby', 2, 'Siamés', '2020-02-23', 5),
    (18, 'Max', 1, 'Labrador', '2019-09-10', 2),
    (19, 'Whiskers', 2, 'Persa', '2017-11-30', 10),
    (20, 'Leno', 2, 'Ch', '2017-11-30', 10),
    (21, 'Buddy', 1, 'Bulldog Francés', '2016-06-15', 1);