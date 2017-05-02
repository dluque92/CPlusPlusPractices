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
 (6,'Ana','Torroja Montes','656756453','ana.torroja@hotmail.com');
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