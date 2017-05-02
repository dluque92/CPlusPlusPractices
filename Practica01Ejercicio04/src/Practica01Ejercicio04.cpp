//============================================================================
// Name        : Practica1Ejercicio4.cpp
// Author      : David Luque Fern�ndez
// Version     :
// Copyright   : 1� Inform�tica A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

int main() {
	cout << "Programa para saber el tama�o que ocupa en memoria de los diferentes tipos vistos en clase:\n";
	cout << "Tama�o de short: "<<sizeof (short)<< " bytes.\n";
	cout << "Tama�o de unsigned short: "<<sizeof (unsigned short)<< " bytes.\n";
	cout << "Tama�o de int: "<<sizeof (int)<< " bytes.\n";
	cout << "Tama�o de unsigned: "<<sizeof (unsigned)<< " bytes.\n";
	cout << "Tama�o de long: "<<sizeof (long)<< " bytes.\n";
	cout << "Tama�o de unsigned long: "<<sizeof (unsigned long)<< " bytes.\n";
	cout << "Tama�o de float: "<<sizeof (float)<< " bytes.\n";
	cout << "Tama�o de double: " <<sizeof (double)<< " bytes.\n";
	cout << "Tama�o de long double: "<<sizeof (long double)<< " bytes.\n"<< endl;
	return 0;
}
