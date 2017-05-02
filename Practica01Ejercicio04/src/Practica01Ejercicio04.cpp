//============================================================================
// Name        : Practica1Ejercicio4.cpp
// Author      : David Luque Fernández
// Version     :
// Copyright   : 1º Informática A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

int main() {
	cout << "Programa para saber el tamaño que ocupa en memoria de los diferentes tipos vistos en clase:\n";
	cout << "Tamaño de short: "<<sizeof (short)<< " bytes.\n";
	cout << "Tamaño de unsigned short: "<<sizeof (unsigned short)<< " bytes.\n";
	cout << "Tamaño de int: "<<sizeof (int)<< " bytes.\n";
	cout << "Tamaño de unsigned: "<<sizeof (unsigned)<< " bytes.\n";
	cout << "Tamaño de long: "<<sizeof (long)<< " bytes.\n";
	cout << "Tamaño de unsigned long: "<<sizeof (unsigned long)<< " bytes.\n";
	cout << "Tamaño de float: "<<sizeof (float)<< " bytes.\n";
	cout << "Tamaño de double: " <<sizeof (double)<< " bytes.\n";
	cout << "Tamaño de long double: "<<sizeof (long double)<< " bytes.\n"<< endl;
	return 0;
}
