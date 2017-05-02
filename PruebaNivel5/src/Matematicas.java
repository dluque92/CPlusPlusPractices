import java.util.List;

public class Matematicas implements Asignatura {

	@Override
	public double obtenerNotaMedia(List<Double> parciales) {
		double notaMedia = 0.0;

		// VERIFICAMOS QUE LA LISTA NO SEA NULA Y QUE NO EST� VAC�A
		if (parciales != null && parciales.size() > 0) {
			// VAMOS SUMANDO CADA ELEMENTO O NOTA DE LA LISTA
			for (int i = 0; i < parciales.size(); i++) {
				notaMedia = notaMedia + parciales.get(i);
			}
			// CUANDO SALIMOS DEL BUCLE ES PORQUE HEMOS TERMINADO DE RECORRER
			// LA LISTA. PARA SACAR LA MEDIA DIVIDIMOS LA SUMA TOTAL DE NOTAS
			// POR EL N�MERO TOTAL DE ELEMENTOS EN LA LISTA DENOTADO POR
			// LISTA.SIZE()
			notaMedia = notaMedia / parciales.size();
		}

		// DEVOLVEMOS LA NOTA MEDIA CALCULADA
		return notaMedia;

	}

}
