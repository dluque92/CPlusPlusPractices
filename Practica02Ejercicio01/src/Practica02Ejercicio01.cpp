//============================================================================
// Name        : Practica02Ejercicio01.cpp
// Author      : David Luque Fern�ndez
// Version     :
// Copyright   : 1� Inform�tica A
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;
int num;
int main() {
	cout << "Programa para saber si un n�mero es positivo o negativo\n";
	cout << "Introduce un numero: ";
	cin >> num;
	if (num >= 0){
		cout << "El numero " <<num<< " es positivo" << endl;
	}else{
		cout << "El numero " <<num<< " es negativo" << endl;
	}
	return 0;
}
