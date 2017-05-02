use academia_bd;

--
-- Data for table `asignatura`
--

/*!40000 ALTER TABLE `asignatura` DISABLE KEYS */;
INSERT INTO `asignatura` (`idASIGNATURA`,`HORARIO`,`NOMBRE`,`AULA`) VALUES 
 (1,'9 a 11','Matematicas','A'),
 (2,'11 a 13','Filosofia','B'),
 (3,'13 a 15','Lengua','C'),
 (4,'15 a 17','Historia','D');
/*!40000 ALTER TABLE `asignatura` ENABLE KEYS */;

--
-- Data for table `alumno`
--

/*!40000 ALTER TABLE `alumno` DISABLE KEYS */;
INSERT INTO `alumno` (`idALUMNO`,`NOMBRE`,`APELLIDOS`,`TELEFONO`,`EMAIL`) VALUES 
 (1,'Antonio','Luna Cuesta','650678678','lunacuesta@hotmail.com'),
 (2,'Cristobal','Colon Ariel','600333777','colon82@hotmail.com'),
 (3,'Ivan','Helguera Gato','611223344','ivan.helguera@gmail.com'),
 (4,'Mateos','Povedilla Gaton','600879898','povedilla.g@gmail.com'),
 (5,'Carmen','Lomana Lomonaco','600549191','lomana@gmail.com'),
 (6,'Ana','Torroja Montes','656756453','ana.torroja@hotmail.com'),
 (7,'Antonio','Martin Martin','656753246','antonio@hotmail.com'),
 (8,'Rafa','Pérez Nuñez','643123123','rafa@hotmail.com'),
 (9,'Emilio','Tabares Montes','665643447','Emilio@hotmail.com'),
 (10,'Sonia','Muñoz Martin','634543543','sonia@hotmail.com'),
 (11,'Jose','Ruiz Ruiz','634123123','jose@hotmail.com');
/*!40000 ALTER TABLE `alumno` ENABLE KEYS */;

--
-- Data for table `profesor`
--

/*!40000 ALTER TABLE `profesor` DISABLE KEYS */;
INSERT INTO `profesor` (`idPROFESOR`,`NOMBRE`,`APELLIDOS`,`TELEFONO`,`EMAIL`,`idASIGNATURA`) VALUES 
 (1,'Jacobo','Garcia Rios','669345678','jacobo@hotmail.com',1),
 (2,'Miguel','Sanchez Mayor','600123456','mayor@gmail.com',2),
 (3,'Carlos','Fuentes Alcazaba','610456789','fuentes.alcazaba@gmail.com',3),
 (4,'Felipe','Romero Puente','623765432','felipe.romero@gmail.com',4);
/*!40000 ALTER TABLE `profesor` ENABLE KEYS */;

--
-- Data for table `rel_alumno_asignatura`
--

/*!40000 ALTER TABLE `rel_alumno_asignatura` DISABLE KEYS */;
INSERT INTO `rel_alumno_asignatura` (`idRELACION`,`idASIGNATURA`,`idALUMNO`) VALUES 
 (1,1,1),
 (2,1,2),
 (3,1,3),
 (4,2,1),
 (5,2,4),
 (6,3,1),
 (7,3,3),
 (8,3,5),
 (9,4,5),
 (10,4,6);
/*!40000 ALTER TABLE `rel_alumno_asignatura` ENABLE KEYS */;

--
-- Dumping data for table `calendario`
--

/*!40000 ALTER TABLE `calendario` DISABLE KEYS */;
INSERT INTO `calendario` (`idEVENTO`,`NOMBRE`,`START_DATE`,`END_DATE`,`ALL_DAY`) VALUES 
 ('6d6c52bb-6bee-4bf0-8ed4-3a209dc0d210','Matematicas','2014-08-12 16:18:00','2014-08-13 23:00:00',0),
 ('9b0ac982-9f90-4285-aada-b1d2790c9897','Filosofia','2014-08-14 16:18:00','2014-08-15 23:00:00',0),
 ('0a065a1c-1604-4a1f-a594-2ec51cfe21f2','Lengua','2014-08-16 16:18:00','2014-08-16 16:18:00',1),
 ('39597d8c-be4e-471a-a0c8-b29ac823b9f6','Historia','2014-08-18 16:18:00','2014-08-19 16:18:00',0);
/*!40000 ALTER TABLE `calendario` ENABLE KEYS */;