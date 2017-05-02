/**
 * Funcion para rellenar el combobox Campos en función del combo Clases
 */
// Metodo para refrescar los combobox
function borrarComboCampos() {
	// Obtiene la longitud actual del combobox
	var i = document.getElementById('Campos').options.length;
	// Borra todos los items del combobox
	for (i = i - 1; i >= 0; i--) {
		document.getElementById('Campos').remove(
				document.getElementById('Campos').options[i]);
	}
	
}

//Metodo para rellenar el combo  con Id:Campos
function combocampos(a,b) {
	
	//CREAMOS DOS VARIABLES Y LAS PONEMOS VACIAS
	var varcampos="";
	var varprueba="";
	
	//COMPROBAMOS QUE LAS VARIABLES QUE RECOGEMOS NO VENGAN VACIAS
	//Y ASIGNAMOS SU VALOR A LAS VARIABLES QUE HEMOS CREADO
	if (a != null & a != "undefined"){
		varprueba = a;
	}
	
	if (b != null & b != "undefined"){
		varcampos = b;
	}
	
	var index = null;
	
	//COMPROBAMOS SI LA VARIABLE ESTÁ VACÍA O SE HA RELLENADO EN LOS IF
	if (varprueba==""){		
	
	// Crea una variable index y guarda en ella el valor del Index seleccionado
	// en el combobox con nombre "Clases"
		index = document.getElementById('Clases').selectedIndex;
	}
	else{
		//SI LA VARIABLE QUE CREAMOS NO ESTÁ VACIA, RECOGEMOS SU VALOR EN INDEX
		//Y SELECCIONAMOS SU VALOR EN EL PRIMER SELECT DEL BUSCADOR
		document.getElementById('Clases').selectedIndex = varprueba;
		index = varprueba;
		
	}

	// En función del valor de index rellenará el segundo combobox
	//SI INDEX VALE 0 (PRIMER VALOR DEL PRIMER SELECT)
	if (index == 0) {
		//BORRAMOS TODOS LOS CAMPOS DEL SEGUNDO SELECT
		borrarComboCampos();
		// Crea elementos Option para el combobx "Campos"
		opcion0 = new Option("Nombre", "Nombre");
		opcion1 = new Option("Apellidos", "Apellidos");
		opcion2 = new Option("Telefono", "Telefono");
		opcion3 = new Option("Email", "Email");
		opcion4 = new Option("Asignatura", "Asignatura");
		// Rellena el combobox
		document.getElementById('Campos').options[0] = opcion0;
		document.getElementById('Campos').options[1] = opcion1;
		document.getElementById('Campos').options[2] = opcion2;
		document.getElementById('Campos').options[3] = opcion3;
		document.getElementById('Campos').options[4] = opcion4;
		
		//SI LA VARIABLE SEGUNDA QUE CREAMOS NO ESTÁ VACÍA ES QUE VOLVEMOS DE UNA
		//BUSQUEDA Y ENTONCES SELECCIONAMOS EL VALOR QUE VIENE DE LA BUSQUEDA
		if (varcampos != ""){		
				document.getElementById('Campos').selectedIndex = varcampos;		
		}
			

	} else if (index == 1) {

		borrarComboCampos();
		opcion0 = new Option("Nombre", "Nombre");
		opcion1 = new Option("Horario", "Horario");
		opcion2 = new Option("Aula", "Aula");
		document.getElementById('Campos').options[0] = opcion0;
		document.getElementById('Campos').options[1] = opcion1;
		document.getElementById('Campos').options[2] = opcion2;
		if (varcampos != ""){		
				document.getElementById('Campos').selectedIndex= varcampos;	
		}
	} else if (index == 2) {
		borrarComboCampos();
		opcion0 = new Option("Nombre", "Nombre");
		opcion1 = new Option("Apellidos", "Apellidos");
		opcion2 = new Option("Telefono", "Telefono");
		opcion3 = new Option("Email", "Email");
		document.getElementById('Campos').options[0] = opcion0;
		document.getElementById('Campos').options[1] = opcion1;
		document.getElementById('Campos').options[2] = opcion2;
		document.getElementById('Campos').options[3] = opcion3;
		if (varcampos != ""){		
				document.getElementById('Campos').selectedIndex= varcampos;
		}
	}
}
