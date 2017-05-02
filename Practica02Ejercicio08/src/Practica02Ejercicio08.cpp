//============================================================================
// Name        : Practica02Ejercicio08.cpp
// Author      : David Luque Fernández
// Version     :
// Copyright   : 1º Informática A
// Description : Hello World in C++, Ansi-style
//============================================================================
#include <iostream>
using namespace std;

int main() {
	int cod, provincia, operacion, control;
	cout << "Introduce el código de cuatro digitos: ";
	cin >> cod;
	if(cod < 1000 || cod > 9999){
		cout << "ERROR: CODIGO INVALIDO.";
	}else{
		provincia = cod%10;
		operacion = ((cod - provincia)/10)%100;
		control = int(cod/1000);
		if(control != operacion%provincia){
			cout << "ERROR: CODIGO INVALIDO.";
		}else{
			cout << "Provincia: " << provincia << endl;
			cout << "Número de Operación: " << operacion << endl;
			cout << "Dígitos de Control: " << control << endl;
		}
	}
	return 0;
}
