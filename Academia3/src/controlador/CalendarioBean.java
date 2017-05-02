package controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import modelo.Calendario;
import modelo.CalendarioDAO;
import modelo.CalendarioId;

import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

import common.Constantes;

import vista.AlumnoAdapter;
import vista.CalendarioAdapter;
import vista.LoginAdapter;

@ManagedBean(name = "calendarioBean")
@ViewScoped
public class CalendarioBean implements Serializable {

	private CalendarioAdapter calendarioAdapter = new CalendarioAdapter();
	private List<Calendario> calendario = new ArrayList<Calendario>();
	private ArrayList<CalendarioAdapter> listCalendario = null;

	private ScheduleModel eventModel;

	private ScheduleModel lazyEventModel;

	private ScheduleEvent event = new DefaultScheduleEvent();

	private static String nombreEventAntesModificar;
	private static Date startDateEventAntesModificar;
	private static Date endDateEventAntesModificar;

	private static String nombreEventAntesMover;
	private static Date startDateEventAntesMover;
	private static Date endDateEventAntesMover;

	private static String nombreEventAntesResize;
	private static Date startDateEventAntesResize;
	private static Date endDateEventAntesResize;

	@PostConstruct
	public void init() {

		obtenerEventosCalendario();

		if (listCalendario != null && listCalendario.size() > 0) {
			eventModel = new DefaultScheduleModel();
			for (int i = 0; i < listCalendario.size(); i++) {
				CalendarioAdapter cal = listCalendario.get(i);
				DefaultScheduleEvent event = new DefaultScheduleEvent();
				event.setTitle(cal.getNombre());
				event.setStartDate(cal.getStartDate());
				event.setEndDate(cal.getEndDate());
				event.setAllDay(cal.isAllDay());
				eventModel.addEvent(event);
			}
		}
		
		try {
			FacesContext fc = FacesContext.getCurrentInstance();
			calendarioAdapter = new CalendarioAdapter();
			// System.out.println("-------aasasas------------------");
		
			 UsuariosBean b= new UsuariosBean();
			 LoginAdapter l = b.existeSesion();
			 
			 if(l == null){ 
				 String url = Constantes.URL_BASE_APP; fc.getExternalContext().redirect(url);		 
			 }	 
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Date getRandomDate(Date base) {
		Calendar date = Calendar.getInstance();
		date.setTime(base);
		date.add(Calendar.DATE, ((int) (Math.random() * 30)) + 1); // set random
																	// day of
																	// month

		return date.getTime();
	}

	public Date getInitialDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(calendar.get(Calendar.YEAR), Calendar.FEBRUARY,
				calendar.get(Calendar.DATE), 0, 0, 0);

		return calendar.getTime();
	}

	public ScheduleModel getEventModel() {
		return eventModel;
	}

	public ScheduleModel getLazyEventModel() {
		return lazyEventModel;
	}

	private Calendar today() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
				calendar.get(Calendar.DATE), 0, 0, 0);

