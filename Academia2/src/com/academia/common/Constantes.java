package com.academia.common;

public class Constantes {

	// CONSTANTES PARA BASE DE DATOS
	public static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
	public static final String DOMAIN = "localhost";
	public static final String PORT = "3306";
	public static final String SCHEMA = "academia_bd";
	public static final String USER_BD = "root";
	public static final String PASSWORD_BD = "Besoftware00";
	public static final String URL_BD = "jdbc:mysql://" + DOMAIN + ":" + PORT
			+ "/" + SCHEMA;

	// NOMBRES DE LAS TABLAS DE LA BASE DE DATOS
	public static final String PROFESOR_TABLE = "profesor";
	public static final String ALUMNO_TABLE = "alumno";
	public static final String ASIGNATURA_TABLE = "asignatura";
	public static final String REL_ALUMNO_ASIGNATURA_TABLE = "rel_alumno_asignatura";
	
	//CONSTANTE CON LA RUTA DEL SERVIDOR
	//La primera constante usa el servlet antiguo, con el m�todo antiguo
	//public static final String URLSERVIDOR = "http://localhost:8080/Academia2/Servlet";
	//Nuevo metodo usando Hibernate
	public static final String URLSERVIDOR = "http://localhost:8080/Academia2/Academia";
	//Direcci�n de los .jsf
	public static final String URLJSF = "http://localhost:8080/Academia2/jsf";

}
