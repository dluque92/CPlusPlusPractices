//============================================================================
// Name        : Practica1Ejercicio2.cpp
// Author      : David Luque Fernández
// Version     :
// Copyright   : 1º Informática A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;
const float tasa = 25.0;
const float PRECIO_HORA = 60.0;
int main(){
	float horas,dias,total,neto;
	cout << "Programa para calcular la cantidad neta y bruta a pagar por un trabajo realizado.\n";
	cout << "Introduzca las horas trabajadas: ";
	cin >> horas;
	cout << "Introduzca los dias trabajados: ";
	cin >> dias;
	total = horas*dias*PRECIO_HORA;
	neto = total-tasa;
	cout << "El valor total a pagar es: ";
	cout << total << endl;
	cout << "El valor neto a pagar es: ";
	cout << neto << endl;
return 0;
}
