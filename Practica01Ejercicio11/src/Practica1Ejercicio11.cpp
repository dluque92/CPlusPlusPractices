//============================================================================
// Name        : Practica1Ejercicio11.cpp
// Author      : David Luque Fernández
// Version     :
// Copyright   : 1º Informática A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;
float teoria,practica,final;
int main() {
	cout << "Programa para calcular la nota final.\n";
	cout << "Introduce la nota de la parte teorica: ";
	cin >> teoria;
	teoria=teoria*0.7;
	cout << "Introduce la nota de la parte practica: ";
	cin >> practica;
	practica=practica*0.3;
	final=practica+teoria;
	cout << "La nota final es: " <<final<< endl; // prints
	return 0;
}
