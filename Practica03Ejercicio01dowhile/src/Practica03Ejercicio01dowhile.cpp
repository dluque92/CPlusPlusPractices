//============================================================================
// Name        : Practica03Ejercicio01dowhile.cpp
// Author      : David Luque Fern�ndez
// Version     :
// Copyright   : 1� Inform�tica A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;
//DO WHILE
int main() {
	int n1;
	unsigned suma;
	cout << "Programa para calcular la suma de los N primeros n�meros positivos. \n";
	cout << "Introduce el n�mero : ";
	cin >> n1;
	suma = 0;
	unsigned i = 1;
	do{
		suma = suma +i;
		i++;
	}while(i <= n1);
		cout << "La suma es " << suma << endl;
	return 0;
}
