package com.academia.controller;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import org.primefaces.component.picklist.PickList;
import org.primefaces.model.DualListModel;

import com.academia.hibernate.Asignatura;

@FacesConverter("asignaturaPickListConverter")
public class AsignaturaPickListConverter implements Converter {

	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {

		return getObjectFromUIPickListComponent(component, value);
	}

	public String getAsString(FacesContext context, UIComponent component,
			Object object) {
		String string;
		if (object == null) {
			string = "";
		} else {
			try {
				string = String
						.valueOf(((Integer) object));
			} catch (ClassCastException cce) {
				throw new ConverterException();
			}
		}
		return string;
	}

	@SuppressWarnings("unchecked")
	private Asignatura getObjectFromUIPickListComponent(UIComponent component,
			String value) {
		final DualListModel<Asignatura> dualList;
		try {
			dualList = (DualListModel<Asignatura>) ((PickList) component)
					.getValue();
			Asignatura asig = getObjectFromList(dualList.getSource(),
					Integer.valueOf(value));
			if (asig == null) {
				asig = getObjectFromList(dualList.getTarget(),
						Integer.valueOf(value));
			}

			return asig;
		} catch (ClassCastException cce) {
			throw new ConverterException();
		} catch (NumberFormatException nfe) {
			throw new ConverterException();
		}
	}

	private Asignatura getObjectFromList(final List<?> list,
			final Integer identifier) {
		for (final Object object : list) {
			final Asignatura asig = (Asignatura) object;
			if (asig.getIdAsignatura().equals(identifier)) {
				return asig;
			}
		}
		return null;
	}
}
