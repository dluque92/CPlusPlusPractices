//============================================================================
// Name        : Practica03Ejercicio04.cpp
// Author      : David Luque Fern�ndez
// Version     :
// Copyright   : 1� Inform�tica A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

int main() {
	char caracter;
	int n1;
	n1 = 0;
	cout << "Programa para saber la posici�n ASCI de cada caracter y el numero total de caracteres introducidos. \n";
	cout << "Introduce una frase o palabra acabada en un punto '.' :";
	cin >> caracter;
	while(caracter != '.'){
		cout << "Posici�n en la tabla ASCII de " << caracter << " es: "
				<< int(caracter) << endl;
		n1++;
		cin >> caracter;
	 }
	cout << endl;
	cout << "Se han le�do "<< n1 << " caracteres.";
	return 0;
}
