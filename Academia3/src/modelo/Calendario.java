package modelo;
// default package
// Generated 13-ago-2014 20:16:51 by Hibernate Tools 3.4.0.CR1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Calendario generated by hbm2java
 */
@Entity
@Table(name = "calendario", catalog = "academia_bd")
public class Calendario implements java.io.Serializable {

	private CalendarioId id;
	private String idEvento;
	private boolean allDay;

	public Calendario() {
	}

	public Calendario(CalendarioId id, String idEvento, boolean allDay) {
		this.id = id;
		this.idEvento = idEvento;
		this.allDay = allDay;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "nombre", column = @Column(name = "NOMBRE", nullable = false, length = 60)),
			@AttributeOverride(name = "startDate", column = @Column(name = "START_DATE", nullable = false, length = 19)),
			@AttributeOverride(name = "endDate", column = @Column(name = "END_DATE", nullable = false, length = 19)) })
	public CalendarioId getId() {
		return this.id;
	}

	public void setId(CalendarioId id) {
		this.id = id;
	}

	@Column(name = "idEVENTO", nullable = false, length = 45)
	public String getIdEvento() {
		return this.idEvento;
	}

	public void setIdEvento(String idEvento) {
		this.idEvento = idEvento;
	}

	@Column(name = "ALL_DAY", nullable = false)
	public boolean isAllDay() {
		return this.allDay;
	}

	public void setAllDay(boolean allDay) {
		this.allDay = allDay;
	}

}
