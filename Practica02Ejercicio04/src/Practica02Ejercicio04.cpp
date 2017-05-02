//============================================================================
// Name        : Practica02Ejercicio04.cpp
// Author      : David Luque Fernández
// Version     :
// Copyright   : 1º Informática A
// Description : Hello World in C++, Ansi-style
//============================================================================
#include <iostream>
using namespace std;
int main() {
	int dia,mes,anio;
	cout << "Programa para escribir las fechas de numeros a letras. \n";
	cout << "Introduce el Dia: ";
	cin >> dia;
	cout << "Introduce el Mes: ";
	cin >> mes;
	cout << "Introduce el Año: ";
	cin >> anio;
	cout << "Dia: " <<dia<< endl;
	cout << "Mes: ";
	switch (mes){
	case 1: cout << "Enero" << endl;
		break;
	case 2: cout << "Febrero" << endl;
		break;
	case 3: cout << "Marzo" << endl;
		break;
	case 4: cout << "Abril" << endl;
		break;
	case 5: cout << "Mayo" << endl;
		break;
	case 6: cout << "Junio"<< endl;
		break;
	case 7: cout << "Julio"<< endl;
		break;
	case 8: cout << "Agosto"<< endl;
		break;
	case 9: cout << "Septiembre"<< endl;
		break;
	case 10: cout << "Octubre"<< endl;
		break;
	case 11: cout << "Noviembre"<< endl;
		break;
	case 12: cout << "Diciembre"<< endl;
		break;
	default: cout << "Has introducido un mes mal"<< endl;
		break;
	}
	cout << "Año: "<<anio <<endl;
	return 0;
}
