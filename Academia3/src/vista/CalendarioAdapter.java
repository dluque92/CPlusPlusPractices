package vista;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import modelo.Calendario;

public class CalendarioAdapter implements Serializable {
	private String idEvento;
	private String nombre;
	private Date startDate;
	private Date endDate;
	private boolean allDay;

	private List<Calendario> calendario;
	private List<CalendarioAdapter> caladpter;

	public CalendarioAdapter() {
		// TODO Auto-generated constructor stub
	}

	public CalendarioAdapter(String idEvento, String nombre, Date startDate,
			Date endDate, boolean allDay) {
		super();
		this.idEvento = idEvento;
		this.nombre = nombre;
		this.startDate = startDate;
		this.endDate = endDate;
		this.allDay = allDay;
	}

	public CalendarioAdapter(String idEvento, String nombre, Date startDate,
			Date endDate, boolean allDay, List<Calendario> calendario,
			List<CalendarioAdapter> caladpter) {
		super();
		this.idEvento = idEvento;
		this.nombre = nombre;
		this.startDate = startDate;
		this.endDate = endDate;
		this.allDay = allDay;
		this.calendario = calendario;
		this.caladpter = caladpter;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(String idEvento) {
		this.idEvento = idEvento;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public boolean isAllDay() {
		return allDay;
	}

	public void setAllDay(boolean allDay) {
		this.allDay = allDay;
	}

	public List<Calendario> getCalendario() {
		return calendario;
	}

	public void setCalendario(List<Calendario> calendario) {
		this.calendario = calendario;
	}

	public List<CalendarioAdapter> getCaladpter() {
		return caladpter;
	}

	public void setCaladpter(List<CalendarioAdapter> caladpter) {
		this.caladpter = caladpter;
	}

}
