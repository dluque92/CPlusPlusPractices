//============================================================================
// Name        : Practica03Ejercicio04.cpp
// Author      : David Luque Fernández
// Version     :
// Copyright   : 1º Informática A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

int main() {
	char caracter;
	int n1;
	n1 = 0;
	cout << "Programa para saber la posición ASCI de cada caracter y el numero total de caracteres introducidos. \n";
	cout << "Introduce una frase o palabra acabada en un punto '.' :";
	cin >> caracter;
	while(caracter != '.'){
		cout << "Posición en la tabla ASCII de " << caracter << " es: "
				<< int(caracter) << endl;
		n1++;
		cin >> caracter;
	 }
	cout << endl;
	cout << "Se han leído "<< n1 << " caracteres.";
	return 0;
}
