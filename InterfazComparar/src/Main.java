
public class Main 
{

	public static void main(String[] args) 
	{
		
		//	CREAMOS LOS OBJETOS DE LA CLASE1 CON SUS ATRIBUTOS
		
		Clase1 emilio = new Clase1("Emilio",36);
		
		Clase1 paky = new Clase1("Emilio",30);
		
		
		//	VISUALIZO EL RESULTADO DEL METODO COMPARANDO ENTRE EL OBJETO EMILIO Y EL OBJETO PAKY DE LA CLASE1
		
		System.out.println(emilio.comparando(paky));

	}

}
