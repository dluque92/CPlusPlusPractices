/**
 *  Funciones varias para validar los campos de formularios.
 */


//Funcion que comprueba que los campos del formulario de añadir alumno y
//editar alumno no estén vacios y sean validos.
function validacionAlumno() {
	//Recogemos los valores de los campos del formulario
	nombre = document.forms["alumno"]["nombre"].value;
	apellidos = document.forms["alumno"]["apellidos"].value;
	telefono = document.forms["alumno"]["telefono"].value;
	email = document.forms["alumno"]["email"].value;
	
	//El objErrores, es un SPAN que no contiene nada. Si hay errores, los muestro 
	//en este objeto.
	objErrores = document.getElementById("errores");
	var errorSt = "";
	
	//Compruebo cada campo y si no cumple, concateno en una variable el error.
	if( nombre == null || nombre.length == 0 || /^\s+$/.test(nombre) ) {
		errorSt = "El nombre no es v&aacute;lido o est&aacute; vac&iacute;o el campo.<br>";
	}
	if( apellidos == null || apellidos.length == 0 || /^\s+$/.test(apellidos) ) {
		errorSt = errorSt + "Los apellidos no son v&aacute;lidos o est&aacute; vac&iacute;o el campo.<br>";
	}
	expr = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	if(!expr.test(email) ) {
	  errorSt = errorSt + "El email introducido no es v&aacute;lido.<br>";
	}
  if(!telefono.match(/^(6|8|9)[0-9]{8}$/)){
	  errorSt = errorSt + "El tel&eacute;fono introducido no es v&aacute;lido.<br>";
  }
 
  //si la variable está vacia se manda el formulario, sino se muestran los errores.
  if(errorSt != ""){
	  errorSt = errorSt + "<br><br>";
	  objErrores.innerHTML = errorSt;
	  return false;
  }else
	  return true;
}

//Funcion que comprueba que los campos del formulario de añadir y
//editar asignatura no estén vacios y sean validos.
function validacionAsignatura() {
	//Recogemos los valores de los campos del formulario
	nombre = document.forms["asignatura"]["nombre"].value;
	horario = document.forms["asignatura"]["horario"].value;
	aula = document.forms["asignatura"]["aula"].value;
	
	objErrores = document.getElementById("errores");
	var errorSt = "";
	
	if( nombre == null || nombre.length == 0 || /^\s+$/.test(nombre) ) {
		errorSt = errorSt + "El nombre no es v&aacute;lido o est&aacute; vac&iacute;o el campo.<br>";
	}
	if( horario == null || horario.length == 0 || /^\s+$/.test(horario) ) {
		errorSt = errorSt + "El horario no es v&aacute;lido o est&aacute; vac&iacute;o el campo.<br>";
	}
	if( aula == null || aula.length == 0 || /^\s+$/.test(aula) ) {
		errorSt = errorSt + "El aula no es v&aacute;lida o est&aacute; vac&iacute;o el campo.<br>";
	}
	
	if(errorSt != ""){
		  errorSt = errorSt + "<br><br>";
		  objErrores.innerHTML = errorSt;
		  return false;
	  }else
		  return true;
}

//Funcion que comprueba que los campos del formulario de añadir y
//editar profesor no estén vacios, sean validos y tenga una asignatura seleccionada
function validacionProfesor() {
	//Recogemos los valores de los campos del formulario
	nombre = document.forms["profesor"]["nombre"].value;
	apellidos = document.forms["profesor"]["apellidos"].value;
	telefono = document.forms["profesor"]["telefono"].value;
	email = document.forms["profesor"]["email"].value;

	radioButtons = document.forms["profesor"]["idasignatura"]
	
	//El objErrores, es un SPAN que no contiene nada. Si hay errores, los muestro 
	//en este objeto.
	objErrores = document.getElementById("errores");
	var errorSt = "";
	
	//Compruebo cada campo y si no cumple, concateno en una variable el error.
	if( nombre == null || nombre.length == 0 || /^\s+$/.test(nombre) ) {
		errorSt = "El nombre no es v&aacute;lido o est&aacute; vac&iacute;o el campo.<br>";
	}
	if( apellidos == null || apellidos.length == 0 || /^\s+$/.test(apellidos) ) {
		errorSt = errorSt + "Los apellidos no son v&aacute;lidos o est&aacute; vac&iacute;o el campo.<br>";
	}
	expr = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	if(!expr.test(email) ) {
	  errorSt = errorSt + "El email introducido no es v&aacute;lido.<br>";
	}
	if(!telefono.match(/^(6|8|9)[0-9]{8}$/)){
		  errorSt = errorSt + "El tel&eacute;fono introducido no es v&aacute;lido.<br>";
	}
	//Compruebo que haya seleccionada una asignatura
	var ok=0;
	for(i=0; i  <radioButtons.length; i++){
		if(radioButtons[i].checked){
		   ok=1;
		}    
	}
	//Si no ha seleccionado ninguna concateno su error.
	if(ok == 0)
		errorSt = errorSt + "Debe seleccionar una asignatura.<br>";
	
  //si la variable está vacia se manda el formulario, sino se muestran los errores.
  if(errorSt != ""){
	  errorSt = errorSt + "<br><br>";
	  objErrores.innerHTML = errorSt;
	  return false;
  }else
	  return true;
	
}
//Funcion que comprueba lo escrito en el buscador
function comprobart1(){
	var t1 = "";
	//recogemos valor del input
	t1 = document.getElementById('T1').value;

	//Solo aceptamos letras minusculas y mayusculas y numeros, el resto fuera
	t1=t1.replace(/[^a-zA-Z0-9\ @.]/g,'');

	//sobreescribimos el valor del input
	document.getElementById('T1').value = t1;
}
//Funcion para confirmar el envio de un formulario
function confirmar(formulario){
	if(confirm(String.fromCharCode(191)+'Seguro que desea eliminar el elemento?')){
		document.forms[formulario].submit();
		return true;
	}else{
		return false;
	}
}