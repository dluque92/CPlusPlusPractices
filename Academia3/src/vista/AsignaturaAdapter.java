package vista;

import java.io.Serializable;

import modelo.Profesor;

public class AsignaturaAdapter implements Serializable{
	
		private Integer idAsignatura;
		private String nombre;
		private String horario;
		private String aula;
		private Profesor profesor;
		
		public AsignaturaAdapter() {
			// TODO Auto-generated constructor stub
		}

		public AsignaturaAdapter(Integer idAsignatura, String nombre,
				String horario, String aula, Profesor profesor) {
			
			this.idAsignatura = idAsignatura;
			this.nombre = nombre;
			this.horario = horario;
			this.aula = aula;
			this.profesor = profesor;
		}
		
		public AsignaturaAdapter(Integer idAsignatura, String nombre,
				String horario, String aula) {
			super();
			this.idAsignatura = idAsignatura;
			this.nombre = nombre;
			this.horario = horario;
			this.aula = aula;
		}

		public Integer getIdAsignatura() {
			return idAsignatura;
		}

		public void setIdAsignatura(Integer idAsignatura) {
			this.idAsignatura = idAsignatura;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getHorario() {
			return horario;
		}

		public void setHorario(String horario) {
			this.horario = horario;
		}

		public String getAula() {
			return aula;
		}

		public void setAula(String aula) {
			this.aula = aula;
		}

		public Profesor getProfesor() {
			return profesor;
		}

		public void setProfesor(Profesor profesor) {
			this.profesor = profesor;
		}
		
		
		
		
		
	
	

}
