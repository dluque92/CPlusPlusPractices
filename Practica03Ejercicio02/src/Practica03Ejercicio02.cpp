//============================================================================
// Name        : Practica03Ejercicio02.cpp
// Author      : David Luque Fernández
// Version     :
// Copyright   : 1º Informática A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

int main() {
	int nmodelos;
	double suma, precios;
	suma = 0.0;
	cout << "Programa para calcular el precio medio de los coches. \n";
	cout << "Introduce el número de modelos de coche: ";
	cin >> nmodelos;
	for(int i= 1; i <= nmodelos; i++){
		cout <<"Precio modelo "<<i<<":";
		cin >> precios;
		suma = suma + precios;
	}
	cout << "El valor medio de los " << nmodelos << " modelos de coche asciende a: "
			<< suma/nmodelos <<" €";
	return 0;
}
