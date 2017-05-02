
public class Clase1 implements Comparar
{
	
	// DECLARACION DE ATRIBUTOS
	
	String nombre;
	int edad;
	
	
	// 	GET Y SET

	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}


	//	CONSTRUCTORES 
	
	public Clase1() 
	{
		// TODO Auto-generated constructor stub
	}
	
		
	/**
	 * @param nombre
	 * @param edad
	 */
	public Clase1(String nombre, int edad) 
	{
		super();
		this.nombre = nombre;
		this.edad = edad;
	}


	//	METODOS
	
	/**
	 * 	SOBREESCRIBIMOS EL METODO COMPARANDO DE LA INTERFACE QUE NOS COMPARARA EL OBJETO ACTUAL (THIS) CON EL QUE LE 
	 * 	ENVIEEMOS
	 */
	@Override
	public boolean comparando (Object obj) 
	{
		boolean resultado = false;
		
		if ( this.equals(obj) )
		{
			resultado = true;
		}
		
		return resultado;
	}

	
	/**
	 * 	SOBREESCRIBIMOS EL METODO EQUALS PARA QUE NO NOS COMPARE DIRECCIONES DE MEMORIA
	 */
	@Override
	public boolean equals (Object obj) 
	{
		
		/**
		 * SI EL OBJ ES INSTANCIA DE CLASE 1, Y LOS ATRIBUTOS SON IGUALES, ENTONCES LLEGAMOS A LA CONCLUSION DE QUE LOS
		 * DOS OBJETOS SON IGUALES
		 */
		
        if (obj instanceof Clase1) 
        {
	        Clase1 tmpClase1 = (Clase1) obj;
	        
	        if (this.nombre.equals(tmpClase1.nombre) && this.edad == tmpClase1.edad) 
	        { 
	        	return true; 
	        } 
	        else 
	        { 
	        	return false; 
	        }
	    } 
        else 
        { 
        	return false; 
        }
	} 
	
	
}
