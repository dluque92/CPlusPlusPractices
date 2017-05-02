//============================================================================
// Name        : Practica08Ejercicio01.cpp
// Author      : David Luque Fernández
// Version     :
// Copyright   : 1º Informática A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
#include <string>
using namespace std;

int main() {
	string dato;
	unsigned dato2;
	cout << "Programa que te convierte un string a unsigned."<<endl;
	cout << "Introduce el string: ";
	cin >> dato;
	cout << "Salida: ";
	dato2=(dato[0])-48;
	for(unsigned i=1;i<dato.size();i++){
		dato2=dato2*10;
		dato2=dato2+dato[i]-48;
	}
	cout << dato2;
}
