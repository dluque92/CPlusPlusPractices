//============================================================================
// Name        : FP_relac1_20.cpp
// Author      : David Luque Fern�ndez
// Version     :
// Copyright   : 1� Inform�tica A
// Description : Hello World in C++, Ansi-style
//============================================================================

/*Confecciona un bucle que lea de teclado un texto car�cter a car�cter hasta
 localizar un punto, y que al final d� como salida el n�mero de comas encontradas,
 y el n�mero de caracteres le�dos. */

#include <iostream>
using namespace std;

int main() {
	char caracter;
	unsigned num_carac, num_comas;
	num_carac=0;
	num_comas=0;
	cout << "Programa para saber los caracteres y las comas que hay hasta un punto. \n";
	cout << "Introduce la frase terminada en un punto: \n";
	cin.get(caracter);
	while (caracter!='.'){
		num_carac++;
		if (caracter==','){
			num_comas++;
		}
		cin.get(caracter);
	}
	cout << "Hay "<<num_carac<< " caracteres y "<<num_comas<< " comas." << endl; // prints
	return 0;
}