		return calendar;
	}

	public ScheduleEvent getEvent() {
		return event;
	}

	public void setEvent(ScheduleEvent event) {
		this.event = event;
	}

	public void addEvent(ActionEvent actionEvent) {
		if (event.getId() == null) {
			eventModel.addEvent(event);
			insertarEventoCalendario(event);

		} else {
			eventModel.updateEvent(event);
			actualizarEventoCalendario(event, nombreEventAntesModificar,
					startDateEventAntesModificar, endDateEventAntesModificar);
		}
		event = new DefaultScheduleEvent();
	}

	public void onEventSelect(SelectEvent selectEvent) {
		event = (ScheduleEvent) selectEvent.getObject();
		nombreEventAntesModificar = event.getTitle();
		startDateEventAntesModificar = event.getStartDate();
		endDateEventAntesModificar = event.getEndDate();
	}

	public void onDateSelect(SelectEvent selectEvent) {
		event = new DefaultScheduleEvent("", (Date) selectEvent.getObject(),
				(Date) selectEvent.getObject());
	}

	public void onEventMove(ScheduleEntryMoveEvent event) {
		ScheduleEvent sch = (ScheduleEvent) event.getScheduleEvent();
		String nombre = sch.getTitle();
		Date startDate = sch.getStartDate();
		Date endDate = sch.getEndDate();

		nombreEventAntesMover = nombre;

		java.util.Calendar newCal = new GregorianCalendar();
		newCal.setTime(startDate);
		newCal.add(Calendar.DATE, (-1 * event.getDayDelta()));
		newCal.add(Calendar.MINUTE, (-1 * event.getMinuteDelta()));
		startDateEventAntesMover = newCal.getTime();

		newCal = new GregorianCalendar();
		newCal.setTime(endDate);
		newCal.add(Calendar.DATE, (-1 * event.getDayDelta()));
		newCal.add(Calendar.MINUTE, (-1 * event.getMinuteDelta()));
		endDateEventAntesMover = newCal.getTime();

		actualizarEventoCalendario(sch, nombreEventAntesMover,
				startDateEventAntesMover, endDateEventAntesMover);

		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Event moved", "Day delta:" + event.getDayDelta()
						+ ", Minute delta:" + event.getMinuteDelta());

		addMessage(message);
	}

	public void onEventResize(ScheduleEntryResizeEvent event) {
		ScheduleEvent sch = (ScheduleEvent) event.getScheduleEvent();
		String nombre = sch.getTitle();
		Date startDate = sch.getStartDate();
		Date endDate = sch.getEndDate();

		nombreEventAntesResize = nombre;

		startDateEventAntesResize = startDate;

		java.util.Calendar newCal = new GregorianCalendar();
		newCal.setTime(endDate);
		newCal.add(Calendar.DATE, (-1 * event.getDayDelta()));
		endDateEventAntesResize = newCal.getTime();

		actualizarEventoCalendario(sch, nombreEventAntesResize,
				startDateEventAntesResize, endDateEventAntesResize);

		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Event resized", "Day delta:" + event.getDayDelta()
						+ ", Minute delta:" + event.getMinuteDelta());

		addMessage(message);
	}

	private void addMessage(FacesMessage message) {
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public List<CalendarioAdapter> obtenerEventosCalendario() {
		listCalendario = new ArrayList<CalendarioAdapter>();
		CalendarioDAO dao = new CalendarioDAO();
		Calendario cal = new Calendario();
		Iterator<Calendario> iterador;
		int n = 0;

		calendario = dao.findAll();
		iterador = calendario.iterator();
		n = 0;
		while (iterador.hasNext()) {
			calendarioAdapter = new CalendarioAdapter(calendario.get(n)
					.getIdEvento(), calendario.get(n).getId().getNombre(),
					calendario.get(n).getId().getStartDate(), calendario.get(n)
							.getId().getEndDate(), calendario.get(n).isAllDay());
			listCalendario.add(calendarioAdapter);
			n++;
			iterador.next();
		}
		return listCalendario;
	}

	public void insertarEventoCalendario(ScheduleEvent event) {
		try {
			Calendario cal = new Calendario();
			CalendarioId id = new CalendarioId();
			cal.setIdEvento(event.getId());
			id.setNombre(event.getTitle());
			id.setStartDate(event.getStartDate());
			id.setEndDate(event.getEndDate());
			cal.setAllDay(event.isAllDay());
			// Metemos el evento en nuestra BD
			cal.setId(id);
			CalendarioDAO dao = new CalendarioDAO();
			dao.persist(cal);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void actualizarEventoCalendario(ScheduleEvent event, String nombre,
			Date startDate, Date endDate) {
		try {
			CalendarioDAO dao = new CalendarioDAO();
			Calendario cal = dao.findEvent(nombre, startDate, endDate);
			if (cal != null) {
				dao.remove(cal);
				Calendario newCal = new Calendario();
				CalendarioId id = new CalendarioId();
				cal.setIdEvento(event.getId());
				id.setNombre(event.getTitle());
				id.setStartDate(event.getStartDate());
				id.setEndDate(event.getEndDate());
				cal.setAllDay(event.isAllDay());
				cal.setId(id);
				// Metemos el evento en nuestra BD

				dao.persist(cal);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}